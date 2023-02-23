package com.globant.javacodecamp.paths;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record Path(List<Segment> segments) {

  public BigDecimal distance() {
    return segments.stream()
            .map(Segment::distance)
            .reduce(BigDecimal::add)
            .orElse(BigDecimal.ZERO);
  }

  public boolean includesPoints(List<Point> points) {
    var pointsInPath = segments
            .stream()
            .flatMap(s -> Stream.of(s.first(), s.second()))
            .collect(Collectors.toSet());

    return pointsInPath.containsAll(points);
  }

  public List<Point> firstAndLastPoint() {
    return List.of(segments.get(0).first(),
            segments.get(segments.size() - 1).second());
  }
}
