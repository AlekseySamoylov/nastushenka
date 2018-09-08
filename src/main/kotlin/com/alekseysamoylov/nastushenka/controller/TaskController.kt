package com.alekseysamoylov.nastushenka.controller

import com.alekseysamoylov.nastushenka.model.ReportStatistic
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RestController

@CrossOrigin
@RestController
class TaskController {

  fun getReportStatisticThisWeek(username: String): List<ReportStatistic> {
    // TODO
    return emptyList()
  }
}
