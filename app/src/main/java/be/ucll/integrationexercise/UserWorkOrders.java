package be.ucll.integrationexercise;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class UserWorkOrders {
    @Embedded public User user;
    @Relation(
        parentColumn = "orderID",
        entityColumn = "workOrders"
    )
    public List<WorkOrder> workOrderList;
}
