package com.projeto.agendaprofessor.datasource;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.projeto.agendaprofessor.api.AppUtil;

public class AppDatabase extends SQLiteOpenHelper {



    public AppDatabase(Context context) {
        super(context, AppUtil.Companion.getDATABASE_NAME(), null, AppUtil.Companion.getDATABASE_VERSION());


    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
