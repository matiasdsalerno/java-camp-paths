package com.globant.javacodecamp.paths;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class PathService {

  public void findPathWithTransport(List<Point> pointList,
                                                           PathList pathList,
                                                           PublicTransportList publicTransportList,
                                                           PublicTransport.PublicTransportType publicTransportType) {

    pathList.shortestPath(pointList)
            .flatMap(path -> publicTransportList.findFirstPublicTransportForTypeAndPath(publicTransportType, path))
            .ifPresentOrElse(
                    pathWithTransport -> System.out.println("The path found for the Transport was: " + pathWithTransport),
                    () -> System.out.println("There was no path found for that public transport type")
            );
  }

  public static void main(String[] args) {
    var pathService = new PathService();
    var pathList = new PathList(Collections.singletonList(createPath()));
    var publicTransport = createPublicTransport();
    var publicTransportList = new PublicTransportList(Collections.singletonList(publicTransport));

    var points = List.of(
            new Point(BigDecimal.ZERO, BigDecimal.ZERO),
            new Point(BigDecimal.ZERO, BigDecimal.ONE)
    );

    pathService.findPathWithTransport(points, pathList, publicTransportList, PublicTransport.PublicTransportType.UNDERGROUND);
  }

  static Path createPath() {
    return new Path(
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
  }

  static PublicTransport createPublicTransport() {
    var transportPath = new Path(
            List.of(
                    new Segment(
                            new Point(BigDecimal.ZERO, BigDecimal.ZERO),
                            new Point(BigDecimal.ZERO, BigDecimal.ONE)
                    ),
                    new Segment(
                            new Point(BigDecimal.ZERO, BigDecimal.ONE),
                            new Point(BigDecimal.ONE, BigDecimal.ONE)
                    ),
                    new Segment(
                            new Point(BigDecimal.ONE, BigDecimal.ONE),
                            new Point(BigDecimal.TEN, BigDecimal.ONE)
                    ),
                    new Segment(
                            new Point(BigDecimal.TEN, BigDecimal.ONE),
                            new Point(BigDecimal.TEN, BigDecimal.TEN)
                    )
            )
    );

    return new PublicTransport(PublicTransport.PublicTransportType.BUS, transportPath);

  }
}
