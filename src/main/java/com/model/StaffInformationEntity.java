package com.model;

import javax.persistence.*;

/**
 * Created by Kevin on 2017/4/3.
 */
@Entity
@Table(name = "staff_information", schema = "medicalsystem", catalog = "")
public class StaffInformationEntity {
    private int sid;
    private String address;
    private Integer department;
    private Integer departureTime;
    private String idCard;
    private Integer inductionTime;
    private String jobNumber;
    private String password;
    private Integer jobType;
    private String name;
    private Byte organization;
    private String phone;
    private String remark;
    private Byte sex;
    private Byte status;
    private String title;

    @Id
    @Column(name = "sid")
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "department")
    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    @Basic
    @Column(name = "departure_time")
    public Integer getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Integer departureTime) {
        this.departureTime = departureTime;
    }

    @Basic
    @Column(name = "id_card")
    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Basic
    @Column(name = "induction_time")
    public Integer getInductionTime() {
        return inductionTime;
    }

    public void setInductionTime(Integer inductionTime) {
        this.inductionTime = inductionTime;
    }

    @Basic
    @Column(name = "job_number")
    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "job_type")
    public Integer getJobType() {
        return jobType;
    }

    public void setJobType(Integer jobType) {
        this.jobType = jobType;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "organization")
    public Byte getOrganization() {
        return organization;
    }

    public void setOrganization(Byte organization) {
        this.organization = organization;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "sex")
    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "status")
    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StaffInformationEntity that = (StaffInformationEntity) o;

        if (sid != that.sid) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (department != null ? !department.equals(that.department) : that.department != null) return false;
        if (departureTime != null ? !departureTime.equals(that.departureTime) : that.departureTime != null)
            return false;
        if (idCard != null ? !idCard.equals(that.idCard) : that.idCard != null) return false;
        if (inductionTime != null ? !inductionTime.equals(that.inductionTime) : that.inductionTime != null)
            return false;
        if (jobNumber != null ? !jobNumber.equals(that.jobNumber) : that.jobNumber != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (jobType != null ? !jobType.equals(that.jobType) : that.jobType != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (organization != null ? !organization.equals(that.organization) : that.organization != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sid;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (departureTime != null ? departureTime.hashCode() : 0);
        result = 31 * result + (idCard != null ? idCard.hashCode() : 0);
        result = 31 * result + (inductionTime != null ? inductionTime.hashCode() : 0);
        result = 31 * result + (jobNumber != null ? jobNumber.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (jobType != null ? jobType.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (organization != null ? organization.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}
