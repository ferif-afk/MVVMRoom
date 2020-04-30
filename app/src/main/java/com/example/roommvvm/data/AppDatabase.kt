package com.example.roommvvm.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roommvvm.dao.StudentDao
import com.example.roommvvm.entity.Student

//class ini untuk mendeklarasikan room database yang digunakan dalam aplikasi
@Database(entities = arrayOf(Student::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    //memasukkan data import StudentDao ke fungsi
    abstract fun studentDao(): StudentDao

    //companion object adalah tempat menyimpan segala object yg otomatis panggil dengan classnya langsung
    companion object {
        private var INSTANCE: AppDatabase? = null

        //fungsi untuk cek apakah database sudah ada atau belum dalam device, dan jika belum akan dibuild terlebih dahulu
        fun getInstance(context: Context): AppDatabase? {

            //decision mengecek database sudah ada sudah atau belum
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {

                    //menjalankan build database apabila memang belum ada dalam device
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            AppDatabase::class.java, "student-database")
                        .build()
                }
            }
            return INSTANCE
        }

        //ini seharusnya sebua query untuk menghapus database tetapi dalam program aplikasi ini tidak digunakan
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}