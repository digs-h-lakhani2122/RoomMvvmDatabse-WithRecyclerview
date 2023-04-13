package coatocl.exaatocl.nestedrecyclerviewwithroomdatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@androidx.room.Dao
public interface Dao
{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(CustomModel customModel);

    @Update
    void update(CustomModel customModel);

    @Delete
    void delete(CustomModel customModel);

    @Query("SELECT* FROM income_details ORDER BY custom_date ASC")
    LiveData<List<CustomModel>> getAllData();

}
