package com.globant.javacodecamp.paths;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

  @Test
  void testDistanceWhenOtherIsNull() {
    var point = new Point(BigDecimal.ZERO, BigDecimal.ZERO);

    assertThrows(NullPointerException.class, () -> point.distance(null));
  }

  @Test
  void testDistance() {
    var point = new Point(BigDecimal.ZERO, BigDecimal.ZERO);
    var other = new Point(BigDecimal.ZERO, BigDecimal.ONE);

    assertEquals(BigDecimal.ONE, point.distance(other));
  }
}
