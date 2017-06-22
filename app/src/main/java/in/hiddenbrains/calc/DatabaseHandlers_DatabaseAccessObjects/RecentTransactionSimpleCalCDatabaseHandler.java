package in.hiddenbrains.calc.DatabaseHandlers_DatabaseAccessObjects;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import in.hiddenbrains.calc.Model.RecentTransactionSimpleCalC;

/**
 * Created by sunil on 31-03-2016.
 */
public class RecentTransactionSimpleCalCDatabaseHandler extends SQLiteOpenHelper{

    private static  final int database_version = 1;
    private static final String database_name = "RecentTransactionManager";

    private  static final String TABLE_TRANSACTIONS = "recenttransactions";
    private static final String KEY_ID = "id";
    private static final String KEY_EVALUATION_STRING = "evaluationstring";
    private static final String KEY_ANSWER = "answer";

    public RecentTransactionSimpleCalCDatabaseHandler(Context context) {
        super(context, database_name, null, database_version);
    }

    public RecentTransactionSimpleCalCDatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_TRANSACTIONS + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_EVALUATION_STRING + " TEXT," + KEY_ANSWER + " TEXT" + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRANSACTIONS);

        onCreate(db);
    }

    public void addTransaction(RecentTransactionSimpleCalC rc){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_EVALUATION_STRING,rc.getEvaluationString());
        contentValues.put(KEY_ANSWER,rc.getAnswer());

        db.insert(TABLE_TRANSACTIONS, null, contentValues);
        db.close();
    }

    public List<RecentTransactionSimpleCalC> getAllTransactions(){

        List<RecentTransactionSimpleCalC> recentTransactionSimpleCalCs = new ArrayList<RecentTransactionSimpleCalC>();

        String query = "select * from " + TABLE_TRANSACTIONS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do{
                RecentTransactionSimpleCalC recentTransactionSimpleCalC = new RecentTransactionSimpleCalC();
                recentTransactionSimpleCalC.setId(Integer.parseInt(cursor.getString(0)));
                recentTransactionSimpleCalC.setEvaluationString(cursor.getString(1));
                recentTransactionSimpleCalC.setAnswer(cursor.getString(2));
                recentTransactionSimpleCalCs.add(recentTransactionSimpleCalC);
            }while (cursor.moveToNext());
        }

        return recentTransactionSimpleCalCs;
    }

    public void deleteTransaction(){
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "SELECT * FROM "+TABLE_TRANSACTIONS;
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        if(count>20) {
            String ALTER_TBL = "delete from " + TABLE_TRANSACTIONS +
                    " where " + KEY_ID + " in (select " + KEY_ID + " from " + TABLE_TRANSACTIONS + " order by id LIMIT " + (count - 20) + ");";

            db.execSQL(ALTER_TBL);
        }

    }

    public int getNoOfTransactions(){

        String query = "SELECT * FROM "+TABLE_TRANSACTIONS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query , null);


        return cursor.getCount();
    }
}