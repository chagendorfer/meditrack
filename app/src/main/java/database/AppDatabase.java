package database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {MedicationEntity.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public static AppDatabase appDatabaseInstance;
    public static AppDatabase getInstance(Context context){
        if (AppDatabase.appDatabaseInstance ==null){
            synchronized (AppDatabase.class){
                if (AppDatabase.appDatabaseInstance ==null){
                    AppDatabase.appDatabaseInstance =
                            Room.databaseBuilder(context, AppDatabase.class, "medication_db").build();
                }
            }
        }
        return(AppDatabase.appDatabaseInstance);
    }
    public abstract MedicationDao medicationDao();
}
