package com.alekseysamoylov.nastushenka.model


class ReportStatistic(var name: String = "",
                      var order: Int = 0,
                      var importantUrgent: Int = 0,
                      var importantNotUrgent: Int = 0,
                      var notImportantUrgent: Int = 0,
                      var notImportantNotUrgent: Int = 0)
