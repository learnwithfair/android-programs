package com.example.gridview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME= "students.db";
    private static final String TABLE_NAME= "students_details";
    private static final String ID= "id";
    private static final String PASSWORD= "password";
    private static final String NAME= "name";
    private static final String AGE= "age";
    private static final String GENDER= "gender";
    private static final String EMAIL= "email";
    private static final String SL= "_serialNumber";
    private static final int VERSION= 1;
    private static final String DROP_TABLE= "DROP TABLE IF EXISTS "+TABLE_NAME;
    private static final String SELECT_TABLE= "SELECT * FROM "+TABLE_NAME;
    private static final String CREATE_TABLE= "CREATE TABLE "+TABLE_NAME+"("+SL+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ID+" INEGER, "+PASSWORD+
                                            " VARCHAR(40), "+NAME+" VARCHAR(50),"+AGE+" INTEGER,"+GENDER+" VARCHAR(20),"+EMAIL+" VARCHAR(220));";
    Context context;
    public MyDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
//        Toast.makeText(context, "Table is Created", Toast.LENGTH_SHORT).show();
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
//        Toast.makeText(context, "Table is Upgrade", Toast.LENGTH_SHORT).show();
        onCreate(db);
    }
   public long saveData(String id,String password,String name,String age,String gender,String email){
        long RowId = 0;
        SQLiteDatabase database = this.getReadableDatabase();
       Cursor cursor = database.rawQuery(SELECT_TABLE,null);
       while (cursor.moveToNext()){
           String e = cursor.getString(6);
           if (e.equals(email)){
               RowId = -1;
               break;
           }
       }if (RowId==0){
           SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
           ContentValues contentValues = new ContentValues();
           contentValues.put(ID,id);
           contentValues.put(PASSWORD,password);
           contentValues.put(NAME,name);
           contentValues.put(AGE,age);
           contentValues.put(GENDER,gender);
           contentValues.put(EMAIL,email);
           RowId = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
       }

       return RowId;
   }
   public int showData(String password,String email){
        int check =0;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_TABLE,null);
        while (cursor.moveToNext()){
            String p = cursor.getString(2);
            String e = cursor.getString(6);
            if (password.equals(p)&&email.equals(e)){
                check = 1;
                break;
            }
        }
        return check;
   }
   public String forgotPassword(String id,String email){
        String str ="";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_TABLE,null);
        while (cursor.moveToNext()){
            String i = cursor.getString(1);
            String e = cursor.getString(6);
            if (id.equals(i)&&e.equals(email)){
                str = cursor.getString(2);
                break;
            }
        }
        return str;
   }
    public String displayData(String password,String email){
       String str = "";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_TABLE,null);
        while (cursor.moveToNext()){
            String p = cursor.getString(2);
            String e = cursor.getString(6);
            if (password.equals(p)&&email.equals(e)){
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("ID : "+cursor.getString(1)+"\n");
                stringBuffer.append("Password : "+cursor.getString(2)+"\n");
                stringBuffer.append("Name : "+cursor.getString(3)+"\n");
                stringBuffer.append("Age : "+cursor.getString(4)+"\n");
                stringBuffer.append("Gender : "+cursor.getString(5)+"\n");
                stringBuffer.append("E-mail : "+cursor.getString(6)+"\n");
                str =  (stringBuffer.toString());
                break;
            }
        }
        return str;
    }
    public Cursor displayAllData(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_TABLE,null);
        return cursor;
    }
    public int updateData(String id, String password,String name, String age,String gender, String email){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID,id);
        contentValues.put(PASSWORD,password);
        contentValues.put(NAME,name);
        contentValues.put(AGE,age);
        contentValues.put(GENDER,gender);
        contentValues.put(EMAIL,email);
        int n = sqLiteDatabase.update(TABLE_NAME,contentValues,EMAIL+" = ?",new String[] {email});
        return n;
    }
public int deleteData( String email){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
       int n = sqLiteDatabase.delete(TABLE_NAME,EMAIL+" = ?",new String[] {email});
        return n;
    }

}
