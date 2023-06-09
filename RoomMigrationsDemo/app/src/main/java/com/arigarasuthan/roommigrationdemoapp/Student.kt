package com.arigarasuthan.roommigrationdemoapp

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_info")
data class Student(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "student_id")
    var id:Int,
    @ColumnInfo(name = "student_name")
    var name: String,
    @ColumnInfo(name = "subject_name")
    var course: String?

)
