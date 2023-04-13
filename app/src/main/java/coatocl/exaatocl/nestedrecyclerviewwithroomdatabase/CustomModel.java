package coatocl.exaatocl.nestedrecyclerviewwithroomdatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "income_details")
public class CustomModel
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "custom_id")
    long custom_id;

    @ColumnInfo(name = "custom_date")
    String custom_date;

    @ColumnInfo(name = "custom_account")
    String custom_account;

    @ColumnInfo(name = "custom_category")
    String custom_category;

    @ColumnInfo(name = "custom_amount")
    String custom_amount;

    @ColumnInfo(name = "custom_note")
    String custom_note;

    @ColumnInfo(name = "custom_description")
    String custom_description;

    public CustomModel(String custom_date, String custom_account, String custom_category, String custom_amount, String custom_note, String custom_description) {
        this.custom_date = custom_date;
        this.custom_account = custom_account;
        this.custom_category = custom_category;
        this.custom_amount = custom_amount;
        this.custom_note = custom_note;
        this.custom_description = custom_description;
    }

    public long getCustom_id() {
        return custom_id;
    }

    public void setCustom_id(long custom_id) {
        this.custom_id = custom_id;
    }

    public String getCustom_date() {
        return custom_date;
    }

    public String getCustom_account() {
        return custom_account;
    }

    public String getCustom_category() {
        return custom_category;
    }

    public String getCustom_amount() {
        return custom_amount;
    }

    public String getCustom_note() {
        return custom_note;
    }

    public String getCustom_description() {
        return custom_description;
    }
}
