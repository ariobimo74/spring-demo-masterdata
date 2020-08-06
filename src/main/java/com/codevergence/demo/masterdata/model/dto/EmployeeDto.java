package com.codevergence.demo.masterdata.model.dto;

import com.codevergence.demo.masterdata.model.entity.EmployeeType;
import com.codevergence.demo.masterdata.model.entity.Placement;

public class EmployeeDto
{
    private long id;
    private String npk;
    private String name;
    private String officeEmail;
    private long typeId;
    private String typeName;
    private long placementId;
    private String placementName;

    public EmployeeDto() {
    }

    public EmployeeDto(long id, String npk, String name, String officeEmail, long typeId, String typeName, long placementId, String placementName) {
        this.id = id;
        this.npk = npk;
        this.name = name;
        this.officeEmail = officeEmail;
        this.typeId = typeId;
        this.typeName = typeName;
        this.placementId = placementId;
        this.placementName = placementName;
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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public long getPlacementId() {
        return placementId;
    }

    public void setPlacementId(long placementId) {
        this.placementId = placementId;
    }

    public String getPlacementName() {
        return placementName;
    }

    public void setPlacementName(String placementName) {
        this.placementName = placementName;
    }
}
