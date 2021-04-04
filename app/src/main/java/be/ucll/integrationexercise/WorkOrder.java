package be.ucll.integrationexercise;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity()
public class WorkOrder {

    @PrimaryKey(autoGenerate =  true)
    private int orderID;

    @NonNull
    private String user;

    @NonNull
    private String city;

    @NonNull
    private String device;

    @NonNull
    private String problemCode;

    @NonNull
    private String customerName;

    private Boolean processed = false;

    private String detailedProblemDescription;

    private String repairInformation;

    public WorkOrder(@NonNull String user, @NonNull String city, @NonNull String device, @NonNull String problemCode, @NonNull String customerName) {
        this.user = user;
        this.city = city;
        this.device = device;
        this.problemCode = problemCode;
        this.customerName = customerName;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    @NonNull
    public String getUser() {
        return user;
    }

    @NonNull
    public String getCity() {
        return city;
    }

    @NonNull
    public String getDevice() {
        return device;
    }

    @NonNull
    public String getProblemCode() {
        return problemCode;
    }

    @NonNull
    public String getCustomerName() {
        return customerName;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    public Boolean getProcessed() { return processed; }

    public String getDetailedProblemDescription() {
        return detailedProblemDescription;
    }

    public void setDetailedProblemDescription(String detailedProblemDescription) {
        this.detailedProblemDescription = detailedProblemDescription;
    }

    public String getRepairInformation() {
        return repairInformation;
    }

    public void setRepairInformation(String repairInformation) {
        this.repairInformation = repairInformation;
    }
}
