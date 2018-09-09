package com.alekseysamoylov.nastushenka.service

import com.alekseysamoylov.nastushenka.entity.Report
import com.alekseysamoylov.nastushenka.entity.Task
import com.alekseysamoylov.nastushenka.repository.ReportRepository
import com.alekseysamoylov.nastushenka.repository.TaskRepository
import com.alekseysamoylov.nastushenka.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate
import java.time.LocalDateTime

@Service
class TaskService {

  @Autowired
  private lateinit var taskRepository: TaskRepository
  @Autowired
  private lateinit var userRepository: UserRepository
  @Autowired
  private lateinit var reportRepository: ReportRepository

  @Transactional(readOnly = true)
  fun findAllTask(username: String): List<Task> {
    val user = userRepository.findOneByUsername(username);
    return if (user != null) {
      return taskRepository.findAllByUser(user).orEmpty()
    } else {
      emptyList()
    }
  }

  @Transactional
  fun saveReportAndReturnTodayOnly(taskId: Long, username: String): List<Report> {
    val task = taskRepository.findOne(taskId)
    val user = userRepository.findOneByUsername(username)
    if (task != null && user != null) {
      val report = Report()
      report.time = LocalDateTime.now()
      report.user = user
      report.task = task
      reportRepository.save(report)
      val reportList = reportRepository.findAll()
      return reportList.toList().filter { it.time.dayOfWeek == LocalDate.now().dayOfWeek }
    } else {
      throw IllegalArgumentException("Wrong task id")
    }
  }

  @Transactional
  fun saveReportAndReturnTodayOnly(report: Report): List<Report> {
    reportRepository.save(report)
    val reportList = reportRepository.findAll()
    return reportList.toList().filter { it.time.dayOfWeek == LocalDate.now().dayOfWeek }
  }

  @Transactional(readOnly = true)
  fun findAllReports(username: String): List<Report> {
    val user = userRepository.findOneByUsername(username);
    return if (user != null) {
      val reportList = reportRepository.findAll()
      // TODO
      return reportList.toList()
    } else {
      emptyList()
    }
  }

  @Transactional(readOnly = true)
  fun findAllReportsToday(username: String): List<Report> {
    val user = userRepository.findOneByUsername(username);
    return if (user != null) {
      val reportList = reportRepository.findAll()
      // TODO
      return reportList.toList().filter { it.time.dayOfYear == LocalDate.now().dayOfYear }
    } else {
      emptyList()
    }
  }

  @Transactional(readOnly = true)
  fun findAllReportsThisWeek(username: String): List<Report> {
    val user = userRepository.findOneByUsername(username);
    return if (user != null) {
      val reportList = reportRepository.findAll()
      return reportList.toList().filter { it.time.dayOfWeek == LocalDate.now().dayOfWeek }
    } else {
      emptyList()
    }
  }

  @Transactional
  fun saveTaskAndReturnAll(task: Task): List<Task> {
    val user = userRepository.findOneByUsername(task.user.username)
    if (user != null) {
      task.user = user
      taskRepository.save(task)
      return taskRepository.findAllByUser(user).orEmpty()
    } else {
      throw IllegalAccessException("Wrong user")
    }
  }
}
