package com.globant.javacodecamp.paths;

public record PathWithTransport(
        Path path,
        PublicTransport publicTransport
) {
}
