package com.example.roommvvm.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//class yg digunakan untuk menentukan struktur dalam tabel Student
@Entity
data class Student (
    //menentutukan primary key tabel (autoGenerate)
    @PrimaryKey(autoGenerate = true) var id: Int? = null,

    //columnInfo untuk mendeklarasikan struktur tabel
    //dalam tabel ini tersedia nama bertipe data string
    @ColumnInfo var name: String = ""
)