package com.example.davaleba6

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf

class DBHelper(context: Context):SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VER) {
    companion object{
        private val DATABASE_VER = 1
        private val DATABASE_NAME = "EDMTB.db"

        private val TABLE_NAME = "Movie"
        private val COL_ID = "id"
        private val COL_NAME = "title"
        private val COL_DESCRIPTION = "description"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE_QUERY = ("CREATE TABLE $TABLE_NAME ($COL_ID INTEGER PRIMARY KEY, $COL_NAME TEXT, $COL_DESCRIPTION TEXT")

        db!!.execSQL(CREATE_TABLE_QUERY);
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db!!)
    }

    val allMovie:List<Movie>
        get() {
            val movies = ArrayList<Movie>()
            val selectquery = "SELECT * FROM $TABLE_NAME"
            val db:SQLiteDatabase = this.writableDatabase
            val cursor:Cursor = db.rawQuery(selectquery,null)
            if(cursor.moveToFirst()){
                do {
                    val movie = Movie()
                    movie.id = cursor.getInt(cursor.getColumnIndex(COL_ID))
                    movie.title = cursor.getString(cursor.getColumnIndex(COL_NAME))
                    movie.description = cursor.getString(cursor.getColumnIndex(COL_DESCRIPTION))

                    movies.add(movie)
                }while (cursor.moveToNext())
            }
            db.close()
            return movies
        }

    fun addMovie(movie:Movie){
        val db:SQLiteDatabase = this.writableDatabase
        val values = ContentValues()
        values.put(COL_ID,movie.id)
        values.put(COL_NAME,movie.title)
        values.put(COL_DESCRIPTION,movie.description)

        db.insert(TABLE_NAME, null,values)
        db.close()

    }

    fun UpdateMovie(movie:Movie):Int{
        val db:SQLiteDatabase = this.writableDatabase
        val values = ContentValues()
        values.put(COL_ID,movie.id)
        values.put(COL_NAME,movie.title)
        values.put(COL_DESCRIPTION,movie.description)

        return db.update(TABLE_NAME, values,"$COL_ID=?", arrayOf(movie.id.toString()))
        db.close()

    }

    fun DeleteMovie(movie:Movie):Int{
        val db:SQLiteDatabase = this.writableDatabase


        return db.delete(TABLE_NAME, "$COL_ID=?", arrayOf(movie.id.toString()))
        db.close()

    }
}