package be.ucll.integrationexercise;

import android.app.Application;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import java.util.List;

public class UserRepository {

    private UserDao userDao;
    private LiveData<List<User>> allUsers;

    UserRepository(Application application) {
        UserRoomDatabase db = UserRoomDatabase.getDatabase(application);
        userDao = db.userDao();
        allUsers = userDao.getUser();
    }

    LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    void insert(User user) {
        UserRoomDatabase.databaseWriteExecutor.execute(() -> {
            userDao.insert(user);
        });
    }

    LiveData<User> login(String user, String pass){
       return userDao.login(user, pass);
    }
}
