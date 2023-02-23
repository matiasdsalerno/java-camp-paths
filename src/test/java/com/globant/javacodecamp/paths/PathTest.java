package com.globant.javacodecamp.paths;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PathTest {

  @Test
  void testDistance() {
    var path = new Path(
            List.of(
                    new Segment(
                            new Point(BigDecimal.ZERO, BigDecimal.ZERO),
                            new Point(BigDecimal.ZERO, BigDecimal.ONE)
                    ),
                    new Segment(
                            new Point(BigDecimal.ZERO, BigDecimal.ONE),
                            new Point(BigDecimal.ONE, BigDecimal.ONE)
                    )
            )
    );

    assertEquals(new BigDecimal(2), path.distance());
  }

  @Test
  void testDistanceWhenPathIsEmpty() {
    var path = new Path(Collections.emptyList());

    assertEquals(BigDecimal.ZERO, path.distance());
  }
}
