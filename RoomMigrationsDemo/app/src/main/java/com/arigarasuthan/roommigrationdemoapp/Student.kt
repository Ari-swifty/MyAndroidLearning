package com.arigarasuthan.roommigrationdemoapp

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_info")
data class Student(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "student_id")
    val id:Int,
    @ColumnInfo(name = "student_name")
    val name: String,
    @ColumnInfo(name = "student_email", defaultValue = "No Email")
    val email: String
)
