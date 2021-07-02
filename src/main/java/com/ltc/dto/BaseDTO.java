package com.ltc.dto;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class BaseDTO implements Serializable {

    protected Boolean deleted;

    protected Date createdDate;

    protected String createdBy;

    protected Date updatedDate;

    protected String updatedBy;


    protected BaseDTO() {
        createdDate = new Date();
        deleted = false;
        this.updatedDate = createdDate;
    }

    public BaseDTO(String createdBy) {
        this.createdBy = createdBy;
        this.createdDate = new Date();
        this.updatedDate = createdDate;
        this.deleted = false;
        this.updatedBy = createdBy;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
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

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

}
