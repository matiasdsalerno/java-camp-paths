package com.globant.javacodecamp.paths;

public record PublicTransport(
        PublicTransportType publicTransportType,
        Path path
) {

  public boolean worksForPath(Path otherPath) {
    return this.path.includesPoints(otherPath.firstAndLastPoint());
  }

  public enum PublicTransportType {
    BUS,
    TRAIN,
    TRAM,
    UNDERGROUND
  }
}
