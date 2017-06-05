package com.model;

import javax.persistence.*;

/**
 * Created by kevin on 17-2-13.
 */
@Entity
@Table(name = "medicine_stock", schema = "medicalsystem", catalog = "")
public class MedicineStockEntity {
    private int id;
    private Integer mid;
    private Integer createTime;
    private Integer createNumber;
    private Integer use;
    private Integer productionDate;
    private Integer shelfLife;
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
    @Column(name = "mid", nullable = true)
    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
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
    @Column(name = "create_number", nullable = true)
    public Integer getCreateNumber() {
        return createNumber;
    }

    public void setCreateNumber(Integer createNumber) {
        this.createNumber = createNumber;
    }

    @Basic
    @Column(name = "use", nullable = true)
    public Integer getUse() {
        return use;
    }

    public void setUse(Integer use) {
        this.use = use;
    }

    @Basic
    @Column(name = "production_date", nullable = true)
    public Integer getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Integer productionDate) {
        this.productionDate = productionDate;
    }

    @Basic
    @Column(name = "shelf_life", nullable = true)
    public Integer getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(Integer shelfLife) {
        this.shelfLife = shelfLife;
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

        MedicineStockEntity that = (MedicineStockEntity) o;

        if (id != that.id) return false;
        if (mid != null ? !mid.equals(that.mid) : that.mid != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (createNumber != null ? !createNumber.equals(that.createNumber) : that.createNumber != null) return false;
        if (use != null ? !use.equals(that.use) : that.use != null) return false;
        if (productionDate != null ? !productionDate.equals(that.productionDate) : that.productionDate != null)
            return false;
        if (shelfLife != null ? !shelfLife.equals(that.shelfLife) : that.shelfLife != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (mid != null ? mid.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (createNumber != null ? createNumber.hashCode() : 0);
        result = 31 * result + (use != null ? use.hashCode() : 0);
        result = 31 * result + (productionDate != null ? productionDate.hashCode() : 0);
        result = 31 * result + (shelfLife != null ? shelfLife.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
