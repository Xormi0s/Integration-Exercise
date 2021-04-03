package be.ucll.integrationexercise;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(User user);

    @Query("DELETE FROM User")
    void deleteAll();

    @Query("SELECT * FROM User")
    LiveData<List<User>> getUser();

    @Query("SELECT * FROM User where username =(:user) and password =(:pass)")
    @Transaction
    LiveData<User> login(String user, String pass);

}
