package com.model;

import javax.persistence.*;

/**
 * Created by kevin on 17-2-13.
 */
@Entity
@Table(name = "reservation", schema = "medicalsystem", catalog = "")
public class ReservationEntity {
    private int rid;
    private Integer uid;
    private Integer reservationDepartment;
    private Integer reservationDoctor;
    private Integer reservationCost;
    private Integer createTime;
    private String remark;
    private Byte status;

    @Id
    @Column(name = "rid", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    @Basic
    @Column(name = "uid", nullable = true)
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "reservation_department", nullable = true)
    public Integer getReservationDepartment() {
        return reservationDepartment;
    }

    public void setReservationDepartment(Integer reservationDepartment) {
        this.reservationDepartment = reservationDepartment;
    }

    @Basic
    @Column(name = "reservation_doctor", nullable = true)
    public Integer getReservationDoctor() {
        return reservationDoctor;
    }

    public void setReservationDoctor(Integer reservationDoctor) {
        this.reservationDoctor = reservationDoctor;
    }

    @Basic
    @Column(name = "reservation_cost", nullable = true)
    public Integer getReservationCost() {
        return reservationCost;
    }

    public void setReservationCost(Integer reservationCost) {
        this.reservationCost = reservationCost;
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

        ReservationEntity that = (ReservationEntity) o;

        if (rid != that.rid) return false;
        if (uid != null ? !uid.equals(that.uid) : that.uid != null) return false;
        if (reservationDepartment != null ? !reservationDepartment.equals(that.reservationDepartment) : that.reservationDepartment != null)
            return false;
        if (reservationDoctor != null ? !reservationDoctor.equals(that.reservationDoctor) : that.reservationDoctor != null)
            return false;
        if (reservationCost != null ? !reservationCost.equals(that.reservationCost) : that.reservationCost != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rid;
        result = 31 * result + (uid != null ? uid.hashCode() : 0);
        result = 31 * result + (reservationDepartment != null ? reservationDepartment.hashCode() : 0);
        result = 31 * result + (reservationDoctor != null ? reservationDoctor.hashCode() : 0);
        result = 31 * result + (reservationCost != null ? reservationCost.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
