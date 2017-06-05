package com.model;

import javax.persistence.*;

/**
 * Created by kevin on 17-2-13.
 */
@Entity
@Table(name = "bed", schema = "medicalsystem", catalog = "")
public class BedEntity {
    private int id;
    private Integer rid;
    private Integer sid;
    private Integer department;
    private Integer bedId;
    private String pathogeny;
    private String name;
    private Byte sex;
    private Integer updateTime;
    private String remark;
    private Byte status;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "department", nullable = true)
    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
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
    @Column(name = "name", nullable = true, length = 14)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "sex", nullable = true)
    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
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

        BedEntity bedEntity = (BedEntity) o;

        if (id != bedEntity.id) return false;
        if (rid != null ? !rid.equals(bedEntity.rid) : bedEntity.rid != null) return false;
        if (sid != null ? !sid.equals(bedEntity.sid) : bedEntity.sid != null) return false;
        if (department != null ? !department.equals(bedEntity.department) : bedEntity.department != null) return false;
        if (bedId != null ? !bedId.equals(bedEntity.bedId) : bedEntity.bedId != null) return false;
        if (pathogeny != null ? !pathogeny.equals(bedEntity.pathogeny) : bedEntity.pathogeny != null) return false;
        if (name != null ? !name.equals(bedEntity.name) : bedEntity.name != null) return false;
        if (sex != null ? !sex.equals(bedEntity.sex) : bedEntity.sex != null) return false;
        if (updateTime != null ? !updateTime.equals(bedEntity.updateTime) : bedEntity.updateTime != null) return false;
        if (remark != null ? !remark.equals(bedEntity.remark) : bedEntity.remark != null) return false;
        if (status != null ? !status.equals(bedEntity.status) : bedEntity.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (rid != null ? rid.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (bedId != null ? bedId.hashCode() : 0);
        result = 31 * result + (pathogeny != null ? pathogeny.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
