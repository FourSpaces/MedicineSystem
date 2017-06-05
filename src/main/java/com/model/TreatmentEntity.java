package com.model;

import javax.persistence.*;

/**
 * Created by kevin on 17-2-13.
 */
@Entity
@Table(name = "treatment", schema = "medicalsystem", catalog = "")
public class TreatmentEntity {
    private int id;
    private Integer bedId;
    private Integer doctorId;
    private Integer nurseId;
    private Integer pid;
    private Integer date;
    private Integer doseTime1;
    private Integer doseTime2;
    private Integer doseTime3;
    private Integer doseTime4;
    private String untowardEffect;
    private Byte toImprove;
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
    @Column(name = "doctor_id", nullable = true)
    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
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
    @Column(name = "date", nullable = true)
    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    @Basic
    @Column(name = "dose_time1", nullable = true)
    public Integer getDoseTime1() {
        return doseTime1;
    }

    public void setDoseTime1(Integer doseTime1) {
        this.doseTime1 = doseTime1;
    }

    @Basic
    @Column(name = "dose_time2", nullable = true)
    public Integer getDoseTime2() {
        return doseTime2;
    }

    public void setDoseTime2(Integer doseTime2) {
        this.doseTime2 = doseTime2;
    }

    @Basic
    @Column(name = "dose_time3", nullable = true)
    public Integer getDoseTime3() {
        return doseTime3;
    }

    public void setDoseTime3(Integer doseTime3) {
        this.doseTime3 = doseTime3;
    }

    @Basic
    @Column(name = "dose_time4", nullable = true)
    public Integer getDoseTime4() {
        return doseTime4;
    }

    public void setDoseTime4(Integer doseTime4) {
        this.doseTime4 = doseTime4;
    }

    @Basic
    @Column(name = "untoward_effect", nullable = true, length = 200)
    public String getUntowardEffect() {
        return untowardEffect;
    }

    public void setUntowardEffect(String untowardEffect) {
        this.untowardEffect = untowardEffect;
    }

    @Basic
    @Column(name = "to_improve", nullable = true)
    public Byte getToImprove() {
        return toImprove;
    }

    public void setToImprove(Byte toImprove) {
        this.toImprove = toImprove;
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

        TreatmentEntity that = (TreatmentEntity) o;

        if (id != that.id) return false;
        if (bedId != null ? !bedId.equals(that.bedId) : that.bedId != null) return false;
        if (doctorId != null ? !doctorId.equals(that.doctorId) : that.doctorId != null) return false;
        if (nurseId != null ? !nurseId.equals(that.nurseId) : that.nurseId != null) return false;
        if (pid != null ? !pid.equals(that.pid) : that.pid != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (doseTime1 != null ? !doseTime1.equals(that.doseTime1) : that.doseTime1 != null) return false;
        if (doseTime2 != null ? !doseTime2.equals(that.doseTime2) : that.doseTime2 != null) return false;
        if (doseTime3 != null ? !doseTime3.equals(that.doseTime3) : that.doseTime3 != null) return false;
        if (doseTime4 != null ? !doseTime4.equals(that.doseTime4) : that.doseTime4 != null) return false;
        if (untowardEffect != null ? !untowardEffect.equals(that.untowardEffect) : that.untowardEffect != null)
            return false;
        if (toImprove != null ? !toImprove.equals(that.toImprove) : that.toImprove != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (bedId != null ? bedId.hashCode() : 0);
        result = 31 * result + (doctorId != null ? doctorId.hashCode() : 0);
        result = 31 * result + (nurseId != null ? nurseId.hashCode() : 0);
        result = 31 * result + (pid != null ? pid.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (doseTime1 != null ? doseTime1.hashCode() : 0);
        result = 31 * result + (doseTime2 != null ? doseTime2.hashCode() : 0);
        result = 31 * result + (doseTime3 != null ? doseTime3.hashCode() : 0);
        result = 31 * result + (doseTime4 != null ? doseTime4.hashCode() : 0);
        result = 31 * result + (untowardEffect != null ? untowardEffect.hashCode() : 0);
        result = 31 * result + (toImprove != null ? toImprove.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
