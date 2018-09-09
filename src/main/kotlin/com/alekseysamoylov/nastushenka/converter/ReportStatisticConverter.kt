package com.alekseysamoylov.nastushenka.converter

import com.alekseysamoylov.nastushenka.entity.Report
import com.alekseysamoylov.nastushenka.entity.TaskType
import com.alekseysamoylov.nastushenka.model.ReportStatistic
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.format.TextStyle
import java.util.*
import kotlin.collections.ArrayList
import kotlin.streams.toList

@Service
class ReportStatisticConverter : Converter<Report, ReportStatistic> {

  override fun convert(valueToConvert: List<Report>): List<ReportStatistic> {

    val weekDayReportMap = valueToConvert.groupBy({ it.time.dayOfWeek }, { it })
    val reportStatistics = weekDayReportMap.entries.stream().map { weekDayReportsEntry ->

      val dayOfWeek = weekDayReportsEntry.key
      val reportStatistic = ReportStatistic(
          name = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.US),
          order = dayOfWeek.value
      )
      val weekReports: List<Report> = weekDayReportsEntry.value
      weekReports.forEach {
        incrementTasksByType(it, reportStatistic)
      }
      reportStatistic
    }.toList()
    val list = ArrayList<ReportStatistic>()
    list.addAll(reportStatistics)
    list.sortBy { it.order }
    return list
  }

  private fun incrementTasksByType(report: Report, reportStatistic: ReportStatistic) {
    if (report.task.type == TaskType.IMPORTANT_AND_URGENT) {
      reportStatistic.importantUrgent++
    } else if (report.task.type == TaskType.IMPORTANT_AND_NOT_URGENT) {
      reportStatistic.importantNotUrgent++
    } else if (report.task.type == TaskType.NOT_IMPORTANT_AND_URGENT) {
      reportStatistic.notImportantUrgent++
    } else if (report.task.type == TaskType.NOT_IMPORTANT_AND_NOT_URGENT) {
      reportStatistic.notImportantNotUrgent++
    } else {
      throw IllegalArgumentException("Task type is not defined")
    }
  }

  private fun dayWeek(time: LocalDateTime) {

  }


}
