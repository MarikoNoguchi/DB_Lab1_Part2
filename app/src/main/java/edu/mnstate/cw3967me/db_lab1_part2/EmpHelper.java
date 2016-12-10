package edu.mnstate.cw3967me.db_lab1_part2;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by marikonoguchi on 11/4/16.
 */
public class EmpHelper extends SQLiteOpenHelper {
    //create class-level variables(static)
    public static final String DATABASE_NAME = "emp.db";
    public static final int DATABASE_VERSION = 2;
    public static final String TABLE_NAME = "empTable";
    public static final String EMPID = "_id";
    public static final String EMPNAME = "empName";
    public static final String EMPADDRESS = "empAddress";

    private Context context;

    //constructor
    EmpHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        Message.message(context, "Called the Constructor");
    }

    /*
    Store SQL statement to create a table:
    CRATE TABLE empTable(
        _id INTEGER PRIMARY KEY AUTOINCREMENT, Name VARCHAR(255)
    );
     */

    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "(" + EMPID +
                    " INTEGER PRIMARY KEY AUTOINCREMENT, " + EMPNAME +
                    " VARCHAR(255)," +
                    EMPADDRESS + " VARCHAR(255));";

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("onCreate");
        try {
            db.execSQL(CREATE_TABLE);
            Message.message(context, "onCreate called");
        } catch (SQLException e) {
            Message.message(context, "" + e);
        }
    }

    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            Message.message(context, "onUpgrade called");
            db.execSQL(DROP_TABLE);
            onCreate(db);   //create the revised table
        } catch (SQLException e) {
            Message.message(context, "" + e);
        }
    }

}
