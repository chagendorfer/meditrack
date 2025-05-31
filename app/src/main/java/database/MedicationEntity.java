package database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "medications")
public class MedicationEntity {
    @PrimaryKey(autoGenerate = true)
    int id;

    public String name;
    public double dosageAmount;
    public String dosageUnit;
    public String intakeTime;
    public String startDate;
    public String endDate;
    public int packageSize;

    public boolean reminderEnabled;


}