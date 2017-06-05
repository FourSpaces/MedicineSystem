package com.model;

import javax.persistence.*;

/**
 * Created by kevin on 17-2-13.
 */
@Entity
@Table(name = "medicine_use", schema = "medicalsystem", catalog = "")
public class MedicineUseEntity {
    private int id;
    private Integer bedId;
    private Integer nurseId;
    private Integer pid;
    private Integer course;
    private Integer takeTime;
    private String remark;
    private Byte status;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "nurse_id", nullable = true)
    public Integer getNurseId() {
        return nurseId;
    }

    public void setNurseId(Integer nurseId) {
        this.nurseId = nurseId;
    }

    @Basic
    @Column(name = "pid", nullable = true)
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "course", nullable = true)
    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    @Basic
    @Column(name = "take_time", nullable = true)
    public Integer getTakeTime() {
        return takeTime;
    }

    public void setTakeTime(Integer takeTime) {
        this.takeTime = takeTime;
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

        MedicineUseEntity that = (MedicineUseEntity) o;

        if (id != that.id) return false;
        if (bedId != null ? !bedId.equals(that.bedId) : that.bedId != null) return false;
        if (nurseId != null ? !nurseId.equals(that.nurseId) : that.nurseId != null) return false;
        if (pid != null ? !pid.equals(that.pid) : that.pid != null) return false;
        if (course != null ? !course.equals(that.course) : that.course != null) return false;
        if (takeTime != null ? !takeTime.equals(that.takeTime) : that.takeTime != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (bedId != null ? bedId.hashCode() : 0);
        result = 31 * result + (nurseId != null ? nurseId.hashCode() : 0);
        result = 31 * result + (pid != null ? pid.hashCode() : 0);
        result = 31 * result + (course != null ? course.hashCode() : 0);
        result = 31 * result + (takeTime != null ? takeTime.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
