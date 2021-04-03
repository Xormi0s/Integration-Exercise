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

    @Query("DELETE FROM Users_table")
    void deleteAll();

    @Query("SELECT * FROM Users_table")
    LiveData<List<User>> getUser();

    @Query("SELECT * FROM Users_table where username =(:user) and password =(:pass)")
    @Transaction
    LiveData<User> login(String user, String pass);

}
