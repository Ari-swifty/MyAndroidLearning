package com.arigarasuthan.roommigrationdemoapp

import android.content.Context
import androidx.room.*
import androidx.room.migration.AutoMigrationSpec

@Database(
    entities = [Student::class],
    version = 5,
    autoMigrations = [
        AutoMigration(from = 1, to = 2),
        AutoMigration(from = 2, to = 3),
        AutoMigration(from = 3, to = 4, spec = StudentDataBase.Migration3To4::class),
        AutoMigration(from = 4, to = 5, spec = StudentDataBase.Migration4To5::class)]
)
abstract class StudentDataBase : RoomDatabase() {
    abstract val studentDAO: StudentDAO

    @RenameColumn(
        tableName = "student_info",
        fromColumnName = "course_name",
        toColumnName = "subject_name"
    )
    class Migration3To4 : AutoMigrationSpec

    @DeleteColumn(tableName = "student_info", columnName = "student_email")
    class Migration4To5 : AutoMigrationSpec

    companion object {
        @Volatile
        private var INSTANCE: StudentDataBase? = null
        fun getInstance(context: Context): StudentDataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        StudentDataBase::class.java,
                        "student_data_base"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}