package com.example.financetracker.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.financetracker.R;
import com.example.financetracker.data.Datasource;
import com.example.financetracker.model.Action;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class DB extends SQLiteOpenHelper {
    private static DB instance = null;

    private static final String dbName = "mob";
    private static final int dbVersion = 1;
    private static final String table = "actions";
    private static final String idCol = "id";
    private static final String categoryCol = "category";
    private static final String amountCol = "amount";
    private static final String statusCol = "status";
    private static final String dateCol = "date";

    public static DB getInstance(Context ctx) {
        if (instance == null) {
            instance = new DB(ctx.getApplicationContext());
        }
        return instance;
    }

    private DB(Context context) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + table + " ("
                + idCol + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + categoryCol + " VARCHAR,"
                + amountCol + " INT,"
                + statusCol + " VARCHAR(5),"
                + dateCol + " VARCHAR(11))";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + table);
        onCreate(db);
    }

    public void addNew(Action action) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(categoryCol, action.getCategory());
        values.put(amountCol, action.getAmount());
        values.put(statusCol, action.getStatus());
        values.put(dateCol, action.getDate().toString());
        db.insert(table, null, values);
        db.close();
    }

    public void getData() {
        ArrayList<Action> actions = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT category, amount, status, date FROM " + table, null);
        if (c.moveToFirst()){
            do {
                String category = c.getString(0);
                int amount = c.getInt(1);
                String status = c.getString(2);
                String date = c.getString(3);
                int img = 0;
                if (Objects.equals(status, "up")) {
                    img = R.drawable.arrow_up_circle_svgrepo_com;
                } else {
                    img = R.drawable.arrow_down_circle_svgrepo_com;
                }
                actions.add(new Action(category, amount, img, LocalDate.parse(date)));
            } while(c.moveToNext());
        }
        c.close();
        db.close();
        Datasource.Companion.setActions(actions);
    }

}
