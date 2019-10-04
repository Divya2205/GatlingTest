package sims.dell

import actions.dell.DellActions
import com.datastax.driver.core.{ProtocolVersion, SocketOptions}
import com.datastax.gatling.plugin.DsePredef._
import com.datastax.gatling.stress.core.BaseSimulation
import com.datastax.gatling.stress.libs.SimConfig
import io.gatling.core.Predef._
import io.gatling.core.structure.{PopulationBuilder, ScenarioBuilder}

class ReadAllSimulation extends BaseSimulation  {

  val populationBuilderList = new scala.collection.mutable.ListBuffer[PopulationBuilder]()
  val simName = "dell"

//  val builder = cass.getBuilder
//  builder.withProtocolVersion(ProtocolVersion.DSE_V1)
//
//  val socketOptions = new SocketOptions
//  socketOptions.setReadTimeoutMillis(30000)
//  socketOptions.setConnectTimeoutMillis(30000)
//  builder.withSocketOptions(socketOptions)

//  val scenarioName001 = "readPartGsm"
//  val simConf001 = new SimConfig(conf, simName, scenarioName001)
//  val actions001 = new DellActions(cass, simConf001)
//  val feederFile001: String = getDataPath(simConf001)
//  val readFeed001 = csv(feederFile001).random
//  val readScenario001: ScenarioBuilder = scenario(scenarioName001).feed(readFeed001).exec(actions001.readPartGsm);
//  populationBuilderList += loadGenerator.rampUpToPercentage(readScenario001, simConf001)
//
//  val scenarioName002 = "readCosRedAlerts"
//  val simConf002 = new SimConfig(conf, simName, scenarioName002)
//  val actions002 = new DellActions(cass, simConf002)
//  val feederFile002: String = getDataPath(simConf002)
//  val readFeed002 = csv(feederFile002).random
//  val readScenario002: ScenarioBuilder = scenario(scenarioName002).feed(readFeed002).exec(actions002.readCosRedAlerts);
//  populationBuilderList += loadGenerator.rampUpToPercentage(readScenario002, simConf002)
//
//  val scenarioName003 = "readCosRedAlertsCommodity"
//  val simConf003 = new SimConfig(conf, simName, scenarioName003)
//  val actions003 = new DellActions(cass, simConf003)
//  val feederFile003: String = getDataPath(simConf003)
//  val readFeed003 = csv(feederFile003).random
//  val readScenario003: ScenarioBuilder = scenario(scenarioName003).feed(readFeed003).exec(actions003.readCosRedAlertsCommodity);
//  populationBuilderList += loadGenerator.rampUpToPercentage(readScenario003, simConf003)
//
//  val scenarioName004 = "readCosRedAlertsPublishedAlerttype"
//  val simConf004 = new SimConfig(conf, simName, scenarioName004)
//  val actions004 = new DellActions(cass, simConf004)
//  val feederFile004: String = getDataPath(simConf004)
//  val readFeed004 = csv(feederFile004).random
//  val readScenario004: ScenarioBuilder = scenario(scenarioName004).feed(readFeed004).exec(actions004.readCosRedAlertsPublishedAlerttype);
//  populationBuilderList += loadGenerator.rampUpToPercentage(readScenario004, simConf004)
//
//  val scenarioName005 = "readCosRedAlertsPublishedRegion"
//  val simConf005 = new SimConfig(conf, simName, scenarioName005)
//  val actions005 = new DellActions(cass, simConf005)
//  val feederFile005: String = getDataPath(simConf005)
//  val readFeed005 = csv(feederFile005).random
//  val readScenario005: ScenarioBuilder = scenario(scenarioName005).feed(readFeed005).exec(actions005.readCosRedAlertsPublishedRegion);
//  populationBuilderList += loadGenerator.rampUpToPercentage(readScenario005, simConf005)
//
//  val scenarioName006 = "readCosRedAlertsPublishedRootcause"
//  val simConf006 = new SimConfig(conf, simName, scenarioName006)
//  val actions006 = new DellActions(cass, simConf006)
//  val feederFile006: String = getDataPath(simConf006)
//  val readFeed006 = csv(feederFile006).random
//  val readScenario006: ScenarioBuilder = scenario(scenarioName006).feed(readFeed006).exec(actions006.readCosRedAlertsPublishedRootcause);
//  populationBuilderList += loadGenerator.rampUpToPercentage(readScenario006, simConf006)
//
//  val scenarioName007 = "readCosRedAlertsPublishedSite"
//  val simConf007 = new SimConfig(conf, simName, scenarioName007)
//  val actions007 = new DellActions(cass, simConf007)
//  val feederFile007: String = getDataPath(simConf007)
//  val readFeed007 = csv(feederFile007).random
//  val readScenario007: ScenarioBuilder = scenario(scenarioName007).feed(readFeed007).exec(actions007.readCosRedAlertsPublishedSite);
//  populationBuilderList += loadGenerator.rampUpToPercentage(readScenario007, simConf007)
//
//  val scenarioName008 = "readCosRedAlertsPublishedSupplier"
//  val simConf008 = new SimConfig(conf, simName, scenarioName008)
//  val actions008 = new DellActions(cass, simConf008)
//  val feederFile008: String = getDataPath(simConf008)
//  val readFeed008 = csv(feederFile008).random
//  val readScenario008: ScenarioBuilder = scenario(scenarioName008).feed(readFeed008).exec(actions008.readCosRedAlertsPublishedSupplier);
//  populationBuilderList += loadGenerator.rampUpToPercentage(readScenario008, simConf008)
//
//  val scenarioName009 = "readCosRedAlertsRegion"
//  val simConf009 = new SimConfig(conf, simName, scenarioName009)
//  val actions009 = new DellActions(cass, simConf009)
//  val feederFile009: String = getDataPath(simConf009)
//  val readFeed009 = csv(feederFile009).random
//  val readScenario009: ScenarioBuilder = scenario(scenarioName009).feed(readFeed009).exec(actions009.readCosRedAlertsRegion);
//  populationBuilderList += loadGenerator.rampUpToPercentage(readScenario009, simConf009)
//
//  val scenarioName010 = "readCosRedAlertsRootcause"
//  val simConf010 = new SimConfig(conf, simName, scenarioName010)
//  val actions010 = new DellActions(cass, simConf010)
//  val feederFile010: String = getDataPath(simConf010)
//  val readFeed010 = csv(feederFile010).random
//  val readScenario010: ScenarioBuilder = scenario(scenarioName010).feed(readFeed010).exec(actions010.readCosRedAlertsRootcause);
//  populationBuilderList += loadGenerator.rampUpToPercentage(readScenario010, simConf010)
//
//  val scenarioName011 = "readCosRedAlertsSite"
//  val simConf011 = new SimConfig(conf, simName, scenarioName011)
//  val actions011 = new DellActions(cass, simConf011)
//  val feederFile011: String = getDataPath(simConf011)
//  val readFeed011 = csv(feederFile011).random
//  val readScenario011: ScenarioBuilder = scenario(scenarioName011).feed(readFeed011).exec(actions011.readCosRedAlertsSite);
//  populationBuilderList += loadGenerator.rampUpToPercentage(readScenario011, simConf011)
//
//  val scenarioName012 = "readCosRedAlertsSupplier"
//  val simConf012 = new SimConfig(conf, simName, scenarioName012)
//  val actions012 = new DellActions(cass, simConf012)
//  val feederFile012: String = getDataPath(simConf012)
//  val readFeed012 = csv(feederFile012).random
//  val readScenario012: ScenarioBuilder = scenario(scenarioName012).feed(readFeed012).exec(actions012.readCosRedAlertsSupplier);
//  populationBuilderList += loadGenerator.rampUpToPercentage(readScenario012, simConf012)
//
//  val scenarioName013 = "readOpenCosRedAlerts"
//  val simConf013 = new SimConfig(conf, simName, scenarioName013)
//  val actions013 = new DellActions(cass, simConf013)
//  val feederFile013: String = getDataPath(simConf013)
//  val readFeed013 = csv(feederFile013).random
//  val readScenario013: ScenarioBuilder = scenario(scenarioName013).feed(readFeed013).exec(actions013.readOpenCosRedAlerts);
//  populationBuilderList += loadGenerator.rampUpToPercentage(readScenario013, simConf013)
//
//  val scenarioName014 = "readOpenRedAlerts"
//  val simConf014 = new SimConfig(conf, simName, scenarioName014)
//  val actions014 = new DellActions(cass, simConf014)
//  val feederFile014: String = getDataPath(simConf014)
//  val readFeed014 = csv(feederFile014).random
//  val readScenario014: ScenarioBuilder = scenario(scenarioName014).feed(readFeed014).exec(actions014.readOpenRedAlerts);
//  populationBuilderList += loadGenerator.rampUpToPercentage(readScenario014, simConf014)

  val scenarioName015 = "readReportRundates"
  val simConf015 = new SimConfig(conf, simName, scenarioName015)
  val actions015 = new DellActions(cass, simConf015)
  val feederFile015: String = getDataPath(simConf015)
  val readFeed015 = csv(feederFile015).random
  val readScenario015: ScenarioBuilder = scenario(scenarioName015).feed(readFeed015).exec(actions015.readReportRundates);
  populationBuilderList += loadGenerator.rampUpToPercentage(readScenario015, simConf015)

//  val scenarioName016 = "readDscItemCommodityCfgRules"
//  val simConf016 = new SimConfig(conf, simName, scenarioName016)
//  val actions016 = new DellActions(cass, simConf016)
//  val feederFile016: String = getDataPath(simConf016)
//  val readFeed016 = csv(feederFile016).random
//  val readScenario016: ScenarioBuilder = scenario(scenarioName016).feed(readFeed016).exec(actions016.readDscItemCommodityCfgRules);
//  populationBuilderList += loadGenerator.rampUpToPercentage(readScenario016, simConf016)

  val scenarioName017 = "readDscMetadata"
  val simConf017 = new SimConfig(conf, simName, scenarioName017)
  val actions017 = new DellActions(cass, simConf017)
  val feederFile017: String = getDataPath(simConf017)
  val readFeed017 = csv(feederFile017).random
  val readScenario017: ScenarioBuilder = scenario(scenarioName017).feed(readFeed017).exec(actions017.readDscMetadata);
  populationBuilderList += loadGenerator.rampUpToPercentage(readScenario017, simConf017)

//  val scenarioName018 = "readGsmWorkdayHierarchy"
//  val simConf018 = new SimConfig(conf, simName, scenarioName018)
//  val actions018 = new DellActions(cass, simConf018)
//  val feederFile018: String = getDataPath(simConf018)
//  val readFeed018 = csv(feederFile018).random
//  val readScenario018: ScenarioBuilder = scenario(scenarioName018).feed(readFeed018).exec(actions018.readGsmWorkdayHierarchy);
//  populationBuilderList += loadGenerator.rampUpToPercentage(readScenario018, simConf018)
//
//  val scenarioName019 = "readWorkdayEmployeeDetails"
//  val simConf019 = new SimConfig(conf, simName, scenarioName019)
//  val actions019 = new DellActions(cass, simConf019)
//  val feederFile019: String = getDataPath(simConf019)
//  val readFeed019 = csv(feederFile019).random
//  val readScenario019: ScenarioBuilder = scenario(scenarioName019).feed(readFeed019).exec(actions019.readWorkdayEmployeeDetails);
//  populationBuilderList += loadGenerator.rampUpToPercentage(readScenario019, simConf019)
//
//  val scenarioName020 = "readCosRedAlertsExecutiveSummary"
//  val simConf020 = new SimConfig(conf, simName, scenarioName020)
//  val actions020 = new DellActions(cass, simConf020)
//  val feederFile020: String = getDataPath(simConf020)
//  val readFeed020 = csv(feederFile020).random
//  val readScenario020: ScenarioBuilder = scenario(scenarioName020).feed(readFeed020).exec(actions020.readCosRedAlertsExecutiveSummary);
//  populationBuilderList += loadGenerator.rampUpToPercentage(readScenario020, simConf020)
//
//  val scenarioName021 = "readCosRedRulesConditions"
//  val simConf021 = new SimConfig(conf, simName, scenarioName021)
//  val actions021 = new DellActions(cass, simConf021)
//  val feederFile021: String = getDataPath(simConf021)
//  val readFeed021 = csv(feederFile021).random
//  val readScenario021: ScenarioBuilder = scenario(scenarioName021).feed(readFeed021).exec(actions021.readCosRedRulesConditions);
//  populationBuilderList += loadGenerator.rampUpToPercentage(readScenario021, simConf021)
//
//  val scenarioName022 = "readCosRedRulesSettings"
//  val simConf022 = new SimConfig(conf, simName, scenarioName022)
//  val actions022 = new DellActions(cass, simConf022)
//  val feederFile022: String = getDataPath(simConf022)
//  val readFeed022 = csv(feederFile022).random
//  val readScenario022: ScenarioBuilder = scenario(scenarioName022).feed(readFeed022).exec(actions022.readCosRedRulesSettings);
//  populationBuilderList += loadGenerator.rampUpToPercentage(readScenario022, simConf022)
//
//  val scenarioName023 = "readOpenRedAlertsPublished"
//  val simConf023 = new SimConfig(conf, simName, scenarioName023)
//  val actions023 = new DellActions(cass, simConf023)
//  val feederFile023: String = getDataPath(simConf023)
//  val readFeed023 = csv(feederFile023).random
//  val readScenario023: ScenarioBuilder = scenario(scenarioName023).feed(readFeed023).exec(actions023.readOpenRedAlertsPublished);
//  populationBuilderList += loadGenerator.rampUpToPercentage(readScenario023, simConf023)
//
//  val scenarioName024 = "readOpenRedAlertsUnpublished"
//  val simConf024 = new SimConfig(conf, simName, scenarioName024)
//  val actions024 = new DellActions(cass, simConf024)
//  val feederFile024: String = getDataPath(simConf024)
//  val readFeed024 = csv(feederFile024).random
//  val readScenario024: ScenarioBuilder = scenario(scenarioName024).feed(readFeed024).exec(actions024.readOpenRedAlertsUnpublished);
//  populationBuilderList += loadGenerator.rampUpToPercentage(readScenario024, simConf024)
//
//  val scenarioName025 = "readRbacExecutivesDetails"
//  val simConf025 = new SimConfig(conf, simName, scenarioName025)
//  val actions025 = new DellActions(cass, simConf025)
//  val feederFile025: String = getDataPath(simConf025)
//  val readFeed025 = csv(feederFile025).random
//  val readScenario025: ScenarioBuilder = scenario(scenarioName025).feed(readFeed025).exec(actions025.readRbacExecutivesDetails);
//  populationBuilderList += loadGenerator.rampUpToPercentage(readScenario025, simConf025)

  val scenarioName026 = "readStblpartlevel"
  val simConf026 = new SimConfig(conf, simName, scenarioName026)
  val actions026 = new DellActions(cass, simConf026)
  val feederFile026: String = getDataPath(simConf026)
  val readFeed026 = csv(feederFile026).random
  val readScenario026: ScenarioBuilder = scenario(scenarioName026).feed(readFeed026).exec(actions026.readStblpartlevel);
  populationBuilderList += loadGenerator.rampUpToPercentage(readScenario026, simConf026)

  val scenarioName027 = "readStblbusinessunitsummary"
  val simConf027 = new SimConfig(conf, simName, scenarioName027)
  val actions027 = new DellActions(cass, simConf027)
  val feederFile027: String = getDataPath(simConf027)
  val readFeed027 = csv(feederFile027).random
  val readScenario027: ScenarioBuilder = scenario(scenarioName027).feed(readFeed027).exec(actions027.readStblbusinessunitsummary);
  populationBuilderList += loadGenerator.rampUpToPercentage(readScenario027, simConf027)

  setUp(populationBuilderList.toList).protocols(cqlProtocol)

}
