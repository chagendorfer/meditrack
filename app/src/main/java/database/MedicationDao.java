package database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MedicationDao {
    @Insert
    void insert(MedicationEntity medication);

    @Delete
    void delete(MedicationEntity medication);

    @Query("SELECT * FROM medications")
    List<MedicationEntity> getAllMedications(); //TODO
}
