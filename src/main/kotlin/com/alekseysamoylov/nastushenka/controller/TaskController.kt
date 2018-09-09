package com.alekseysamoylov.nastushenka.controller

import com.alekseysamoylov.nastushenka.converter.Converter
import com.alekseysamoylov.nastushenka.entity.Report
import com.alekseysamoylov.nastushenka.entity.Task
import com.alekseysamoylov.nastushenka.model.ReportStatistic
import com.alekseysamoylov.nastushenka.service.TaskService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
class TaskController {

  @Autowired
  private lateinit var taskService: TaskService
  @Autowired
  private lateinit var reportConverter: Converter<Report, ReportStatistic>

  @GetMapping("all")
  fun getReportStatistic(username: String): List<ReportStatistic> {
    return reportConverter.convert(taskService.findAllReports(username))
  }

  @GetMapping("week")
  fun getReportStatisticThisWeek(username: String): List<ReportStatistic> {
    return reportConverter.convert(taskService.findAllReportsThisWeek(username))
  }

  @GetMapping("day")
  fun getReportStatisticThisDay(username: String): List<ReportStatistic> {
    return reportConverter.convert(taskService.findAllReportsToday(username))
  }

  @PostMapping("task/")
  fun saveTask(@RequestBody task: Task): List<Task> {
    return taskService.saveTaskAndReturnAll(task)
  }

  @GetMapping("task/{username}")
  fun getAllTask(@PathVariable username: String): List<Task> {
    return taskService.findAllTask(username)
  }

  @PostMapping("task/report")
  fun saveReport(@RequestBody report: Report): List<Report> {
    return taskService.saveReportAndReturnTodayOnly(report)
  }

  @GetMapping("task/report/{taskId}/user/{username}")
  fun saveReport(@PathVariable taskId: Long, @PathVariable username: String): List<Report> {

    return taskService.saveReportAndReturnTodayOnly(taskId, username)
  }
}
