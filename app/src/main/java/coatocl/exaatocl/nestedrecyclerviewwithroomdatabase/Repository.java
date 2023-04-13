package coatocl.exaatocl.nestedrecyclerviewwithroomdatabase;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import java.util.List;
class Repository
{
     private final Dao dao;
    LiveData<List<CustomModel>> allCourses;

    public Repository(Application application)
    {
        DatabaseIncome databaseIncome = DatabaseIncome.getInstance(application);
        dao = databaseIncome.Dao();
        allCourses = dao.getAllData();
    }

    void insert (CustomModel customModel)
    {
        new InsertAsyncTask(dao).execute(customModel);
    }

    void update (CustomModel customModel)
    {
        new UpdateAsyncTask(dao).execute(customModel);
    }

    void delete (CustomModel customModel)
    {
        new DeleteAsyncTask(dao).execute(customModel);
    }

    LiveData<List<CustomModel>> getAllCourses()
    {
        return allCourses;
    }

    private static class InsertAsyncTask extends AsyncTask<CustomModel,Void,Void> {
        Dao dao;
        public InsertAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(CustomModel... customModels)
        {
            dao.insert(customModels[0]);
            return null;
        }
    }

    private static class UpdateAsyncTask extends AsyncTask<CustomModel,Void,Void> {
        Dao dao;
        public UpdateAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(CustomModel... customModels) {
            dao.update(customModels[0]);
            return null;
        }
    }

    private static class DeleteAsyncTask extends AsyncTask<CustomModel,Void,Void>{
        Dao dao;
        public DeleteAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(CustomModel... customModels) {
            dao.delete(customModels[0]);
            return null;
        }
    }
}
