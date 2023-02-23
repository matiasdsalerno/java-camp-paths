package com.globant.javacodecamp.paths;

import java.math.BigDecimal;
import java.util.List;

public record Segment(Point first,
                      Point second) {

  public BigDecimal distance() {
    return first.distance(second);
  }

  public boolean includesPoint(Point p) {
    return p.equals(first) || p.equals(second);
  }
}
