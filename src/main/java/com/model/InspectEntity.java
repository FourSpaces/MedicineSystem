package com.model;

import javax.persistence.*;

/**
 * Created by kevin on 17-2-13.
 */
@Entity
@Table(name = "inspect", schema = "medicalsystem", catalog = "")
public class InspectEntity {
    private int iid;
    private Integer rid;
    private Integer sid;
    private String inspectTitle;
    private String inspectResult;
    private Integer inspectTime;
    private Byte costStatus;
    private String remark;
    private Byte status;

    @Id
    @Column(name = "iid", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
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
    @Column(name = "inspect_title", nullable = true, length = 60)
    public String getInspectTitle() {
        return inspectTitle;
    }

    public void setInspectTitle(String inspectTitle) {
        this.inspectTitle = inspectTitle;
    }

    @Basic
    @Column(name = "inspect_result", nullable = true, length = 255)
    public String getInspectResult() {
        return inspectResult;
    }

    public void setInspectResult(String inspectResult) {
        this.inspectResult = inspectResult;
    }

    @Basic
    @Column(name = "inspect_time", nullable = true)
    public Integer getInspectTime() {
        return inspectTime;
    }

    public void setInspectTime(Integer inspectTime) {
        this.inspectTime = inspectTime;
    }

    @Basic
    @Column(name = "cost_status", nullable = true)
    public Byte getCostStatus() {
        return costStatus;
    }

    public void setCostStatus(Byte costStatus) {
        this.costStatus = costStatus;
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

        InspectEntity that = (InspectEntity) o;

        if (iid != that.iid) return false;
        if (rid != null ? !rid.equals(that.rid) : that.rid != null) return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (inspectTitle != null ? !inspectTitle.equals(that.inspectTitle) : that.inspectTitle != null) return false;
        if (inspectResult != null ? !inspectResult.equals(that.inspectResult) : that.inspectResult != null)
            return false;
        if (inspectTime != null ? !inspectTime.equals(that.inspectTime) : that.inspectTime != null) return false;
        if (costStatus != null ? !costStatus.equals(that.costStatus) : that.costStatus != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iid;
        result = 31 * result + (rid != null ? rid.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (inspectTitle != null ? inspectTitle.hashCode() : 0);
        result = 31 * result + (inspectResult != null ? inspectResult.hashCode() : 0);
        result = 31 * result + (inspectTime != null ? inspectTime.hashCode() : 0);
        result = 31 * result + (costStatus != null ? costStatus.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
