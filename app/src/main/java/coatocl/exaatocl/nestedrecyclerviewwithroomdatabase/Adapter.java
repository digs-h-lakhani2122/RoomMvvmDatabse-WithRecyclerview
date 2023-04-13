package coatocl.exaatocl.nestedrecyclerviewwithroomdatabase;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;
import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>
{
    List<CustomModel>listItem = new ArrayList<>();

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.parent,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        CustomModel customModel = listItem.get(position);

        Log.d("check-->", customModel.getCustom_date());

        String dateString = customModel.getCustom_date();
        @SuppressLint("SimpleDateFormat")
        DateFormat df = new SimpleDateFormat("dd/MM/yy");

        @SuppressLint("SimpleDateFormat")
        DateFormat df2 = new SimpleDateFormat("EEE");

        Date readDate = null;
        try {
            readDate = df.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(readDate.getTime());

        String date = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
        int dateFinal =  Integer.parseInt(date);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);

        cal.set(month,dateFinal);
        Date date2 = new Date(year, month, dateFinal-1);
        Date date3 = new Date(year, month, dateFinal);

        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat format = new SimpleDateFormat("MM");

        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat formatDate = new SimpleDateFormat("dd");

        String dayMonthFormat = format.format(date2);
        String dateFormat = formatDate.format(date3);
        String monthYear = dayMonthFormat +"."+year;
        String dayOfWeek = df2.format(date2);

        holder.dateAdapter.setText(dateFormat);
        holder.dayAdapter.setText(dayOfWeek);
        holder.month_yearAdapter.setText(monthYear);

        Log.d(TAG, "YearMonth: "+monthYear);
        Log.d(TAG, "Date: "+dateFormat);
        Log.d(TAG, "Day: "+dayOfWeek);

        holder.incomeAdapter.setText(customModel.getCustom_amount());
        holder.categoryAdapter.setText(customModel.getCustom_category());
        holder.noteAdapter.setText(customModel.getCustom_note());
        holder.accountAdapter.setText(customModel.getCustom_account());
        holder.amountAdapter.setText(customModel.getCustom_amount());

    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }
    @SuppressLint("NotifyDataSetChanged")
    public void setListItem(List<CustomModel>listItem)
    {
        this.listItem=listItem;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView dateAdapter,dayAdapter,month_yearAdapter,incomeAdapter,categoryAdapter,noteAdapter,accountAdapter,amountAdapter;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            dateAdapter = itemView.findViewById(R.id.dateAdapter);
            dayAdapter = itemView.findViewById(R.id.dayAdapter);
            month_yearAdapter = itemView.findViewById(R.id.month_yearAdapter);
            incomeAdapter = itemView.findViewById(R.id.incomeAdapter);
            categoryAdapter = itemView.findViewById(R.id.categoryAdapter);
            noteAdapter = itemView.findViewById(R.id.noteAdapter);
            accountAdapter = itemView.findViewById(R.id.accountAdapter);
            amountAdapter = itemView.findViewById(R.id.amountAdapter);

        }
    }
}
