package com.ltc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseModel {

//    @Transient
//    protected String key;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "is_deleted")
    protected Boolean deleted;

    @Column(name = "created_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdDate;

    @Column(name = "created_by", updatable = false)
    protected String createdBy;

    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date updatedDate;

    @Column(name = "updated_by")
    protected String updatedBy;

    protected BaseModel() {
        createdDate = new Date();
        deleted = false;
        this.updatedDate = createdDate;
    }

    public BaseModel(String createdBy) {
        this.createdBy = createdBy;
        this.createdDate = new Date();
        this.updatedDate = createdDate;
        this.deleted = false;
        this.updatedBy = createdBy;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
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

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
//
//    public String getKey() {
//        return key;
//    }
//
//    public void setKey(String key) {
//        this.key = key;
//    }

}
