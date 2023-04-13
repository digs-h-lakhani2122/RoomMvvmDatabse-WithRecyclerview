package coatocl.exaatocl.nestedrecyclerviewwithroomdatabase;

import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@androidx.room.Database(entities = {CustomModel.class},version = 1)
public abstract class DatabaseIncome extends RoomDatabase
{
    public abstract Dao Dao();
    private static DatabaseIncome instance;

    public static synchronized DatabaseIncome getInstance(Context context)
    {
        if(instance==null)
        {
            instance = Room.databaseBuilder(context.getApplicationContext(),DatabaseIncome.class,"income_database").fallbackToDestructiveMigration().addCallback(roomCallback).build();
        }
        return  instance;
    }

    private  static final RoomDatabase.Callback roomCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            new PopulateDbASync(instance).execute();
        }
    };

    private static class PopulateDbASync extends AsyncTask<Void,Void,Void> {
        public PopulateDbASync(DatabaseIncome instance)
        {
            Dao dao = instance.Dao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }
}
