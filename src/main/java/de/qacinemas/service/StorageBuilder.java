package de.qacinemas.service;

import de.qacinemas.domain.Movie;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StorageBuilder {
    public static List<Movie> build(final Integer size) {
        final int[] i = {0};
        return Stream.generate(() -> {
            i[0]++;
            return new Movie(i[0]);
        }).limit(size).collect(Collectors.toList());
    }
}
