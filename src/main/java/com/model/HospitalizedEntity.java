package com.model;

import javax.persistence.*;

/**
 * Created by kevin on 17-2-13.
 */
@Entity
@Table(name = "hospitalized", schema = "medicalsystem", catalog = "")
public class HospitalizedEntity {
    private int hid;
    private Integer rid;
    private Integer sid;
    private Integer bedId;
    private String pathogeny;
    private Integer checkTime;
    private Integer tuisuTime;
    private Double costValue;
    private Double balance;
    private Byte hospitalizedStatus;
    private Integer department;
    private String remark;
    private Byte status;

    @Id
    @Column(name = "hid", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    @Basic
    @Column(name = "rid", nullable = true)
    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    @Basic
    @Column(name = "sid", nullable = true)
    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "bed_id", nullable = true)
    public Integer getBedId() {
        return bedId;
    }

    public void setBedId(Integer bedId) {
        this.bedId = bedId;
    }

    @Basic
    @Column(name = "pathogeny", nullable = true, length = 120)
    public String getPathogeny() {
        return pathogeny;
    }

    public void setPathogeny(String pathogeny) {
        this.pathogeny = pathogeny;
    }

    @Basic
    @Column(name = "check_time", nullable = true)
    public Integer getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Integer checkTime) {
        this.checkTime = checkTime;
    }

    @Basic
    @Column(name = "tuisu_time", nullable = true)
    public Integer getTuisuTime() {
        return tuisuTime;
    }

    public void setTuisuTime(Integer tuisuTime) {
        this.tuisuTime = tuisuTime;
    }

    @Basic
    @Column(name = "cost_value", nullable = true, precision = 3)
    public Double getCostValue() {
        return costValue;
    }

    public void setCostValue(Double costValue) {
        this.costValue = costValue;
    }

    @Basic
    @Column(name = "balance", nullable = true, precision = 3)
    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "hospitalized_status", nullable = true)
    public Byte getHospitalizedStatus() {
        return hospitalizedStatus;
    }

    public void setHospitalizedStatus(Byte hospitalizedStatus) {
        this.hospitalizedStatus = hospitalizedStatus;
    }

    @Basic
    @Column(name = "department", nullable = true)
    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    @Basic
    @Column(name = "remark", nullable = true, length = 200)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "status", nullable = true)
    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HospitalizedEntity that = (HospitalizedEntity) o;

        if (hid != that.hid) return false;
        if (rid != null ? !rid.equals(that.rid) : that.rid != null) return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (bedId != null ? !bedId.equals(that.bedId) : that.bedId != null) return false;
        if (pathogeny != null ? !pathogeny.equals(that.pathogeny) : that.pathogeny != null) return false;
        if (checkTime != null ? !checkTime.equals(that.checkTime) : that.checkTime != null) return false;
        if (tuisuTime != null ? !tuisuTime.equals(that.tuisuTime) : that.tuisuTime != null) return false;
        if (costValue != null ? !costValue.equals(that.costValue) : that.costValue != null) return false;
        if (balance != null ? !balance.equals(that.balance) : that.balance != null) return false;
        if (hospitalizedStatus != null ? !hospitalizedStatus.equals(that.hospitalizedStatus) : that.hospitalizedStatus != null)
            return false;
        if (department != null ? !department.equals(that.department) : that.department != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hid;
        result = 31 * result + (rid != null ? rid.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (bedId != null ? bedId.hashCode() : 0);
        result = 31 * result + (pathogeny != null ? pathogeny.hashCode() : 0);
        result = 31 * result + (checkTime != null ? checkTime.hashCode() : 0);
        result = 31 * result + (tuisuTime != null ? tuisuTime.hashCode() : 0);
        result = 31 * result + (costValue != null ? costValue.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (hospitalizedStatus != null ? hospitalizedStatus.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
