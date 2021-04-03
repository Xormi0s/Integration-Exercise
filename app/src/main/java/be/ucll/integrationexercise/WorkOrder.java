package be.ucll.integrationexercise;

import androidx.annotation.NonNull;
import androidx.room.PrimaryKey;

public class WorkOrder {

    @PrimaryKey(autoGenerate =  true)
    private int orderID;

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

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    @NonNull
    public String getCity() {
        return city;
    }

    public void setCity(@NonNull String city) {
        this.city = city;
    }

    @NonNull
    public String getDevice() {
        return device;
    }

    public void setDevice(@NonNull String device) {
        this.device = device;
    }

    @NonNull
    public String getProblemCode() {
        return problemCode;
    }

    public void setProblemCode(@NonNull String problemCode) {
        this.problemCode = problemCode;
    }

    @NonNull
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(@NonNull String customerName) {
        this.customerName = customerName;
    }

    public Boolean getProcessed() {
        return processed;
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
