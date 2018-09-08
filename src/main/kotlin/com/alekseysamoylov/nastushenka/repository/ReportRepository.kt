package com.alekseysamoylov.nastushenka.repository

import com.alekseysamoylov.nastushenka.entity.Report
import org.springframework.data.repository.CrudRepository


interface ReportRepository : CrudRepository<Report, Long>
