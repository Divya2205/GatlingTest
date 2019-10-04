package sims.dell

import actions.dell.DellActions
import com.datastax.gatling.plugin.CqlPredef._
import com.datastax.gatling.stress.core.BaseSimulation
import com.datastax.gatling.stress.libs.{FetchBaseData, SimConfig}
import io.gatling.core.Predef._

class ReadPartGsmSimulation extends BaseSimulation  {

  val simName = "dell"
  val scenarioName = "readPartGsm"

  val simConf = new SimConfig(conf, simName, scenarioName)

  val dellActions = new DellActions(cass, simConf)

  val feederFile = getDataPath(simConf)
  val csvFeeder = csv(feederFile).random

  val readScenario = scenario("ReadPartGsm")
    .feed(csvFeeder)
    .exec(dellActions.readPartGsm)

  setUp(
    loadGenerator.rampUpToPercentage(readScenario, simConf)
  ).protocols(cqlConfig)
}
