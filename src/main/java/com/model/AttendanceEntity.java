package com.model;

import javax.persistence.*;

/**
 * Created by kevin on 17-2-13.
 */
@Entity
@Table(name = "attendance", schema = "medicalsystem", catalog = "")
public class AttendanceEntity {
    private int aid;
    private Integer sid;
    private Integer startWork;
    private Integer endWork;
    private Integer workload;
    private String remark;
    private Byte status;

    @Id
    @Column(name = "aid", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
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
    @Column(name = "start_work", nullable = true)
    public Integer getStartWork() {
        return startWork;
    }

    public void setStartWork(Integer startWork) {
        this.startWork = startWork;
    }

    @Basic
    @Column(name = "end_work", nullable = true)
    public Integer getEndWork() {
        return endWork;
    }

    public void setEndWork(Integer endWork) {
        this.endWork = endWork;
    }

    @Basic
    @Column(name = "workload", nullable = true)
    public Integer getWorkload() {
        return workload;
    }

    public void setWorkload(Integer workload) {
        this.workload = workload;
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

        AttendanceEntity that = (AttendanceEntity) o;

        if (aid != that.aid) return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (startWork != null ? !startWork.equals(that.startWork) : that.startWork != null) return false;
        if (endWork != null ? !endWork.equals(that.endWork) : that.endWork != null) return false;
        if (workload != null ? !workload.equals(that.workload) : that.workload != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aid;
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (startWork != null ? startWork.hashCode() : 0);
        result = 31 * result + (endWork != null ? endWork.hashCode() : 0);
        result = 31 * result + (workload != null ? workload.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
