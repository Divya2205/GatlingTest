package actions.dell

import com.datastax.driver.core.{ConsistencyLevel, SimpleStatement}
import com.datastax.driver.core.querybuilder.QueryBuilder
import com.datastax.driver.core.querybuilder.QueryBuilder._
import com.datastax.gatling.plugin.DsePredef._
import com.datastax.gatling.stress.core.BaseAction
import com.datastax.gatling.stress.libs.{Cassandra, SimConfig}
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder

class DellActions(cassandra: Cassandra, simConf: SimConfig) extends BaseAction(cassandra, simConf)  {


  def readPartGsm: ChainBuilder = {

    val queryPartGsm = QueryBuilder
      .select()
      .from(keyspace, table)
      .where(QueryBuilder.eq("usr_nm", raw("?")))
      .and(QueryBuilder.eq("email_addr", raw("?")))
      .and(QueryBuilder.eq("part_nbr", raw("?")))

    val psPartGsm = session.prepare(queryPartGsm)

    group(Groups.SELECT) {
      exec(cql("readPartGsm")
        .executeStatement(psPartGsm)
        .withParams(
          "${usr_nm}",
          "${email_addr}",
          "${part_nbr}"
        )
    //    .check(rowCount greaterThan 0)
      )
    }
  }

  def readCosRedAlerts: ChainBuilder = {

    val query = QueryBuilder
      .select("email_id", "rule_type", "year_month_bucket", "report_date")
      .from(keyspace, table)
      .where(QueryBuilder.eq("email_id", raw("?")))
      .and(QueryBuilder.eq("rule_type", raw("?")))
      .and(QueryBuilder.eq("year_month_bucket", raw("?")))
      .and(QueryBuilder.eq("report_date", raw("?")))

    val preparedStatement = session.prepare(query)

    group(Groups.SELECT) {
      exec(cql("readCosRedAlerts")
        .executeNamed(preparedStatement)
      //  .check(rowCount greaterThan 0)
      )
    }
  }

  def readCosRedAlertsCommodity: ChainBuilder = {

    val query = QueryBuilder
      .select()
      .from(keyspace, table)
      .where(QueryBuilder.eq("email_id", raw("?")))
      .and(QueryBuilder.eq("rule_type", raw("?")))
      .and(QueryBuilder.eq("year_month_bucket", raw("?")))
      .and(QueryBuilder.eq("report_date", raw("?")))
      .and(QueryBuilder.eq("commodity", raw("?")))

    val preparedStatement = session.prepare(query)

    group(Groups.SELECT) {
      exec(cql("readCosRedAlertsCommodity")
        .executeNamed(preparedStatement)
        //.check(rowCount greaterThan 0)
      )
    }
  }

  def readCosRedAlertsPublishedAlerttype: ChainBuilder = {

    //report_date, part_num, alert_type
    val query = QueryBuilder
      .select()
      .from(keyspace, table)
      .where(QueryBuilder.eq("report_date", raw("?")))
      .and(QueryBuilder.eq("part_num", raw("?")))
      .and(QueryBuilder.eq("alert_type", raw("?")))

    val preparedStatement = session.prepare(query)

    group(Groups.SELECT) {
      exec(cql("readCosRedAlertsPublishedAlerttype")
        .executeNamed(preparedStatement)
        //.check(rowCount greaterThan 0)
      )
    }
  }

  def readCosRedAlertsPublishedRegion: ChainBuilder = {

    //report_date, part_num, region
    val query = QueryBuilder
      .select()
      .from(keyspace, table)
      .where(QueryBuilder.eq("report_date", raw("?")))
      .and(QueryBuilder.eq("part_num", raw("?")))
      .and(QueryBuilder.eq("region", raw("?")))

    val preparedStatement = session.prepare(query)

    group(Groups.SELECT) {
      exec(cql("readCosRedAlertsPublishedRegion")
        .executeNamed(preparedStatement)
  //      .check(rowCount greaterThan 0)
      )
    }
  }

  def readCosRedAlertsPublishedRootcause: ChainBuilder = {

    val query = QueryBuilder
      .select()
      .from(keyspace, table)
      .where(QueryBuilder.eq("report_date", raw("?")))
      .and(QueryBuilder.eq("part_num", raw("?")))
      .and(QueryBuilder.eq("root_cause", raw("?")))

    val preparedStatement = session.prepare(query)

    group(Groups.SELECT) {
      exec(cql("readCosRedAlertsPublishedRootcause")
        .executeNamed(preparedStatement)
      //  .check(rowCount greaterThan 0)
      )
    }
  }

  def readCosRedAlertsPublishedSite: ChainBuilder = {

    val query = QueryBuilder
      .select()
      .from(keyspace, table)
      .where(QueryBuilder.eq("report_date", raw("?")))
      .and(QueryBuilder.eq("part_num", raw("?")))
      .and(QueryBuilder.eq("site", raw("?")))

    val preparedStatement = session.prepare(query)

    group(Groups.SELECT) {
      exec(cql("readCosRedAlertsPublishedSite")
        .executeNamed(preparedStatement)
        //.check(rowCount greaterThan 0)
      )
    }
  }

  def readCosRedAlertsPublishedSupplier: ChainBuilder = {

    //report_date, part_num, supplier
    val query = QueryBuilder
      .select()
      .from(keyspace, table)
      .where(QueryBuilder.eq("report_date", raw("?")))
      .and(QueryBuilder.eq("part_num", raw("?")))
      .and(QueryBuilder.eq("supplier", raw("?")))

    val preparedStatement = session.prepare(query)

    group(Groups.SELECT) {
      exec(cql("readCosRedAlertsPublishedSupplier")
        .executeNamed(preparedStatement)
      //  .check(rowCount greaterThan 0)
      )
    }
  }

  def readCosRedAlertsRegion: ChainBuilder = {

    //email_id, rule_type, year_month_bucket
    val query = QueryBuilder
      .select()
      .from(keyspace, table)
      .where(QueryBuilder.eq("email_id", raw("?")))
      .and(QueryBuilder.eq("rule_type", raw("?")))
      .and(QueryBuilder.eq("year_month_bucket", raw("?")))
      .and(QueryBuilder.eq("report_date", raw("?")))
      .and(QueryBuilder.eq("region", raw("?")))

    val preparedStatement = session.prepare(query)

    group(Groups.SELECT) {
      exec(cql("readCosRedAlertsRegion")
        .executeNamed(preparedStatement)
//        .check(rowCount greaterThan 0)
      )
    }
  }

  def readCosRedAlertsRootcause: ChainBuilder = {

    val query = QueryBuilder
      .select()
      .from(keyspace, table)
      .where(QueryBuilder.eq("email_id", raw("?")))
      .and(QueryBuilder.eq("rule_type", raw("?")))
      .and(QueryBuilder.eq("year_month_bucket", raw("?")))
      .and(QueryBuilder.eq("report_date", raw("?")))
      .and(QueryBuilder.eq("root_cause", raw("?")))

    val preparedStatement = session.prepare(query)

    group(Groups.SELECT) {
      exec(cql("readCosRedAlertsRootcause")
        .executeNamed(preparedStatement)
  //      .check(rowCount greaterThan 0)
      )
    }
  }

  def readCosRedAlertsSite: ChainBuilder = {

    val query = QueryBuilder
      .select()
      .from(keyspace, table)
      .where(QueryBuilder.eq("email_id", raw("?")))
      .and(QueryBuilder.eq("rule_type", raw("?")))
      .and(QueryBuilder.eq("year_month_bucket", raw("?")))
      .and(QueryBuilder.eq("report_date", raw("?")))
      .and(QueryBuilder.eq("site", raw("?")))

    val preparedStatement = session.prepare(query)

    group(Groups.SELECT) {
      exec(cql("readCosRedAlertsSite")
        .executeNamed(preparedStatement)
    //    .check(rowCount greaterThan 0)
      )
    }
  }

  def readCosRedAlertsSupplier: ChainBuilder = {

    val query = QueryBuilder
      .select()
      .from(keyspace, table)
      .where(QueryBuilder.eq("email_id", raw("?")))
      .and(QueryBuilder.eq("rule_type", raw("?")))
      .and(QueryBuilder.eq("year_month_bucket", raw("?")))
      .and(QueryBuilder.eq("report_date", raw("?")))
      .and(QueryBuilder.eq("supplier", raw("?")))

    val preparedStatement = session.prepare(query)

    group(Groups.SELECT) {
      exec(cql("readCosRedAlertsSupplier")
        .executeNamed(preparedStatement)
      //  .check(rowCount greaterThan 0)
      )
    }
  }

  def readOpenCosRedAlerts: ChainBuilder = {

    val query = QueryBuilder
      .select()
      .from(keyspace, table)
      .where(QueryBuilder.eq("report_date", raw("?")))
      .and(QueryBuilder.eq("part_num", raw("?")))

    val preparedStatement = session.prepare(query)

    group(Groups.SELECT) {
      exec(cql("readOpenCosRedAlerts")
        .executeNamed(preparedStatement)
        //.check(rowCount greaterThan 0)
      )
    }
  }

  def readOpenRedAlerts: ChainBuilder = {

    val query = QueryBuilder
      .select()
      .from(keyspace, table)
      .where(QueryBuilder.eq("report_date", raw("?")))
      .and(QueryBuilder.eq("part_num", raw("?")))

    val preparedStatement = session.prepare(query)

    group(Groups.SELECT) {
      exec(cql("readOpenRedAlerts")
        .executeNamed(preparedStatement)
        //.check(rowCount greaterThan 0)
      )
    }
  }

  def readReportRundates: ChainBuilder = {

    val query = QueryBuilder
      .select()
      .from(keyspace, table)
      .where(QueryBuilder.eq("usecase_name", raw("?")))

    val preparedStatement = session.prepare(query)

    group(Groups.SELECT) {
      exec(cql("readReportRundates")
        .executeNamed(preparedStatement)
        //.check(rowCount greaterThan 0)
      )
    }
  }

  def readDscItemCommodityCfgRules: ChainBuilder = {

    val query = QueryBuilder
      .select()
      .from(keyspace, table)
      .where(QueryBuilder.eq("commodity_xref", raw("?")))
      .and(QueryBuilder.eq("cfg_name", raw("?")))

    val preparedStatement = session.prepare(query)

    group(Groups.SELECT) {
      exec(cql("readDscItemCommodityCfgRules")
        .executeNamed(preparedStatement)
        //.check(rowCount greaterThan 0)
      )
    }
  }

  def readDscMetadata: ChainBuilder = {

    val query = QueryBuilder
      .select()
      .from(keyspace, table)
      .where(QueryBuilder.eq("name", raw("?")))

    val preparedStatement = session.prepare(query)

    group(Groups.SELECT) {
      exec(cql("readDscMetadata")
        .executeNamed(preparedStatement)
        //.check(rowCount greaterThan 0)
      )
    }
  }

  def readGsmWorkdayHierarchy: ChainBuilder = {

    val queryGsmWorkdayHierarchy = QueryBuilder
      .select("email_id", "role_index", "last_updated_at", "last_updated_by", "reporter_email_id")
      .from(keyspace, table)
      .where(QueryBuilder.eq("email_id", raw("?")))
      .and(QueryBuilder.eq("role_index", raw("?")))
    val psGsmWorkdayHierarchy = session.prepare(queryGsmWorkdayHierarchy)

    group(Groups.SELECT) {
      exec(cql("readGsmWorkdayHierarchy")
        .executeNamed(psGsmWorkdayHierarchy)
        //.check(rowCount greaterThan 0)
      )
    }
  }

  def readWorkdayEmployeeDetails: ChainBuilder = {

    val query = QueryBuilder
      .select()
      .from(keyspace, table)
      .where(QueryBuilder.eq("email_id", raw("?")))
      .and(QueryBuilder.eq("user_nm", raw("?")))

    val preparedStatement = session.prepare(query)

    group(Groups.SELECT) {
      exec(cql("readWorkdayEmployeeDetails")
        .executeNamed(preparedStatement)
        //.check(rowCount greaterThan 0)
      )
    }
  }

  def readCosRedAlertsExecutiveSummary: ChainBuilder = {

    val query = QueryBuilder
      .select()
      .from(keyspace, table)
      .where(QueryBuilder.eq("rule_type", raw("?")))
      .and(QueryBuilder.eq("rule_setting_id", raw("?")))
      .and(QueryBuilder.eq("year_month_bucket", raw("?")))
      .and(QueryBuilder.eq("status", raw("?")))
      .and(QueryBuilder.eq("report_date", raw("?")))
      .and(QueryBuilder.eq("part_num", raw("?")))
      .and(QueryBuilder.eq("site", raw("?")))
      .and(QueryBuilder.eq("commodity", raw("?")))
      .and(QueryBuilder.eq("current_stbl", raw("?")))
      .and(QueryBuilder.eq("recovery_from_stbl", raw("?")))
      .and(QueryBuilder.eq("platform", raw("?")))
      .and(QueryBuilder.eq("region", raw("?")))

    val preparedStatement = session.prepare(query)

    group(Groups.SELECT) {
      exec(cql("readCosRedAlertsExecutiveSummary")
        .executeNamed(preparedStatement)
        //.check(rowCount greaterThan 0)
      )
    }
  }

  def readCosRedRulesSettings: ChainBuilder = {

    val query = QueryBuilder
      .select()
      .from(keyspace, table)
      .where(QueryBuilder.eq("commodity", raw("?")))
      .and(QueryBuilder.eq("cfg", raw("?")))
      .and(QueryBuilder.eq("site", raw("?")))
      .and(QueryBuilder.eq("rule_name", raw("?")))
      .and(QueryBuilder.eq("rule_type", raw("?")))

    val preparedStatement = session.prepare(query)

    group(Groups.SELECT) {
      exec(cql("readCosRedRulesSettings")
        .executeNamed(preparedStatement)
      //  .check(rowCount greaterThan 0)
      )
    }
  }

  def readCosRedRulesConditions: ChainBuilder = {

    val query = QueryBuilder
      .select()
      .from(keyspace, table)
      .where(QueryBuilder.eq("rule_settings_id", raw("?")))
      .and(QueryBuilder.eq("rule_conditions_id", raw("?")))
      .and(QueryBuilder.eq("measure", raw("?")))

    val preparedStatement = session.prepare(query)

    group(Groups.SELECT) {
      exec(cql("readCosRedRulesConditions")
        .executeNamed(preparedStatement)
    //    .check(rowCount greaterThan 0)
      )
    }
  }

  def readOpenRedAlertsPublished: ChainBuilder = {

    val query = QueryBuilder
      .select()
      .from(keyspace, table)
      .where(QueryBuilder.eq("part_num", raw("?")))
      .and(QueryBuilder.eq("site", raw("?")))
      .and(QueryBuilder.eq("report_date", raw("?")))
      .and(QueryBuilder.eq("rule_type", raw("?")))
      .and(QueryBuilder.eq("rule_setting_id", raw("?")))
      .and(QueryBuilder.eq("commodity", raw("?")))
      .and(QueryBuilder.eq("current_stbl", raw("?")))
      .and(QueryBuilder.eq("recovery_from_stbl", raw("?")))
      .and(QueryBuilder.eq("platform", raw("?")))
      .and(QueryBuilder.eq("region", raw("?")))

    val preparedStatement = session.prepare(query)

    group(Groups.SELECT) {
      exec(cql("readOpenRedAlertsPublished")
        .executeNamed(preparedStatement)
        .check(rowCount greaterThan 0)
      )
    }
  }

  def readOpenRedAlertsUnpublished: ChainBuilder = {

    val query = QueryBuilder
      .select()
      .from(keyspace, table)
      .where(QueryBuilder.eq("part_num", raw("?")))
      .and(QueryBuilder.eq("site", raw("?")))
      .and(QueryBuilder.eq("report_date", raw("?")))
      .and(QueryBuilder.eq("rule_type", raw("?")))
      .and(QueryBuilder.eq("rule_setting_id", raw("?")))
      .and(QueryBuilder.eq("commodity", raw("?")))
      .and(QueryBuilder.eq("current_stbl", raw("?")))
      .and(QueryBuilder.eq("recovery_from_stbl", raw("?")))
      .and(QueryBuilder.eq("platform", raw("?")))
      .and(QueryBuilder.eq("region", raw("?")))

    val preparedStatement = session.prepare(query)

    group(Groups.SELECT) {
      exec(cql("readOpenRedAlertsUnpublished")
        .executeNamed(preparedStatement)
//        .check(rowCount greaterThan 0)
      )
    }
  }

  def readRbacExecutivesDetails: ChainBuilder = {

    val query = QueryBuilder
      .select()
      .from(keyspace, table)
      .where(QueryBuilder.eq("user_nm", raw("?")))
      .and(QueryBuilder.eq("email_id", raw("?")))
      .and(QueryBuilder.eq("rule_type", raw("?")))
      .and(QueryBuilder.eq("rule_setting_id", raw("?")))
      .and(QueryBuilder.eq("is_adhoc", raw("?")))

    val preparedStatement = session.prepare(query)

    group(Groups.SELECT) {
      exec(cql("readRbacExecutivesDetails")
        .executeNamed(preparedStatement)
      //  .check(rowCount greaterThan 0)
      )
    }
  }

  def readStblpartlevel: ChainBuilder = {

    val query = QueryBuilder
      .select()
      .from(keyspace, table)
      .where(QueryBuilder.eq("report_date", raw("?")))
      .and(QueryBuilder.eq("business_unit", raw("?")))
      .and(QueryBuilder.eq("part_num", raw("?")))
      .and(QueryBuilder.eq("region", raw("?")))
      .and(QueryBuilder.eq("site", raw("?")))

    val preparedStatement = session.prepare(query)

    group(Groups.SELECT) {
      exec(cql("readStblpartlevel")
        .executeNamed(preparedStatement)
  //      .check(rowCount greaterThan 0)
      )
    }
  }
  def readStblbusinessunitsummary: ChainBuilder = {

    val query = QueryBuilder
      .select()
      .from(keyspace, table)
      .where(QueryBuilder.eq("business_unit", raw("?")))
      .and(QueryBuilder.eq("year_week_bucket", raw("?")))
      .and(QueryBuilder.eq("report_date", raw("?")))


    val preparedStatement = session.prepare(query)

    group(Groups.SELECT) {
      exec(cql("readStblbusinessunitsummary")
        .executeNamed(preparedStatement)
//        .check(rowCount greaterThan 0)
      )
    }
  }

}
