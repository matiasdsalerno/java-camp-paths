package com.globant.javacodecamp.paths;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public record PathList(List<Path> paths) {

  public Optional<Path> shortestPath() {
    return shortestPathWithCondition( p -> true);
  }

  public Optional<Path> shortestPath(List<Point> points) {
    return shortestPathWithCondition(p -> p.includesPoints(points));
  }

  private Optional<Path> shortestPathWithCondition(Predicate<Path> condition) {
    return paths.stream()
            .filter(condition)
            .min(Comparator.comparing(Path::distance));
  }

}
