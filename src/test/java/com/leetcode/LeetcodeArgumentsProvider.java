package com.leetcode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.ParameterDeclaration;
import org.junit.jupiter.params.support.ParameterDeclarations;

import java.io.UncheckedIOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

final class LeetcodeArgumentsProvider implements ArgumentsProvider {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Stream<? extends Arguments> provideArguments(
        ParameterDeclarations parameters,
        ExtensionContext context
    ) throws Exception {
        try (var reader = Files.newBufferedReader(path(context))) {
            return StreamSupport.stream(objectMapper.readTree(reader).spliterator(), false)
                       .map(testCase -> arguments(testCase, parameters(parameters)));
        }
    }

    private Arguments arguments(JsonNode testCase, Map<String, Class<?>> parameters) {
        return Arguments.of(
            testCase.properties()
                .stream()
                .map(entry -> argument(entry.getKey(), entry.getValue(), parameters))
                .toArray()
        );
    }

    private Object argument(String name, JsonNode value, Map<String, Class<?>> parameters) {
        try {
            return objectMapper.treeToValue(value, parameters.get(name));
        } catch (JsonProcessingException e) {
            throw new UncheckedIOException(e);
        }
    }

    private Map<String, Class<?>> parameters(ParameterDeclarations parameterDeclarations) {
        return parameterDeclarations.getAll()
                   .stream()
                   .collect(
                       Collectors.toMap(
                           parameterDeclaration -> parameterDeclaration.getParameterName()
                                                       .orElseThrow(),
                           ParameterDeclaration::getParameterType
                       )
                   );
    }

    private Path path(ExtensionContext context) throws URISyntaxException {
        return Paths.get(
            Objects.requireNonNull(
                    Thread.currentThread()
                        .getContextClassLoader()
                        .getResource(context.getRequiredTestMethod().getName() + ".json")
                )
                .toURI()
        );
    }
}
