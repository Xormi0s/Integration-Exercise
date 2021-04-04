package be.ucll.integrationexercise;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UserWorkOrderRepository {

    private UserDao userDao;
    private WorkOrderDao workOrderDao;
    private LiveData<List<WorkOrder>> allUsersWorkOrders;

    UserWorkOrderRepository(Application application) {
        UserRoomDatabase db = UserRoomDatabase.getDatabase(application);
        userDao = db.userDao();
        workOrderDao = db.workOrderDao();
        allUsersWorkOrders = workOrderDao.getWorkOrder();
    }

    LiveData<List<WorkOrder>> getAllUsersWorkOrders() {
        return allUsersWorkOrders;
    }

    void insertUser(User user) {
        UserRoomDatabase.databaseWriteExecutor.execute(() -> {
            userDao.insert(user);
        });
    }

    LiveData<User> login(String user, String pass){
       return userDao.login(user, pass);
    }

    void insertWorkorder(WorkOrder workOrder){
        UserRoomDatabase.databaseWriteExecutor.execute(() -> {
            workOrderDao.insert(workOrder);
        });
    }

    LiveData<List<WorkOrder>> getWorkOrders(String user){ return workOrderDao.getOrders(user); }

    public void updateWorkOrder(WorkOrder workOrder) {
        UserRoomDatabase.databaseWriteExecutor.execute(() -> {
            workOrderDao.updateWorkOrder(workOrder);
        });
    }

    LiveData<WorkOrder> getDetails(int id) { return  workOrderDao.getDetails(id); }
}
