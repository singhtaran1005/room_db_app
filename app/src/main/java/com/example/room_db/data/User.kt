package com.example.room_db.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user-data")
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var firstName: String,
    var lastName: String,
    var age: Int,
)