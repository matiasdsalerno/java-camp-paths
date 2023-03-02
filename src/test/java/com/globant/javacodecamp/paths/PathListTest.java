package com.globant.javacodecamp.paths;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PathListTest {

  @Test
  void testShortestPathWhenEmpty()  {

    var pathList = new PathList(Collections.emptyList());
    var optionalPath = pathList.shortestPath();

    assertFalse(optionalPath.isPresent());
  }

  @Test
  void testShortestPath()  {
    var path1 = new Path(
            List.of(
                    new Segment(
                            new Point(BigDecimal.ZERO, BigDecimal.ZERO),
                            new Point(BigDecimal.ZERO, BigDecimal.ZERO)
                    ),
                    new Segment(
                            new Point(BigDecimal.ZERO, BigDecimal.ONE),
                            new Point(BigDecimal.ONE, BigDecimal.ONE)
                    )
            )
    );
    var path2 = new Path(
            List.of(
                    new Segment(
                            new Point(BigDecimal.ZERO, BigDecimal.ZERO),
                            new Point(BigDecimal.ZERO, BigDecimal.ONE)
                    ),
                    new Segment(
                            new Point(BigDecimal.TEN, BigDecimal.ONE),
                            new Point(BigDecimal.ONE, BigDecimal.ONE)
                    )
            )
    );
    var pathList = new PathList(List.of(path1, path2));
    var optionalPath = pathList.shortestPath();

    assertTrue(optionalPath.isPresent());

    assertEquals(path1, optionalPath.get());
  }

  @Test
  void testShortestPathIncludingPoint()  {
    var path1 = new Path(
            List.of(
                    new Segment(
                            new Point(BigDecimal.ZERO, BigDecimal.ZERO),
                            new Point(BigDecimal.ZERO, BigDecimal.ZERO)
                    ),
                    new Segment(
                            new Point(BigDecimal.ZERO, BigDecimal.ONE),
                            new Point(BigDecimal.ONE, BigDecimal.ONE)
                    )
            )
    );
    var includingPoint = new Point(BigDecimal.TEN, BigDecimal.ONE);
    var path2 = new Path(
            List.of(
                    new Segment(
                            new Point(BigDecimal.ZERO, BigDecimal.ZERO),
                            new Point(BigDecimal.ZERO, BigDecimal.ONE)
                    ),
                    new Segment(
                            includingPoint,
                            new Point(BigDecimal.ONE, BigDecimal.ONE)
                    )
            )
    );
    var pathList = new PathList(List.of(path1, path2));
    var optionalPath = pathList.shortestPath(List.of(includingPoint));

    assertTrue(optionalPath.isPresent());

    assertEquals(path2, optionalPath.get());
  }

  @Test
  void testShortestPathIncludingTwoPoints()  {
    var path1 = new Path(
            List.of(
                    new Segment(
                            new Point(BigDecimal.ZERO, BigDecimal.ZERO),
                            new Point(BigDecimal.ZERO, BigDecimal.ZERO)
                    ),
                    new Segment(
                            new Point(BigDecimal.ZERO, BigDecimal.ONE),
                            new Point(BigDecimal.ONE, BigDecimal.ONE)
                    )
            )
    );
    var includingPoint = new Point(BigDecimal.TEN, BigDecimal.ONE);
    var includingPoint2 = new Point(BigDecimal.ONE, BigDecimal.ONE);
    var path2 = new Path(
            List.of(
                    new Segment(
                            new Point(BigDecimal.ZERO, BigDecimal.ZERO),
                            new Point(BigDecimal.ZERO, BigDecimal.ONE)
                    ),
                    new Segment(
                            includingPoint,
                            includingPoint2
                    )
            )
    );
    var pathList = new PathList(List.of(path1, path2));
    var optionalPath = pathList.shortestPath(List.of(includingPoint,  includingPoint2));

    assertTrue(optionalPath.isPresent());

    assertEquals(path2, optionalPath.get());
  }

  @Test
  void testShortestPathNotIncludingPoint()  {
    var path1 = new Path(
            List.of(
                    new Segment(
                            new Point(BigDecimal.ZERO, BigDecimal.ZERO),
                            new Point(BigDecimal.ZERO, BigDecimal.ZERO)
                    ),
                    new Segment(
                            new Point(BigDecimal.ZERO, BigDecimal.ONE),
                            new Point(BigDecimal.ONE, BigDecimal.ONE)
                    )
            )
    );
    var includingPoint = new Point(BigDecimal.TEN, BigDecimal.ONE);
    var path2 = new Path(
            List.of(
                    new Segment(
                            new Point(BigDecimal.ZERO, BigDecimal.ZERO),
                            new Point(BigDecimal.ZERO, BigDecimal.ONE)
                    ),
                    new Segment(
                            includingPoint,
                            new Point(BigDecimal.ONE, BigDecimal.ONE)
                    )
            )
    );
    var pathList = new PathList(List.of(path1, path2));
    var optionalPath = pathList.shortestPath(List.of(new Point(BigDecimal.TEN, BigDecimal.TEN)));

    assertFalse(optionalPath.isPresent());
  }
}
