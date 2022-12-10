package com.projeto.agendaprofessor.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.projeto.agendaprofessor.api.AppUtil;
import com.projeto.agendaprofessor.datamodel.ProfessorDataModel;

public class AppDataBase extends SQLiteOpenHelper {

    static SQLiteDatabase sqLiteDatabase;

    public AppDataBase(Context context) {
        super(context, AppUtil.Companion.getDATABASE_NAME(), null, AppUtil.Companion.getDATABASE_VERSION());

        sqLiteDatabase = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(ProfessorDataModel.queryCreateTable());
            Log.i(AppUtil.Companion.getTAG(), "onCreate: "+ProfessorDataModel.queryCreateTable());
        } catch(SQLiteException sql){
            Log.e(AppUtil.Companion.getTAG(), "onCreate: "+sql.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public static Boolean incluir(String tabela, ContentValues values){

        boolean result = false;
        try {
            result = sqLiteDatabase.insert(tabela, null, values) > 0;
        } catch(Exception e){
            Log.e(AppUtil.Companion.getTAG(), "incluir: "+e.getMessage());
        }

        return result;
    }
}
