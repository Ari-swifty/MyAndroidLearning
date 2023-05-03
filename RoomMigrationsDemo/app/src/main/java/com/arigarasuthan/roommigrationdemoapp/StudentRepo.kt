package com.arigarasuthan.roommigrationdemoapp

class StudentRepo(private val studentDAO: StudentDAO) {


    suspend fun insert(student: Student) : Long  {
       return studentDAO.insertStudent(student)
    }
}