package com.model;

import javax.persistence.*;

/**
 * Created by Kevin on 2017/4/4.
 */
@Entity
@Table(name = "diagnosis", schema = "medicalsystem", catalog = "")
public class DiagnosisEntity {
    private int did;
    private String content;
    private Integer createTime;
    private String describes;
    private String remark;
    private Byte resolvent;
    private Byte types;
    private Integer rid;
    private Integer sid;
    private Byte status;

    @Id
    @Column(name = "did")
    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "create_time")
    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "describes")
    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
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
    @Column(name = "resolvent")
    public Byte getResolvent() {
        return resolvent;
    }

    public void setResolvent(Byte resolvent) {
        this.resolvent = resolvent;
    }

    @Basic
    @Column(name = "types")
    public Byte getTypes() {
        return types;
    }

    public void setTypes(Byte types) {
        this.types = types;
    }

    @Basic
    @Column(name = "rid")
    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    @Basic
    @Column(name = "sid")
    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "status")
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

        DiagnosisEntity that = (DiagnosisEntity) o;

        if (did != that.did) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (describes != null ? !describes.equals(that.describes) : that.describes != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (resolvent != null ? !resolvent.equals(that.resolvent) : that.resolvent != null) return false;
        if (types != null ? !types.equals(that.types) : that.types != null) return false;
        if (rid != null ? !rid.equals(that.rid) : that.rid != null) return false;
        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = did;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (describes != null ? describes.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (resolvent != null ? resolvent.hashCode() : 0);
        result = 31 * result + (types != null ? types.hashCode() : 0);
        result = 31 * result + (rid != null ? rid.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
