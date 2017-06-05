package com.model;

import javax.persistence.*;

/**
 * Created by kevin on 17-2-13.
 */
@Entity
@Table(name = "cost", schema = "medicalsystem", catalog = "")
public class CostEntity {
    private int cid;
    private Integer rid;
    private Integer costType;
    private Integer receivableProject;
    private Double receivable;
    private Double delivery;
    private Byte isReceivable;
    private Integer createTime;
    private Integer updateTime;
    private String remark;
    private Byte status;

    @Id
    @Column(name = "cid", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
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
    @Column(name = "cost_type", nullable = true)
    public Integer getCostType() {
        return costType;
    }

    public void setCostType(Integer costType) {
        this.costType = costType;
    }

    @Basic
    @Column(name = "receivable_project", nullable = true)
    public Integer getReceivableProject() {
        return receivableProject;
    }

    public void setReceivableProject(Integer receivableProject) {
        this.receivableProject = receivableProject;
    }

    @Basic
    @Column(name = "receivable", nullable = true, precision = 3)
    public Double getReceivable() {
        return receivable;
    }

    public void setReceivable(Double receivable) {
        this.receivable = receivable;
    }

    @Basic
    @Column(name = "delivery", nullable = true, precision = 3)
    public Double getDelivery() {
        return delivery;
    }

    public void setDelivery(Double delivery) {
        this.delivery = delivery;
    }

    @Basic
    @Column(name = "is_receivable", nullable = true)
    public Byte getIsReceivable() {
        return isReceivable;
    }

    public void setIsReceivable(Byte isReceivable) {
        this.isReceivable = isReceivable;
    }

    @Basic
    @Column(name = "create_time", nullable = true)
    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time", nullable = true)
    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
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

        CostEntity that = (CostEntity) o;

        if (cid != that.cid) return false;
        if (rid != null ? !rid.equals(that.rid) : that.rid != null) return false;
        if (costType != null ? !costType.equals(that.costType) : that.costType != null) return false;
        if (receivableProject != null ? !receivableProject.equals(that.receivableProject) : that.receivableProject != null)
            return false;
        if (receivable != null ? !receivable.equals(that.receivable) : that.receivable != null) return false;
        if (delivery != null ? !delivery.equals(that.delivery) : that.delivery != null) return false;
        if (isReceivable != null ? !isReceivable.equals(that.isReceivable) : that.isReceivable != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cid;
        result = 31 * result + (rid != null ? rid.hashCode() : 0);
        result = 31 * result + (costType != null ? costType.hashCode() : 0);
        result = 31 * result + (receivableProject != null ? receivableProject.hashCode() : 0);
        result = 31 * result + (receivable != null ? receivable.hashCode() : 0);
        result = 31 * result + (delivery != null ? delivery.hashCode() : 0);
        result = 31 * result + (isReceivable != null ? isReceivable.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
