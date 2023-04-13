package coatocl.exaatocl.nestedrecyclerviewwithroomdatabase;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity
{
    FloatingActionButton floatingActionButton;
    RecyclerView recyclerIncome;
    ViewModel viewModel;
    List<CustomModel> listItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton = findViewById(R.id.floatingActionButton);
        recyclerIncome = findViewById(R.id.recyclerIncome);

        floatingActionButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,addingIncome.class);
            startActivityForResult(intent,101010);
        });

        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        recyclerIncome.setHasFixedSize(true);
        recyclerIncome.setLayoutManager(linearLayout);

        Adapter adapter = new Adapter();
        recyclerIncome.setAdapter(adapter);

        viewModel = ViewModelProviders.of(this).get(ViewModel.class);
        viewModel.getAllIncomes().observe(this, new Observer<List<CustomModel>>() {
            @Override
            public void onChanged(List<CustomModel> customModels) {
                adapter.setListItem(customModels);
            }
        });
//        viewModel.getAllIncomes().observe(this, models -> adapter.submitList(models));
        
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 101010 && resultCode == RESULT_OK) {
            assert data != null;

            String saveDate = data.getStringExtra("extra_Date");
            String saveAccount = data.getStringExtra("extra_Account");
            String saveCategory = data.getStringExtra("extra_Category");
            String saveAmount = data.getStringExtra("extra_Amount");
            String saveNote = data.getStringExtra("extra_Note");
            String saveDescription = data.getStringExtra("extra_Description");

            CustomModel model = new CustomModel(saveDate, saveAccount, saveCategory, saveAmount, saveNote, saveDescription);
            viewModel.insert(model);

            Toast.makeText(this, "Course saved", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Course not saved", Toast.LENGTH_SHORT).show();
        }
    }

}
