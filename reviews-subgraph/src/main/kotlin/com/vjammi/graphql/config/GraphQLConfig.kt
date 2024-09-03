package com.vjammi.graphql.config

import com.apollographql.federation.graphqljava.Federation
import com.apollographql.federation.graphqljava._Entity
import com.vjammi.graphql.model.BookStub
import graphql.schema.DataFetcher
import graphql.schema.DataFetchingEnvironment
import graphql.schema.GraphQLSchema
import graphql.schema.idl.RuntimeWiring
import graphql.schema.idl.TypeDefinitionRegistry
import org.springframework.boot.autoconfigure.graphql.GraphQlSourceBuilderCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.graphql.execution.ClassNameTypeResolver
import org.springframework.graphql.execution.GraphQlSource.SchemaResourceBuilder
import java.util.function.Function
import java.util.stream.Collectors

@Configuration
class GraphQLConfig {

    @Bean
    fun federationTransform(): GraphQlSourceBuilderCustomizer? {
        val entityDataFetcher: DataFetcher<*> = DataFetcher<Any> {
            env: DataFetchingEnvironment ->
            val representations = env.getArgument<List<Map<String, Object>>>(_Entity.argumentName)
            val bookStubs: List<BookStub> = representations
                                            .stream()
                                            .map(representationsToStub())
                                            .collect(Collectors.toList()) //<BookStub, *, List<BookStub>>
            println(bookStubs)
            bookStubs
        }

        val graphQlSourceBuilderCustomizer = GraphQlSourceBuilderCustomizer {
            builder: SchemaResourceBuilder -> builder.schemaFactory {
                    //registry: TypeDefinitionRegistry?, wiring: RuntimeWiring? ->
                    registry: TypeDefinitionRegistry, wiring: RuntimeWiring ->
                    buildGraphQLSource(entityDataFetcher, registry, wiring)
                }
        }
        return graphQlSourceBuilderCustomizer
    }

    private fun buildGraphQLSource(entityDataFetcher: DataFetcher<*>, registry: TypeDefinitionRegistry, wiring: RuntimeWiring): GraphQLSchema? {
        return Federation.transform(registry, wiring)
            .fetchEntities(entityDataFetcher)
            .resolveEntityType(typeResolver())
            .build()
    }

    private fun typeResolver(): ClassNameTypeResolver? {
        return ClassNameTypeResolver()
    }

    private fun representationsToStub(): Function<Map<String, Object>, BookStub> {
        val representations = Function<Map<String, Object>, BookStub> {
                representation: Map<String, Any> ->
            if ("Book".equals(representation["__typename"])) {
                return@Function BookStub(representation["id"] as String)

            }
            null
        }
        return representations
    }

    //private fun collector(): Collector<BookStub, *, List<BookStub>>? =
    //    Collectors.toList<BookStub>()

}
