package ch.uzh.utils

import org.apache.spark.sql.expressions.UserDefinedFunction
import org.apache.spark.sql.functions.udf
import org.joda.time.{DateTime, DateTimeZone, Instant}
import org.joda.time.format.{DateTimeFormat, ISODateTimeFormat}

case class TimePartition(partition: String, datePattern: Option[String] = None, zone: Option[DateTimeZone] = None) {

  private val dateTimeFormatter = if (datePattern.isDefined) {
    DateTimeFormat.forPattern(datePattern.get)
  } else {
    ISODateTimeFormat.dateTime()
  }

  private val dateTimeZone = if (zone.isDefined) {
    zone.get
  } else {
    DateTimeZone.UTC
  }

  private val partitionInMillis: Double = partition match {
    case "second" => 1000.0
    case "minute" => 60000.0
    case "hour" => 3600000.0
    case "day" => 86400000.0
    case "week" => 604800000.0
    case "month" => 2629746000.0
    case "year" => 31556952000.0
    case _ => 1.0
  }

  private def millisToString(millis: Long) = partition match {
    case "second" => new DateTime(millis, dateTimeZone).toString("yyyy-MM-ddTHH:mm:ss")
    case "minute" => new DateTime(millis, dateTimeZone).toString("yyyy-MM-ddTHH:mm")
    case "hour" => new DateTime(millis, dateTimeZone).toString("yyyy-MM-ddTHH")
    case "day" => new DateTime(millis, dateTimeZone).toString("yyyy-MM-dd")
    case "week" => new DateTime(millis, dateTimeZone).toString("yyyy-MM-dd")
    case "month" => new DateTime(millis, dateTimeZone).toString("yyyy-MM")
    case "year" => new DateTime(millis, dateTimeZone).toString("yyyy")
    case _ => millis.toString
  }

  /**
    * getting the timestamp as a number, dividing by partitionInMillis and floor the result
    * @param date string to parse
    * @return bucket of the date
    */
  def bucketize(date: String): String = {
    val dt = Instant.parse(date, dateTimeFormatter)
    millisToString(math.round(math.floor((dt.getMillis / partitionInMillis) * partitionInMillis)))
  }

  def bucket: UserDefinedFunction = udf(bucketize _)
}
