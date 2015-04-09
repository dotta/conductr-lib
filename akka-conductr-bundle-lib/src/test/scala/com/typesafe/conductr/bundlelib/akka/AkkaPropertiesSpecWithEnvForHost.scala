/*
 * Copyright © 2014-2015 Typesafe, Inc. All rights reserved.
 * No information contained herein may be reproduced or transmitted in any form
 * or by any means without the express written permission of Typesafe, Inc.
 */

package com.typesafe.conductr.bundlelib.akka

import com.typesafe.conductr.AkkaUnitTest

class AkkaPropertiesSpecWithEnvForHost extends AkkaUnitTest("AkkaPropertiesSpecWithEnvForHost", "akka.loglevel = INFO") {

  AkkaProperties.initialize()

  "The AkkaProperties functionality in the library" should {
    "return seed properties when running with no other seed nodes" in {
      sys.props.get("akka.cluster.seed-nodes.0") shouldBe Some("akka.tcp://some-system@10.0.1.10:10000")
      sys.props.get("akka.remote.netty.tcp.hostname") shouldBe Some("10.0.1.10")
      sys.props.get("akka.remote.netty.tcp.port") shouldBe Some("10000")
    }
  }
}
