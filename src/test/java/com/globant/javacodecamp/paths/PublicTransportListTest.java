package com.globant.javacodecamp.paths;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PublicTransportListTest {

  @Test
  void testFindFirstTransportForTypeAndPath() {
    var publicTransportList = new PublicTransportList(List.of(
            createPublicTransport()
    ));

    var path = createPath();

    var optionalPathWithTransport = publicTransportList.findFirstPublicTransportForTypeAndPath(PublicTransport.PublicTransportType.BUS, path);

    assertTrue(optionalPathWithTransport.isPresent());
  }


  Path createPath() {
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

  PublicTransport createPublicTransport() {
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
