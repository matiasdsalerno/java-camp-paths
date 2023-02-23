package com.globant.javacodecamp.paths;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class SegmentTest {

  @Test
  void testDistance() {
    var segment = new Segment(
            new Point(BigDecimal.ZERO, BigDecimal.ZERO),
            new Point(BigDecimal.ZERO, BigDecimal.ONE)
    );

    assertEquals(BigDecimal.ONE, segment.distance());

    var segment2 = new Segment(
            new Point(BigDecimal.ZERO, BigDecimal.ONE),
            new Point(BigDecimal.ONE, BigDecimal.ONE)
    );

    assertEquals(BigDecimal.ONE, segment2.distance());
  }

  @Test
  void testIncludesPointsWhen1Point() {
    var zeroZero = new Point(BigDecimal.ZERO, BigDecimal.ZERO);
    var segment = new Segment(
            zeroZero,
            new Point(BigDecimal.ZERO, BigDecimal.ONE)
    );

    assertTrue(segment.includesPoint(zeroZero));
  }

  @Test
  void testIncludesPointsWhen1PointNotIncluded() {
    var zeroZero = new Point(BigDecimal.ZERO, BigDecimal.ZERO);
    var oneOne = new Point(BigDecimal.ONE, BigDecimal.ONE);
    var segment = new Segment(
            zeroZero,
            new Point(BigDecimal.ZERO, BigDecimal.ONE)
    );

    assertFalse(segment.includesPoint(oneOne));
  }

}
