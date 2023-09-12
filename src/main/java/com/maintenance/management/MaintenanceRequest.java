package com.maintenance.management;

public class MaintenanceRequest {
    private int id;
    private String unitNumber;
    private String status;
    private String description;
    private String requestStatus;

    public MaintenanceRequest(int id, String unitNumber, String status, String description, String requestStatus) {
        this.id = id;
        this.unitNumber = unitNumber;
        this.status = status;
        this.description = description;
        this.requestStatus = requestStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }
}
