package com.alekseysamoylov.nastushenka.repository

import com.alekseysamoylov.nastushenka.entity.Userlog
import org.springframework.data.repository.CrudRepository


interface UserlogRepository : CrudRepository<Userlog, Long>
