package com.codevergence.demo.masterdata.model.dto;

import java.util.Date;

public class EmployeeAddDto
{
    private long id;
    private String npk;
    private String name;
    private String officeEmail;
    private long typeId;
    private long placementId;


    private Date createdDate;
    private String createdBy;
    private Date modifiedDate;
    private String modifiedBy;
    private Date deletedDate;
    private String deletedBy;
    private boolean isDelete;

    public EmployeeAddDto() {
    }

    public EmployeeAddDto(long id, String npk, String name, String officeEmail, long typeId, long placementId, Date createdDate, String createdBy, Date modifiedDate, String modifiedBy, Date deletedDate, String deletedBy, boolean isDelete) {
        this.id = id;
        this.npk = npk;
        this.name = name;
        this.officeEmail = officeEmail;
        this.typeId = typeId;
        this.placementId = placementId;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.modifiedDate = modifiedDate;
        this.modifiedBy = modifiedBy;
        this.deletedDate = deletedDate;
        this.deletedBy = deletedBy;
        this.isDelete = isDelete;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Date deletedDate) {
        this.deletedDate = deletedDate;
    }

    public String getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
