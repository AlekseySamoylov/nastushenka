package com.alekseysamoylov.nastushenka.service

import com.alekseysamoylov.nastushenka.entity.Report
import com.alekseysamoylov.nastushenka.entity.Task
import com.alekseysamoylov.nastushenka.entity.User
import com.alekseysamoylov.nastushenka.repository.ReportRepository
import com.alekseysamoylov.nastushenka.repository.TaskRepository
import com.alekseysamoylov.nastushenka.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TaskService {

  @Autowired
  private lateinit var taskRepository: TaskRepository
  @Autowired
  private lateinit var userRepository: UserRepository
  @Autowired
  private lateinit var reportRepository: ReportRepository

  @Transactional
  fun saveTask(apiTask: Task, username: String): List<Task> {
    val user = userRepository.findOneByUsername(username);
    return if (user != null) {
      taskRepository.save(apiTask)
      taskRepository.findAllByUser(user).orEmpty()
    } else {
      emptyList()
    }
  }

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
  fun saveReportAndReturnTodayOnly(report: Report, user: User): List<Report> {
    reportRepository.save(report)
    val reportList = reportRepository.findAll()
    return reportList.toList()
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
    // TODO
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
  fun findAllReportsThisWeek(username: String): List<Report> {
    // TODO
    val user = userRepository.findOneByUsername(username);
    return if (user != null) {
      val reportList = reportRepository.findAll()
      // TODO
      return reportList.toList()
    } else {
      emptyList()
    }
  }
}
