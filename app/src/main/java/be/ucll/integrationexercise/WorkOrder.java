package be.ucll.integrationexercise;

import androidx.annotation.NonNull;
import androidx.room.PrimaryKey;

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

    public WorkOrder(int orderID, @NonNull String city, @NonNull String device, @NonNull String problemCode, @NonNull String customerName) {
        this.orderID = orderID;
        this.city = city;
        this.device = device;
        this.problemCode = problemCode;
        this.customerName = customerName;
    }

    @NonNull
    public int getOrderID() {
        return orderID;
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
