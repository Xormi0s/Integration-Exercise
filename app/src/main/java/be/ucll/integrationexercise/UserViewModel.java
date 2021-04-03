package be.ucll.integrationexercise;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private UserRepository mRepository;

    private final LiveData<List<User>> allUsers;

    public UserViewModel (Application application) {
        super(application);
        mRepository = new UserRepository(application);
        allUsers = mRepository.getAllUsers();
    }

    LiveData<List<User>> getAllUsers() { return allUsers; }

    public void insert(User user) { mRepository.insert(user); }

    public LiveData<User> login(String user, String pass){ return mRepository.login(user, pass);}
}
