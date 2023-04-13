package coatocl.exaatocl.nestedrecyclerviewwithroomdatabase;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;
public class ViewModel extends AndroidViewModel
{
    Repository repository;
    LiveData<List<CustomModel>>allIncomes;

    public ViewModel(@NonNull Application application)
    {
        super(application);
        repository = new Repository(application);
        allIncomes = repository.getAllCourses();
    }

    void insert(CustomModel customModel)
    {
        repository.insert(customModel);
    }

    void update(CustomModel customModel)
    {
        repository.update(customModel);
    }

    void delete(CustomModel customModel)
    {
        repository.delete(customModel);
    }

    LiveData<List<CustomModel>>getAllIncomes()
    {
        return allIncomes;
    }

}
