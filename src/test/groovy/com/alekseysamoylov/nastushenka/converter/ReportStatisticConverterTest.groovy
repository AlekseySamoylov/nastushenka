package com.alekseysamoylov.nastushenka.converter

import com.alekseysamoylov.nastushenka.entity.Report
import com.alekseysamoylov.nastushenka.entity.Task
import com.alekseysamoylov.nastushenka.entity.TaskType
import com.alekseysamoylov.nastushenka.entity.User
import spock.lang.Specification
import spock.lang.Unroll

import java.time.LocalDateTime
import java.time.LocalTime
import java.time.LocalDate
import java.util.concurrent.ThreadLocalRandom


class ReportStatisticConverterTest extends Specification {

    @Unroll("")
    def "Should convert"() {
        setup:
        def reportStatisticConverter = new ReportStatisticConverter()
        def reports = Arrays.asList(
                createReport("second", TaskType.NOT_IMPORTANT_AND_URGENT,
                LocalDateTime.of(LocalDate.of(2018, 9, 8), LocalTime.of(12, 0))),
                createReport("second", TaskType.NOT_IMPORTANT_AND_URGENT,
                LocalDateTime.of(LocalDate.of(2018, 9, 9), LocalTime.of(12, 0))),
                createReport("second", TaskType.NOT_IMPORTANT_AND_NOT_URGENT,
                LocalDateTime.of(LocalDate.of(2018, 9, 8), LocalTime.of(12, 0))),
                createReport("first", TaskType.IMPORTANT_AND_URGENT,
                        LocalDateTime.of(LocalDate.of(2018, 9, 7), LocalTime.of(12, 0))),
                createReport("second", TaskType.IMPORTANT_AND_URGENT,
                        LocalDateTime.of(LocalDate.of(2018, 9, 7), LocalTime.of(12, 0)))
        )

        when:
        def result = reportStatisticConverter.convert(reports)

        then:
        result.get(0).importantUrgent == 2
        result.get(0).name == "Fri"

        result.get(1).notImportantUrgent == 1
        result.get(1).notImportantNotUrgent == 1
        result.get(1).name == "Sat"

        result.get(2).notImportantUrgent == 1
        result.get(2).name == "Sun"
    }

    private Report createReport(String taskName, TaskType taskType, LocalDateTime time) {
        def user = new User()
        user.id = getRandomId()
        user.username = "TestUser"
        def task = new Task()
        task.id = getRandomId()
        task.name = taskName
        task.type = taskType
        def report = new Report()
        report.id = getRandomId()
        report.user = user
        report.task = task
        report.time = time
        return report
    }

    def getRandomId() {
        return (long)ThreadLocalRandom.current().nextInt(1, 100)
    }
}
