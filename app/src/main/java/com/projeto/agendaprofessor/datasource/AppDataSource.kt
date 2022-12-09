package com.projeto.agendaprofessor.datasource

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.projeto.agendaprofessor.api.AppUtil
import com.projeto.agendaprofessor.datamodel.ProfessorDataModel

open class AppDataSource(
    context: Context
) : SQLiteOpenHelper(context, AppUtil.DATABASE_NAME, null, AppUtil.DATABASE_VERSION) {

    var p0: SQLiteDatabase = writableDatabase

    override fun onCreate(p0: SQLiteDatabase?) {
        try {
            p0?.execSQL(ProfessorDataModel.queryCreateTable())
            Log.i(AppUtil.TAG, "onCreate: "+ProfessorDataModel.queryCreateTable())

            p0?.execSQL(ProfessorDataModel.queryDescribeTable())
            Log.i(AppUtil.TAG, "onCreate: "+ProfessorDataModel.queryDescribeTable())
        }catch(e:SQLiteException){
            Log.e(AppUtil.TAG, "onCreate: "+e.message)
        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    companion object{
        fun incluir(p0: SQLiteDatabase?, tabela: String, values: ContentValues): Boolean {
            var result: Boolean = false



            try {
                result = p0?.insert(tabela, null, values)!! > 0
            } catch(e: Exception){
                Log.e(AppUtil.TAG, "insert: "+e.message)
            }

            return result
        }
    }
}