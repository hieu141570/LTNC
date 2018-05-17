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
public class HoaDon {
    private int maHoaDon;
    private Date ngayTao;
    private int maDuocSi;

    /**
     * @return the maHoaDon
     */
    public int getMaHoaDon() {
        return maHoaDon;
    }

    /**
     * @param maHoaDon the maHoaDon to set
     */
    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    /**
     * @return the ngayTao
     */
    public Date getNgayTao() {
        return ngayTao;
    }

    /**
     * @param ngayTao the ngayTao to set
     */
    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    /**
     * @return the maDuocSi
     */
    public int getMaDuocSi() {
        return maDuocSi;
    }

    /**
     * @param maDuocSi the maDuocSi to set
     */
    public void setMaDuocSi(int maDuocSi) {
        this.maDuocSi = maDuocSi;
    }
}
