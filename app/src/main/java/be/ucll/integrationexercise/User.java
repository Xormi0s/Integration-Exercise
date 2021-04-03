package be.ucll.integrationexercise;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "Users_table")
public class User {

    @PrimaryKey
    @NonNull
    private String username;

    @NonNull
    private String password;

    @NonNull
    private String firstname;

    @NonNull
    private String lastname;

    public User(@NonNull String username, @NonNull String password, @NonNull String firstname, @NonNull String lastname) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    @NonNull
    public String getFirstname() {
        return firstname;
    }

    @NonNull
    public String getLastname() {
        return lastname;
    }
}
