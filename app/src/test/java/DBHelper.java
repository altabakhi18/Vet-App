// This will stay here until we have more information. SQLite needs to be built off of
// premade parts of the app so I can't completely finish the database until we start some part of
// the app. As of rn this is the bare minimum that I could put in just to have a starting place
// while we work out some of the details.

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "CustomerData.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create table CustomerInfo(name TEXT, phone INT, petName TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop table if exists CustomerInfo");
    }

    public Boolean insertCustomerInfo(String name, int phone, String petName){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("phone", phone);
        cv.put("petName", petName);
        long result = DB.insert("CustomerInfo", null, cv);
        if(result == -1) {
            return false;
        }else{
            return true;
        }
    }

    public Boolean updateCustomerInfo(String name, int phone, String petName){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("phone", phone);
        cv.put("petName", petName);

        long result = DB.update("CustomerInfo", cv, "name=?", new String[] {name});
        if(result == -1) {
            return false;
        }else{
            return true;
        }
    }
}
