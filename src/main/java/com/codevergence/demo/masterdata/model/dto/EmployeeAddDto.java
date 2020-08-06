package com.codevergence.demo.masterdata.model.dto;

public class EmployeeAddDto
{
    private long id;
    private String npk;
    private String name;
    private String officeEmail;
    private long typeId;
    private long placementId;

    public EmployeeAddDto() {
    }

    public EmployeeAddDto(long id, String npk, String name, String officeEmail, long typeId, long placementId) {
        this.id = id;
        this.npk = npk;
        this.name = name;
        this.officeEmail = officeEmail;
        this.typeId = typeId;
        this.placementId = placementId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNpk() {
        return npk;
    }

    public void setNpk(String npk) {
        this.npk = npk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOfficeEmail() {
        return officeEmail;
    }

    public void setOfficeEmail(String officeEmail) {
        this.officeEmail = officeEmail;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public long getPlacementId() {
        return placementId;
    }

    public void setPlacementId(long placementId) {
        this.placementId = placementId;
    }
}
