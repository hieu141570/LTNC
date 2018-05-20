/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OBJECT;

import java.sql.Date;

/**
 *
 * @author Hieu
 */
public class Medicine {
    private int id;
    private String tenThuoc;
    private String maThuoc;
    private String nhaSanXuat;
    private String packType;
    private String unitType;
    private int unitPerPackage;
    private Date nsx;
    private Date hsd;
    private int soLuong;
    private int donGia;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the tenThuoc
     */
    public String getTenThuoc() {
        return tenThuoc;
    }

    /**
     * @param tenThuoc the tenThuoc to set
     */
    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    /**
     * @return the maThuoc
     */
    public String getMaThuoc() {
        return maThuoc;
    }

    /**
     * @param maThuoc the maThuoc to set
     */
    public void setMaThuoc(String maThuoc) {
        this.maThuoc = maThuoc;
    }

    /**
     * @return the nhaSanXuat
     */
    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    /**
     * @param nhaSanXuat the nhaSanXuat to set
     */
    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    /**
     * @return the packType
     */
    public String getPackType() {
        return packType;
    }

    /**
     * @param packType the packType to set
     */
    public void setPackType(String packType) {
        this.packType = packType;
    }

    /**
     * @return the unitType
     */
    public String getUnitType() {
        return unitType;
    }

    /**
     * @param unitType the unitType to set
     */
    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    /**
     * @return the unitPerPackage
     */
    public int getUnitPerPackage() {
        return unitPerPackage;
    }

    /**
     * @param unitPerPackage the unitPerPackage to set
     */
    public void setUnitPerPackage(int unitPerPackage) {
        this.unitPerPackage = unitPerPackage;
    }

    /**
     * @return the nsx
     */
    public Date getNsx() {
        return nsx;
    }

    /**
     * @param nsx the nsx to set
     */
    public void setNsx(Date nsx) {
        this.nsx = nsx;
    }

    /**
     * @return the hsd
     */
    public Date getHsd() {
        return hsd;
    }

    /**
     * @param hsd the hsd to set
     */
    public void setHsd(Date hsd) {
        this.hsd = hsd;
    }

    /**
     * @return the soLuong
     */
    public int getSoLuong() {
        return soLuong;
    }

    /**
     * @param soLuong the soLuong to set
     */
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    /**
     * @return the donGia
     */
    public int getDonGia() {
        return donGia;
    }

    /**
     * @param donGia the donGia to set
     */
    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }
}
