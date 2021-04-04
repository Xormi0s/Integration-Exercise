package be.ucll.integrationexercise;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

@Dao
public interface WorkOrderDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(WorkOrder workOrder);

    @Query("DELETE FROM WorkOrder")
    void deleteAll();

    @Query("SELECT * FROM WorkOrder")
    @Transaction
    LiveData<List<WorkOrder>> getWorkOrder();

    @Query("SELECT * FROM WorkOrder where user =(:user)")
    @Transaction
    LiveData<List<WorkOrder>> getOrders(String user);

    @Update
    @Transaction
    void updateWorkOrder(WorkOrder workOrder);

    @Query("SELECT * FROM WorkOrder where orderID =(:id)")
    @Transaction
    LiveData<WorkOrder> getDetails(int id);
}
