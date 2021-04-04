package be.ucll.integrationexercise;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private UserWorkOrderRepository mRepository;

    private final LiveData<List<WorkOrder>> allUsersWorkOrders;

    public UserViewModel (Application application) {
        super(application);
        mRepository = new UserWorkOrderRepository(application);
        allUsersWorkOrders = mRepository.getAllUsersWorkOrders();
    }

    LiveData<List<WorkOrder>> getAllUsers() { return allUsersWorkOrders; }

    public void insertUser(User user) { mRepository.insertUser(user); }

    public LiveData<User> login(String user, String pass){ return mRepository.login(user, pass); }

    public void insertWorkOrder(WorkOrder workOrder){ mRepository.insertWorkorder(workOrder); }

    public void updateWorkOrder(WorkOrder workOrder) { mRepository.updateWorkOrder(workOrder); }

    public LiveData<List<WorkOrder>> getWorkOrderUser(String username) { return mRepository.getWorkOrders(username); }

    public LiveData<WorkOrder> getDetails(int id) { return mRepository.getDetails(id); }
}
