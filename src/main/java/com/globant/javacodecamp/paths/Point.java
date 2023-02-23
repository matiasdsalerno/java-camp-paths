package com.globant.javacodecamp.paths;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Objects;

public record Point(BigDecimal x,
                    BigDecimal y) {

  public BigDecimal distance(Point other) {
    Objects.requireNonNull(other);
    return  (this.x.subtract(other.x).pow(2)
            .add(this.y.subtract(other.y).pow(2)))
            .sqrt(MathContext.DECIMAL64);
  }
}
