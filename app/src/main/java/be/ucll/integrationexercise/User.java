package be.ucll.integrationexercise;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity
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

    //private List<WorkOrder> workOrders;

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

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    @NonNull
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(@NonNull String firstname) {
        this.firstname = firstname;
    }

    @NonNull
    public String getLastname() {
        return lastname;
    }

    public void setLastname(@NonNull String lastname) {
        this.lastname = lastname;
    }

    /*public List<WorkOrder> getWorkOrders() {
        return workOrders;
    }

    public void setWorkOrders(List<WorkOrder> workOrders) {
        this.workOrders = workOrders;
    }*/
}
