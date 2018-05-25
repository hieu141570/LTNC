/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRE;

import BUS.BUSBacSi;
import BUS.BUSBenhNhan;
import BUS.BUSDuocSi;
import BUS.BUSKhoa;
import BUS.BUSLogin;
import BUS.BUSMedicine;
import BUS.BUSThongTin;
import OBJECT.BacSi;
import OBJECT.BenhNhan;
import OBJECT.DuocSi;
import OBJECT.Login;
import OBJECT.Medicine;
import OBJECT.ThongTin;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import com.sun.org.apache.xpath.internal.operations.Bool;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.ActiveEvent;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Number;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author SunFlower
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form v_Main
     */
    public MainForm() {
        initComponents();
        showBacSi();
        showBenhNhan();
        showMedicine();
        showDuocSi();
    }

    public MainForm(int level) {
        initComponents();
        switch (level) {
            case 1:
                showBacSi();
                showBenhNhan();
                showMedicine();
                showDuocSi();
                break;
            case 2:
                jtpMain.remove(jpnDuocSi);
                jtpMain.remove(jpnBacSi);
                showBenhNhan();
                showMedicine();
                break;
            case 3:
                showMedicine();
                break;
        }

    }
    private BacSi bacSi = new BacSi();
    private DuocSi duocSi = new DuocSi();
    private int maThuoc = 0;

    private void showBacSi() {
        DefaultTableModel model = (DefaultTableModel) gridBacSi.getModel();
        model.setRowCount(0);
        BUSBacSi busBS = new BUSBacSi();
        BUSKhoa busKhoa = new BUSKhoa();
        BUSThongTin busTT = new BUSThongTin();
        ThongTin t = new ThongTin();
        ArrayList<BacSi> listBS = busBS.getDataSource();
        for (BacSi bs : listBS) {
            t = busTT.getThongTin(bs.getThongTinID());
            model.addRow(new Object[]{
                bs.getMaBS(),
                t.getHoTen(),
                t.getNamSinh(),
                t.getGioiTinh(),
                t.getSdt(),
                t.getDiaChi(),
                t.getEmail(),
                busKhoa.getNameByID(bs.getMakhoa()),
                bs.getTrinhDo()
            });
        }
    }

    private void showBenhNhan() {
        DefaultTableModel model = (DefaultTableModel) gridBenhNhan.getModel();
        model.setRowCount(0);
        BUSBenhNhan busBN = new BUSBenhNhan();
        BUSThongTin busTT = new BUSThongTin();
        ThongTin t = new ThongTin();
        ArrayList<BenhNhan> listBN = busBN.getDataSource();
        for (BenhNhan bn : listBN) {
            t = busTT.getThongTin(bn.getThongTinID());
            model.addRow(new Object[]{
                bn.getMaBenhNhan(),
                t.getHoTen(),
                t.getNamSinh(),
                t.getSdt(),
                t.getDiaChi(),
                t.getEmail(),
                t.getGioiTinh(),
                bn.getNgheNghiep()
            });
        }
    }

    private void showMedicine() {
        DefaultTableModel model = (DefaultTableModel) gridMedicine.getModel();
        model.setRowCount(0);
        BUSMedicine busMedi = new BUSMedicine();
        ArrayList<Medicine> listMedi = busMedi.getDataSource();
        for (Medicine m : listMedi) {
            model.addRow(new Object[]{
                m.getId(),
                m.getTenThuoc(),
                m.getMaThuoc(),
                m.getNhaSanXuat(),
                m.getPackType(),
                m.getUnitType(),
                m.getUnitPerPackage(),
                m.getDonGia(),
                m.getSoLuong(),
                m.getNsx(),
                m.getHsd()
            });
        }
    }

    private void showDuocSi() {
        DefaultTableModel model = (DefaultTableModel) gridDuocSi.getModel();
        model.setRowCount(0);
        BUSDuocSi ds = new BUSDuocSi();
        BUSThongTin busTT = new BUSThongTin();
        ThongTin t = new ThongTin();
        ArrayList<DuocSi> listDuocSi = ds.getDataSource();
        for (DuocSi ts : listDuocSi) {
            t = busTT.getThongTin(ts.getThongTinID());
            model.addRow(new Object[]{
                ts.getMaDuocSi(),
                t.getHoTen(),
                t.getNamSinh(),
                t.getSdt(),
                t.getDiaChi(),
                t.getEmail(),
                t.getGioiTinh(),
                ts.getLoginID()

            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jtpMain = new javax.swing.JTabbedPane();
        jpnHome = new javax.swing.JPanel();
        btLogout = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jLabel16 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jComboBox7 = new javax.swing.JComboBox<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        jList6 = new javax.swing.JList<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jList7 = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jpnBacSi = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        gridBacSi = new javax.swing.JTable();
        jScrollBar1 = new javax.swing.JScrollBar();
        jScrollBar2 = new javax.swing.JScrollBar();
        jLabel1 = new javax.swing.JLabel();
        tbMaBS = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tbHoTenBS = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tbNamSinhBS = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbGioiTinh = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tbSdtBS = new javax.swing.JTextField();
        tbDiaChiBS = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbKhoa = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnExportBS = new javax.swing.JButton();
        btnAddBS = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDeleteBS = new javax.swing.JButton();
        tbTrinhdoBS = new javax.swing.JTextField();
        tbEmailBS = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        tbUser = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        tbPassword = new javax.swing.JPasswordField();
        jpnDuocSi = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        gridDuocSi = new javax.swing.JTable();
        tbMaDS = new javax.swing.JTextField();
        tbHoTenDS = new javax.swing.JTextField();
        tbNamSinhDS = new javax.swing.JTextField();
        cbGioiTinhDS = new javax.swing.JComboBox<>();
        tbSdtDS = new javax.swing.JTextField();
        tbDiaChiDS = new javax.swing.JTextField();
        tbEmailDS = new javax.swing.JTextField();
        tbPasswordDS = new javax.swing.JPasswordField();
        tbUserDS = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        btnAddDS = new javax.swing.JButton();
        btnEditDS = new javax.swing.JButton();
        btnDeleteDS = new javax.swing.JButton();
        btnExportDS = new javax.swing.JButton();
        jPnBenhNhan = new javax.swing.JPanel();
        tbMaBN = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tbHoTenBN = new javax.swing.JTextField();
        tbNamSinhBN = new javax.swing.JTextField();
        cbGioiTinhBN = new javax.swing.JComboBox<>();
        tbPhoneNumberBN = new javax.swing.JTextField();
        tbAddrBN = new javax.swing.JTextField();
        btnDeleteBN = new javax.swing.JButton();
        btnEditBN = new javax.swing.JButton();
        btnAddBN = new javax.swing.JButton();
        btnExportBN = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        gridBenhNhan = new javax.swing.JTable();
        tbEmailBN = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        tbUserBN = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        tbNgheNghiepBN = new javax.swing.JTextField();
        tbPasswordBN = new javax.swing.JPasswordField();
        jpnMedicine = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        tbMaThuoc = new javax.swing.JTextField();
        tbTenThuoc = new javax.swing.JTextField();
        tbNhaSanXuat = new javax.swing.JTextField();
        tbPackType = new javax.swing.JTextField();
        tbUnitPertype = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        btnDeleteMedicine = new javax.swing.JButton();
        btnEditMedicine = new javax.swing.JButton();
        btnAddMedicine = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        gridMedicine = new javax.swing.JTable();
        jLabel47 = new javax.swing.JLabel();
        tbUnitType = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        btnImportMedicine = new javax.swing.JButton();
        btnExportMedicine = new javax.swing.JButton();
        tbHSD = new javax.swing.JTextField();
        tbNXS = new javax.swing.JTextField();
        tbSoLuong = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        tbDonGia = new javax.swing.JTextField();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btLogout.setText("Đăng xuất");
        btLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnHomeLayout = new javax.swing.GroupLayout(jpnHome);
        jpnHome.setLayout(jpnHomeLayout);
        jpnHomeLayout.setHorizontalGroup(
            jpnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnHomeLayout.createSequentialGroup()
                .addContainerGap(406, Short.MAX_VALUE)
                .addComponent(btLogout)
                .addGap(379, 379, 379))
        );
        jpnHomeLayout.setVerticalGroup(
            jpnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHomeLayout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(btLogout)
                .addContainerGap(415, Short.MAX_VALUE))
        );

        jtpMain.addTab("Home Login", jpnHome);

        jList3.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList3);

        jLabel16.setText("Mã số:");

        jLabel17.setText("Tên thuốc:");

        jLabel18.setText("Nhà SX:");

        jLabel19.setText("Hạn sử dụng:");

        jLabel20.setText("Giá:");

        jButton12.setText("Xóa");

        jButton13.setText("Sửa");

        jButton14.setText("Thêm");

        jButton15.setText("Tìm kiếm");

        jButton16.setText("Xuất danh sách thuốc");

        jButton19.setText("Xuất TK");

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thống kê theo ...", "Thống kê theo ...", "Thống kê theo ...", "Thống kê theo ..." }));

        jList6.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane6.setViewportView(jList6);

        jLabel21.setText("Tổng số:");

        jLabel22.setText("Tổng số:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(412, 412, 412)
                        .addComponent(jLabel22))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 67, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField12)
                            .addComponent(jTextField13)
                            .addComponent(jTextField14)
                            .addComponent(jTextField15)
                            .addComponent(jTextField16)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton16))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                        .addComponent(jButton14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton12)
                            .addComponent(jButton13)
                            .addComponent(jButton14)
                            .addComponent(jButton15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton19)
                            .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22))))
                .addContainerGap())
        );

        jtpMain.addTab("Quản lý kho thuốc", jPanel5);

        jList7.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane7.setViewportView(jList7);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 861, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(211, Short.MAX_VALUE))
        );

        jtpMain.addTab("Lịch sử khám bệnh", jPanel4);

        gridBacSi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Bác sĩ", "Họ và tên", "Năm sinh", "Giới tính", "Số điện thoại", "Địa chỉ", "Email", "Chuyên khoa", "Trình độ"
            }
        ));
        gridBacSi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gridBacSiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(gridBacSi);

        jLabel1.setText("Mã số:");

        jLabel2.setText("Họ tên:");

        jLabel3.setText("Năm sinh:");

        jLabel4.setText("Giới tính:");

        cbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        jLabel5.setText("SDT:");

        jLabel6.setText("Địa chỉ:");

        jLabel7.setText("Chuyên khoa:");

        cbKhoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Tai - Mũi - Họng", "Tim", "Phổi", "Đa khoa", " " }));

        jLabel8.setText("Trình độ:");

        jLabel9.setText("Email:");

        btnExportBS.setText("Xuất danh sách Bác si");
        btnExportBS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportBSActionPerformed(evt);
            }
        });

        btnAddBS.setText("Thêm");
        btnAddBS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBSActionPerformed(evt);
            }
        });

        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDeleteBS.setText("Xóa");
        btnDeleteBS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteBSActionPerformed(evt);
            }
        });

        jLabel24.setText("Password:");

        jLabel25.setText("User");

        tbPassword.setText("jPasswordField1");

        javax.swing.GroupLayout jpnBacSiLayout = new javax.swing.GroupLayout(jpnBacSi);
        jpnBacSi.setLayout(jpnBacSiLayout);
        jpnBacSiLayout.setHorizontalGroup(
            jpnBacSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBacSiLayout.createSequentialGroup()
                .addGroup(jpnBacSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnBacSiLayout.createSequentialGroup()
                        .addGroup(jpnBacSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpnBacSiLayout.createSequentialGroup()
                                .addGroup(jpnBacSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnBacSiLayout.createSequentialGroup()
                                        .addGroup(jpnBacSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2))
                                        .addGap(65, 65, 65)
                                        .addGroup(jpnBacSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tbHoTenBS)
                                            .addComponent(tbMaBS)))
                                    .addGroup(jpnBacSiLayout.createSequentialGroup()
                                        .addGroup(jpnBacSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jpnBacSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jpnBacSiLayout.createSequentialGroup()
                                                    .addGroup(jpnBacSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGap(42, 42, 42))
                                                .addGroup(jpnBacSiLayout.createSequentialGroup()
                                                    .addComponent(jLabel7)
                                                    .addGap(22, 22, 22)))
                                            .addGroup(jpnBacSiLayout.createSequentialGroup()
                                                .addGroup(jpnBacSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel8)
                                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(28, 28, 28)))
                                        .addGroup(jpnBacSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jpnBacSiLayout.createSequentialGroup()
                                                .addComponent(tbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tbPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(tbEmailBS, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(cbKhoa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(tbDiaChiBS)
                                            .addComponent(tbNamSinhBS)
                                            .addComponent(cbGioiTinh, 0, 547, Short.MAX_VALUE)
                                            .addComponent(tbSdtBS)
                                            .addComponent(tbTrinhdoBS))))
                                .addGap(18, 18, 18)
                                .addGroup(jpnBacSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpnBacSiLayout.createSequentialGroup()
                                        .addComponent(btnAddBS, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnDeleteBS))
                                    .addComponent(btnExportBS, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpnBacSiLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 851, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(291, 291, 291)
                        .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpnBacSiLayout.setVerticalGroup(
            jpnBacSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBacSiLayout.createSequentialGroup()
                .addGroup(jpnBacSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnBacSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tbMaBS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnBacSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbHoTenBS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jpnBacSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbNamSinhBS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnAddBS)
                    .addComponent(btnEdit)
                    .addComponent(btnDeleteBS))
                .addGroup(jpnBacSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnBacSiLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnBacSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnBacSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tbSdtBS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jpnBacSiLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnExportBS)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnBacSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbDiaChiBS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnBacSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnBacSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tbTrinhdoBS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnBacSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tbEmailBS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnBacSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnBacSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tbUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel25))
                    .addGroup(jpnBacSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tbPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel24)))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnBacSi, javax.swing.GroupLayout.PREFERRED_SIZE, 867, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnBacSi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jtpMain.addTab("Quản lý bác sĩ", jPanel2);

        gridDuocSi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Dược Sĩ", "Họ và Tên", "Năm sinh", "Giới tính", "SDT", "Địa chỉ", "Email"
            }
        ));
        gridDuocSi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gridDuocSiClicked(evt);
            }
        });
        jScrollPane12.setViewportView(gridDuocSi);

        cbGioiTinhDS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        tbPasswordDS.setText("jPasswordField1");

        jLabel27.setText("Password:");

        jLabel28.setText("User");

        jLabel29.setText("Email:");

        jLabel32.setText("Địa chỉ:");

        jLabel33.setText("SDT:");

        jLabel34.setText("Giới tính:");

        jLabel35.setText("Năm sinh:");

        jLabel36.setText("Họ tên:");

        jLabel37.setText("Mã số:");

        btnAddDS.setText("Thêm");
        btnAddDS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDSActionPerformed(evt);
            }
        });

        btnEditDS.setText("Sửa");
        btnEditDS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditDSActionPerformed(evt);
            }
        });

        btnDeleteDS.setText("Xóa");

        btnExportDS.setText("Xuất danh sách Dược sĩ");

        javax.swing.GroupLayout jpnDuocSiLayout = new javax.swing.GroupLayout(jpnDuocSi);
        jpnDuocSi.setLayout(jpnDuocSiLayout);
        jpnDuocSiLayout.setHorizontalGroup(
            jpnDuocSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDuocSiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnDuocSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12)
                    .addGroup(jpnDuocSiLayout.createSequentialGroup()
                        .addGroup(jpnDuocSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnDuocSiLayout.createSequentialGroup()
                                .addGroup(jpnDuocSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel37)
                                    .addComponent(jLabel36))
                                .addGap(65, 65, 65)
                                .addGroup(jpnDuocSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tbHoTenDS)
                                    .addComponent(tbMaDS)))
                            .addGroup(jpnDuocSiLayout.createSequentialGroup()
                                .addGroup(jpnDuocSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jpnDuocSiLayout.createSequentialGroup()
                                        .addGroup(jpnDuocSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel34)
                                            .addComponent(jLabel33)
                                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(28, 28, 28))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnDuocSiLayout.createSequentialGroup()
                                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jpnDuocSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tbEmailDS, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tbDiaChiDS, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tbNamSinhDS, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbGioiTinhDS, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tbSdtDS, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpnDuocSiLayout.createSequentialGroup()
                                        .addComponent(tbUserDS, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tbPasswordDS, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(12, 12, 12)
                        .addGroup(jpnDuocSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpnDuocSiLayout.createSequentialGroup()
                                .addComponent(btnAddDS)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditDS, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDeleteDS, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnExportDS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpnDuocSiLayout.setVerticalGroup(
            jpnDuocSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDuocSiLayout.createSequentialGroup()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnDuocSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(tbMaDS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnDuocSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbHoTenDS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnDuocSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbNamSinhDS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnDuocSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbGioiTinhDS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addComponent(btnAddDS)
                    .addComponent(btnEditDS)
                    .addComponent(btnDeleteDS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnDuocSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbSdtDS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33)
                    .addComponent(btnExportDS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnDuocSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbDiaChiDS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnDuocSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbEmailDS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnDuocSiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbUserDS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbPasswordDS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28))
                .addGap(0, 59, Short.MAX_VALUE))
        );

        jtpMain.addTab("Quản lý dược sĩ", jpnDuocSi);
        jpnDuocSi.getAccessibleContext().setAccessibleName("");

        jLabel10.setText("Mã số:");

        jLabel11.setText("Họ tên:");

        jLabel12.setText("Năm sinh:");

        jLabel13.setText("Giới tính:");

        jLabel14.setText("SDT:");

        jLabel15.setText("Địa chỉ:");

        cbGioiTinhBN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        btnDeleteBN.setText("Xóa");

        btnEditBN.setText("Sửa");
        btnEditBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditBNActionPerformed(evt);
            }
        });

        btnAddBN.setText("Thêm");
        btnAddBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBNActionPerformed(evt);
            }
        });

        btnExportBN.setText("Xuất danh sách bệnh nhân");

        gridBenhNhan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Bệnh Nhân", "Họ và Tên", "Năm sinh", "SDT", "Địa chỉ", "Email", "Giới tính", "Nghề nghiệp"
            }
        ));
        gridBenhNhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gridBenhNhanClicked(evt);
            }
        });
        jScrollPane11.setViewportView(gridBenhNhan);

        jLabel23.setText("Email:");

        jLabel26.setText("User:");

        jLabel45.setText("Password:");

        jLabel46.setText("Nghề nghiệp:");

        tbPasswordBN.setText("jPasswordField1");

        javax.swing.GroupLayout jPnBenhNhanLayout = new javax.swing.GroupLayout(jPnBenhNhan);
        jPnBenhNhan.setLayout(jPnBenhNhanLayout);
        jPnBenhNhanLayout.setHorizontalGroup(
            jPnBenhNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnBenhNhanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnBenhNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 861, Short.MAX_VALUE)
                    .addGroup(jPnBenhNhanLayout.createSequentialGroup()
                        .addGroup(jPnBenhNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel23)
                            .addComponent(jLabel46)
                            .addComponent(jLabel26)
                            .addComponent(jLabel45))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPnBenhNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPnBenhNhanLayout.createSequentialGroup()
                                .addGroup(jPnBenhNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tbNamSinhBN, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tbHoTenBN, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tbMaBN, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbGioiTinhBN, javax.swing.GroupLayout.Alignment.LEADING, 0, 542, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnBenhNhanLayout.createSequentialGroup()
                                .addGroup(jPnBenhNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPnBenhNhanLayout.createSequentialGroup()
                                        .addGroup(jPnBenhNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(tbPasswordBN, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tbUserBN)
                                            .addComponent(tbEmailBN, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tbNgheNghiepBN, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPnBenhNhanLayout.createSequentialGroup()
                                        .addGroup(jPnBenhNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(tbAddrBN, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tbPhoneNumberBN))
                                        .addGap(10, 10, 10)))
                                .addGroup(jPnBenhNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnExportBN, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPnBenhNhanLayout.createSequentialGroup()
                                        .addComponent(btnAddBN)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnEditBN, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnDeleteBN, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap())
        );
        jPnBenhNhanLayout.setVerticalGroup(
            jPnBenhNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnBenhNhanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPnBenhNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbMaBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPnBenhNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbHoTenBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPnBenhNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbNamSinhBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGroup(jPnBenhNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnBenhNhanLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPnBenhNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddBN)
                            .addComponent(btnEditBN)
                            .addComponent(btnDeleteBN))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExportBN))
                    .addGroup(jPnBenhNhanLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPnBenhNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbGioiTinhBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPnBenhNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tbPhoneNumberBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPnBenhNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tbAddrBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPnBenhNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(tbEmailBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPnBenhNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbNgheNghiepBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPnBenhNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbUserBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPnBenhNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(tbPasswordBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtpMain.addTab("Quản lý bệnh nhân", jPnBenhNhan);

        jLabel38.setText("Mã thuốc:");

        jLabel39.setText("Tên thuốc:");

        jLabel40.setText("Nhà sản xuất:");

        jLabel43.setText("Kiểu đóng gói");

        btnDeleteMedicine.setText("Xóa");

        btnEditMedicine.setText("Sửa");

        btnAddMedicine.setText("Thêm");
        btnAddMedicine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMedicineActionPerformed(evt);
            }
        });

        gridMedicine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên thuốc", "Mã thuốc", "Nhà sản xuất", "Quy cách đống gói", "Đơn vị", "đv/gói", "Đơn giá", "Số lượng", "NXS", "HSD"
            }
        ));
        gridMedicine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gridMedicineMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(gridMedicine);

        jLabel47.setText("Kiểu đơn vị");

        jLabel48.setText("Quy cách");

        btnImportMedicine.setText("Import");
        btnImportMedicine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportMedicineActionPerformed(evt);
            }
        });

        btnExportMedicine.setText("Xuất danh mục thuốc");
        btnExportMedicine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportMedicineActionPerformed(evt);
            }
        });

        jLabel44.setText("Số lượng");

        jLabel49.setText("NSX");

        jLabel50.setText("HSD");

        jLabel51.setText("yyyy-mm-dd");

        jLabel52.setText("yyyy-mm-dd");

        jLabel53.setText("Đơn giá");

        javax.swing.GroupLayout jpnMedicineLayout = new javax.swing.GroupLayout(jpnMedicine);
        jpnMedicine.setLayout(jpnMedicineLayout);
        jpnMedicineLayout.setHorizontalGroup(
            jpnMedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMedicineLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnMedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 851, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnMedicineLayout.createSequentialGroup()
                        .addGroup(jpnMedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnMedicineLayout.createSequentialGroup()
                                .addGroup(jpnMedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnMedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tbTenThuoc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                                    .addComponent(tbMaThuoc, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tbNhaSanXuat)))
                            .addGroup(jpnMedicineLayout.createSequentialGroup()
                                .addGroup(jpnMedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnMedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tbPackType, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                                    .addComponent(tbUnitPertype)))
                            .addGroup(jpnMedicineLayout.createSequentialGroup()
                                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tbUnitType, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(132, 132, 132)
                        .addGroup(jpnMedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpnMedicineLayout.createSequentialGroup()
                                .addComponent(btnAddMedicine)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditMedicine)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDeleteMedicine))
                            .addComponent(btnImportMedicine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExportMedicine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jpnMedicineLayout.createSequentialGroup()
                        .addGroup(jpnMedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel50, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnMedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tbSoLuong)
                            .addComponent(tbHSD, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnMedicineLayout.createSequentialGroup()
                        .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tbNXS, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnMedicineLayout.createSequentialGroup()
                        .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tbDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jpnMedicineLayout.setVerticalGroup(
            jpnMedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnMedicineLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpnMedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(tbMaThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnMedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(tbTenThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImportMedicine))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnMedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(tbNhaSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditMedicine)
                    .addComponent(btnDeleteMedicine)
                    .addComponent(btnAddMedicine))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnMedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbPackType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43)
                    .addComponent(btnExportMedicine))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnMedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbUnitType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnMedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbUnitPertype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnMedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnMedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbNXS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49)
                    .addComponent(jLabel51))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnMedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbHSD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50)
                    .addComponent(jLabel52))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnMedicineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jtpMain.addTab("Quản lý kho thuốc", jpnMedicine);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtpMain, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtpMain, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jtpMain.getAccessibleContext().setAccessibleName("tpnMain");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private Boolean checkNullBS() {
        Boolean chk = true;
        if (tbHoTenBS.getText().trim().isEmpty() && tbNamSinhBS.getText().trim().isEmpty() && tbEmailBS.getText().trim().isEmpty() && tbSdtBS.getText().trim().isEmpty()) {
            chk = false;
        }
        return chk;
    }
    private String getBSCellValue(int x, int y) 
    {
        DefaultTableModel dm = (DefaultTableModel) gridBacSi.getModel();
        return dm.getValueAt(x, y).toString();
    }
    private void writeBSToExcel() throws IOException
    {
        DefaultTableModel dm = (DefaultTableModel) gridBacSi.getModel();
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet ws=wb.createSheet();
        TreeMap<String,Object[]> data=new TreeMap<>();
        data.put("-1", new Object[]{dm.getColumnName(0),dm.getColumnName(1),dm.getColumnName(2),dm.getColumnName(3),dm.getColumnName(4),dm.getColumnName(5),dm.getColumnName(6),dm.getColumnName(7),dm.getColumnName(8)});
        for(int i=0;i<dm.getRowCount();i++)
        {
            data.put(Integer.toString(i), new Object[]{
                getBSCellValue(i,0),
                getBSCellValue(i,1),
                getBSCellValue(i,2),
                getBSCellValue(i,3),
                getBSCellValue(i,4),
                getBSCellValue(i,5),
                getBSCellValue(i,6),
                getBSCellValue(i,7),
                getBSCellValue(i,8)});
        }
        Set<String> ids=data.keySet();
        XSSFRow row;
        int rowID=0;
        for(String key :ids)
        {
            row=ws.createRow(rowID++);
            Object[] values=data.get(key);
            int cellID=0;
            for(Object o:values)
            {
                org.apache.poi.ss.usermodel.Cell cell =row.createCell(cellID++);
                cell.setCellValue(o.toString());
            }
            try
            {
                FileOutputStream fos=new FileOutputStream(new File("D:/BangBS.xlsx"));
                wb.write(fos);
                fos.close();
                JOptionPane.showMessageDialog(null, "Xuât thành công. Sử dụng file tại D:/BangBS.xlsx", "Information", 2);
            }
            catch(IOException e){
            JOptionPane.showMessageDialog(null, e);
            }
        
        }
        
    }
    private void btnAddBSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBSActionPerformed
        if (checkNullBS()) {
            System.out.println(checkNullBS());
            BUSBacSi busBacSi = new BUSBacSi();
            BacSi bs = new BacSi();
            BUSThongTin busTT = new BUSThongTin();
            Login l = new Login();
            BUSLogin busLogin = new BUSLogin();
            ThongTin t = new ThongTin();
            //get Data
            t.setDiaChi(tbAddrBN.getText());
            t.setEmail(tbEmailBS.getText());
            t.setGioiTinh(cbGioiTinhBN.getSelectedItem().toString());
            t.setHoTen(tbHoTenBS.getText());
            t.setNamSinh(Integer.parseInt(tbNamSinhBS.getText()));
            t.setSdt(tbSdtBS.getText());
            t.setDiaChi(tbDiaChiBS.getText());
            busTT.add(t);
            bs.setThongTinID(busTT.getMaxID());
            l.setLevel(2);
            l.setUser(tbUser.getText());
            l.setPasswd(tbPassword.getText());
            busLogin.add(l);
            bs.setLogin_ID(busLogin.getMaxID());
            bs.setTrinhDo(tbTrinhdoBS.getText());
            bs.setMakhoa(cbKhoa.getSelectedIndex());
            busBacSi.add(bs); //add to database
            tbMaBS.setText("");
            tbHoTenBS.setText("");
            tbNamSinhBS.setText("");
            tbDiaChiBS.setText("");
            tbEmailBS.setText("");
            tbSdtBS.setText("");
            tbTrinhdoBS.setText("");
            cbKhoa.setSelectedIndex(0);
            tbUser.setText("");
            tbPassword.setText("");
            showBacSi();
        } else {
            JOptionPane.showMessageDialog(null, "Cần điền đủ thông tin vào các trường", "Warning", 1);
        }
    }//GEN-LAST:event_btnAddBSActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        BUSBacSi busBacSi = new BUSBacSi();
        BacSi bs = new BacSi();
        ThongTin t = new ThongTin();
        BUSThongTin busTT = new BUSThongTin();
        Login l = new Login();
        BUSLogin busLogin = new BUSLogin();
        //get Data
        bs.setMaBS(Integer.parseInt(tbMaBS.getText()));
        t.setHoTen(tbHoTenBS.getText());
        t.setNamSinh(Integer.parseInt(tbNamSinhBS.getText()));
        t.setGioiTinh((String) cbGioiTinh.getSelectedItem());
        t.setDiaChi(tbDiaChiBS.getText());
        t.setEmail(tbEmailBS.getText());
        t.setSdt(tbSdtBS.getText());
        t.setId(bacSi.getThongTinID());
        busTT.edit(t);
        bs.setTrinhDo(tbTrinhdoBS.getText());
        bs.setMakhoa(cbKhoa.getSelectedIndex());
        busBacSi.edit(bs);
        tbMaBS.setText("");
        tbHoTenBS.setText("");
        tbNamSinhBS.setText("");
        tbDiaChiBS.setText("");
        tbEmailBS.setText("");
        tbSdtBS.setText("");
        tbTrinhdoBS.setText("");
        cbKhoa.setSelectedIndex(0);
        tbUser.setText("");
        tbPassword.setText("");
        showBacSi();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteBSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBSActionPerformed
        BUSBacSi busBS = new BUSBacSi();
        BUSThongTin busTT = new BUSThongTin();
        BUSLogin busLogin = new BUSLogin();
        busBS.delete(bacSi.getMaBS());
        busTT.delete(bacSi.getThongTinID());
        busLogin.delete(bacSi.getLogin_ID());
        showBacSi();
        tbMaBS.setText("");
        tbHoTenBS.setText("");
        tbNamSinhBS.setText("");
        tbSdtBS.setText("");
        tbDiaChiBS.setText("");
        tbTrinhdoBS.setText("");
        tbEmailBS.setText("");
    }//GEN-LAST:event_btnDeleteBSActionPerformed

    private void btnAddBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBNActionPerformed
        BUSBenhNhan busBN = new BUSBenhNhan();
        BenhNhan bn = new BenhNhan();
        ThongTin t = new ThongTin();
        BUSThongTin busTT = new BUSThongTin();
        Login l = new Login();
        BUSLogin busLogin = new BUSLogin();
        //get Data
        //bn.setMaBenhNhan(Integer.parseInt(tbMaBN.getText()));
        //System.out.println(bn.getMaBenhNhan());
        t.setHoTen(tbHoTenBN.getText());
        //System.out.println(bn.getHoTen());
        t.setNamSinh(Integer.parseInt(tbNamSinhBN.getText()));
        //System.out.println(bn.getAge());
        t.setSdt(tbPhoneNumberBN.getText());
        //System.out.println(bn.getPhoneNumber());
        t.setDiaChi(tbAddrBN.getText());
        t.setEmail(tbEmailBN.getText());
        t.setSdt(tbPhoneNumberBN.getText());
        busTT.add(t);
        bn.setThongTinID(busTT.getMaxID());
        l.setUser(tbUserBN.getText());
        l.setPasswd(tbPasswordBN.getText());
        l.setLevel(4);
        busLogin.add(l);
        bn.setLoginID(busLogin.getMaxID());
        bn.setNgheNghiep(tbNgheNghiepBN.getText());
        busBN.add(bn);
        tbMaBN.setText("");
        tbHoTenBN.setText("");
        tbAddrBN.setText("");
        tbEmailBN.setText("");
        tbNamSinhBN.setText("");
        tbPhoneNumberBN.setText("");
        tbNgheNghiepBN.setText("");
        tbUserBN.setText("");
        tbPasswordBN.setText("");
        showBenhNhan();
    }//GEN-LAST:event_btnAddBNActionPerformed

    private void btnEditBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditBNActionPerformed
        BUSBenhNhan busBN = new BUSBenhNhan();
        BenhNhan bn = new BenhNhan();
        ThongTin t = new ThongTin();
        BUSThongTin busTT = new BUSThongTin();
        Login l = new Login();
        BUSLogin busLogin = new BUSLogin();
        //get Data
        //bn.setMaBenhNhan(Integer.parseInt(tbMaBN.getText()));
        //System.out.println(bn.getMaBenhNhan());
        bn.setMaBenhNhan(Integer.parseInt(tbMaBN.getText()));
        t.setHoTen(tbHoTenBN.getText());
        //System.out.println(bn.getHoTen());
        t.setNamSinh(Integer.parseInt(tbNamSinhBN.getText()));
        //System.out.println(bn.getAge());
        t.setSdt(tbPhoneNumberBN.getText());
        //System.out.println(bn.getPhoneNumber());
        t.setDiaChi(tbAddrBN.getText());
        t.setEmail(tbEmailBN.getText());
        t.setSdt(tbPhoneNumberBN.getText());
        t.setGioiTinh(cbGioiTinhBN.getSelectedItem().toString());
        busTT.add(t);
        bn.setThongTinID(busTT.getMaxID());
        l.setUser(tbUserBN.getText());
        l.setPasswd(tbPasswordBN.getText());
        l.setLevel(4);
        busLogin.add(l);
        bn.setLoginID(busLogin.getMaxID());
        bn.setNgheNghiep(tbNgheNghiepBN.getText());
        busBN.edit(bn);
        tbMaBN.setText("");
        tbHoTenBN.setText("");
        tbAddrBN.setText("");
        tbEmailBN.setText("");
        tbNamSinhBN.setText("");
        tbPhoneNumberBN.setText("");
        tbNgheNghiepBN.setText("");
        tbUserBN.setText("");
        tbPasswordBN.setText("");
        showBenhNhan();
    }//GEN-LAST:event_btnEditBNActionPerformed

    private void gridBenhNhanClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gridBenhNhanClicked
        int rowId = this.gridBenhNhan.getSelectedRow();
        int maBN = Integer.parseInt(this.gridBenhNhan.getModel().getValueAt(rowId, 0).toString());
        BUSBenhNhan busBN = new BUSBenhNhan();
        BenhNhan bn = busBN.getBenhNhan(maBN);
        BUSThongTin busT = new BUSThongTin();
        ThongTin t = busT.getThongTin(bn.getThongTinID());
        BUSLogin busLogin = new BUSLogin();
        Login l = busLogin.getAccount(bn.getLoginID());
        cbGioiTinhBN.setSelectedItem(t.getGioiTinh());
        tbMaBN.setText(Integer.toString(bn.getMaBenhNhan()));
        tbHoTenBN.setText(t.getHoTen());
        tbNamSinhBN.setText(Integer.toString(t.getNamSinh()));
        tbPhoneNumberBN.setText(t.getSdt());
        tbAddrBN.setText(t.getDiaChi());
        tbNgheNghiepBN.setText(bn.getNgheNghiep());
        tbUser.setText(l.getUser());
        tbPassword.setText(l.getPasswd());
    }//GEN-LAST:event_gridBenhNhanClicked

    private void gridBacSiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gridBacSiMouseClicked
        int rowId = this.gridBacSi.getSelectedRow();
        int maBS = Integer.parseInt(this.gridBacSi.getModel().getValueAt(rowId, 0).toString());
        System.out.println(maBS);
        BUSBacSi busBS = new BUSBacSi();
        bacSi = busBS.getBacSi(maBS);
        //System.out.println(bs.getMaBS());
        BUSThongTin busTT = new BUSThongTin();
        ThongTin t = busTT.getThongTin(bacSi.getThongTinID());
        BUSLogin busLogin = new BUSLogin();
        Login l = busLogin.getAccount(bacSi.getLogin_ID());
        tbMaBS.setText(Integer.toString(bacSi.getMaBS()));
        tbHoTenBS.setText(t.getHoTen());
        tbNamSinhBS.setText(Integer.toString(t.getNamSinh()));
        tbSdtBS.setText(t.getSdt());
        tbDiaChiBS.setText(t.getDiaChi());
        tbUser.setText(l.getUser());
        tbPassword.setText(l.getPasswd());
        cbGioiTinh.setSelectedItem(t.getGioiTinh());
        tbEmailBS.setText(t.getEmail());
        cbKhoa.setSelectedIndex(bacSi.getMakhoa());
        tbTrinhdoBS.setText(bacSi.getTrinhDo());
    }//GEN-LAST:event_gridBacSiMouseClicked

    private void btLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLogoutActionPerformed
        this.hide();
        LoginForm lf = new LoginForm();
        lf.show();
// TODO add your handling code here:
    }//GEN-LAST:event_btLogoutActionPerformed

    private void gridMedicineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gridMedicineMouseClicked
        int rowId = this.gridBacSi.getSelectedRow();
        int maBS = Integer.parseInt(this.gridBacSi.getModel().getValueAt(rowId, 0).toString());
        BUSMedicine busM = new BUSMedicine();
        Medicine m = busM.getMedicine(rowId);
        tbMaThuoc.setText(m.getMaThuoc());
        tbTenThuoc.setText(m.getTenThuoc());
        tbPackType.setText(m.getPackType());
        tbUnitType.setText(m.getUnitType());
        tbUnitPertype.setText(Integer.toString(m.getUnitPerPackage()));
    }//GEN-LAST:event_gridMedicineMouseClicked

    private void btnAddMedicineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMedicineActionPerformed

    }//GEN-LAST:event_btnAddMedicineActionPerformed

    private void gridDuocSiClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gridDuocSiClicked

    }//GEN-LAST:event_gridDuocSiClicked

    private void btnImportMedicineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportMedicineActionPerformed
        File f = new File("D:\\F\\Java\\QuanLyPhongKham\\template\\QuanLyNhapThuoc.xls");
        ArrayList<Medicine> listMedi = new ArrayList<>();
        String arr[] = new String[10];
        BUSMedicine busMedi = new BUSMedicine();
        try {
            Workbook wb = Workbook.getWorkbook(f);
            Sheet s = wb.getSheet(0);
            for (int i = 1; i < s.getRows(); i++) {
                for (int j = 1; j < s.getColumns(); j++) {
                    Cell c = s.getCell(j, i);
                    arr[j] = c.getContents();
                }
                System.out.println();
                Medicine m = new Medicine();
                m.setTenThuoc(arr[1]);
                m.setMaThuoc(arr[2]);
                m.setNhaSanXuat(arr[3]);
                m.setUnitType(arr[4]);
                m.setPackType(arr[5]);
                m.setUnitPerPackage(Integer.parseInt(arr[6]));
                m.setSoLuong(Integer.parseInt(arr[7]));
                m.setNsx(Date.valueOf(arr[8]));
                m.setHsd(Date.valueOf(arr[9]));
                m.setDonGia(Integer.parseInt(arr[10]));
                listMedi.add(m);
            }
            for (Medicine m : listMedi) {
                busMedi.add(m);
            }
            showMedicine();
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnImportMedicineActionPerformed

    private void btnAddDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDSActionPerformed
        BUSDuocSi busDuocSi = new BUSDuocSi();
        DuocSi ds = new DuocSi();
        BUSThongTin busTT = new BUSThongTin();
        // Login l = new Login();
        BUSLogin busLogin = new BUSLogin();
        ThongTin t = new ThongTin();
        //get Data
        t.setDiaChi(tbDiaChiDS.getText());
        t.setEmail(tbEmailDS.getText());
        t.setGioiTinh(cbGioiTinhDS.getSelectedItem().toString());
        t.setHoTen(tbHoTenDS.getText());
        t.setNamSinh(Integer.parseInt(tbNamSinhDS.getText()));
        t.setSdt(tbSdtDS.getText());
        busTT.add(t);
        ds.setThongTinID(busTT.getMaxID());
        ds.setMaDuocSi(Integer.parseInt(tbMaDS.getText()));
        ds.setLoginID(busLogin.getMaxID());
        busDuocSi.add(ds);
        showDuocSi();
    }//GEN-LAST:event_btnAddDSActionPerformed

    private void btnEditDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditDSActionPerformed
               BUSDuocSi busDuocSi = new BUSDuocSi();
        DuocSi Ds = new DuocSi();
        ThongTin t = new ThongTin();
        BUSThongTin busTT = new BUSThongTin();
        Login l = new Login();
        BUSLogin busLogin = new BUSLogin();
        duocSi.setMaDuocSi(Integer.parseInt(tbMaDS.getText()));
        t.setId(duocSi.getThongTinID());
        t.setHoTen(tbHoTenDS.getText());
        t.setSdt(tbSdtDS.getText());
        t.setNamSinh(Integer.parseInt(tbNamSinhDS.getText()));
        t.setGioiTinh((String) cbGioiTinhDS.getSelectedItem());
        t.setDiaChi(tbDiaChiDS.getText());
        t.setEmail(tbEmailDS.getText());
        t.setId(duocSi.getThongTinID());
        busDuocSi.edit(duocSi);     
        busTT.edit(t);
        showDuocSi();
    }//GEN-LAST:event_btnEditDSActionPerformed

    private void btnExportBSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportBSActionPerformed
        try {
            writeBSToExcel();
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExportBSActionPerformed

    private void btnExportMedicineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportMedicineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExportMedicineActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLogout;
    private javax.swing.JButton btnAddBN;
    private javax.swing.JButton btnAddBS;
    private javax.swing.JButton btnAddDS;
    private javax.swing.JButton btnAddMedicine;
    private javax.swing.JButton btnDeleteBN;
    private javax.swing.JButton btnDeleteBS;
    private javax.swing.JButton btnDeleteDS;
    private javax.swing.JButton btnDeleteMedicine;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnEditBN;
    private javax.swing.JButton btnEditDS;
    private javax.swing.JButton btnEditMedicine;
    private javax.swing.JButton btnExportBN;
    private javax.swing.JButton btnExportBS;
    private javax.swing.JButton btnExportDS;
    private javax.swing.JButton btnExportMedicine;
    private javax.swing.JButton btnImportMedicine;
    private javax.swing.JComboBox<String> cbGioiTinh;
    private javax.swing.JComboBox<String> cbGioiTinhBN;
    private javax.swing.JComboBox<String> cbGioiTinhDS;
    private javax.swing.JComboBox<String> cbKhoa;
    private javax.swing.JTable gridBacSi;
    private javax.swing.JTable gridBenhNhan;
    private javax.swing.JTable gridDuocSi;
    private javax.swing.JTable gridMedicine;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton19;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList3;
    private javax.swing.JList<String> jList6;
    private javax.swing.JList<String> jList7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPnBenhNhan;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollBar jScrollBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JPanel jpnBacSi;
    private javax.swing.JPanel jpnDuocSi;
    private javax.swing.JPanel jpnHome;
    private javax.swing.JPanel jpnMedicine;
    private javax.swing.JTabbedPane jtpMain;
    private javax.swing.JTextField tbAddrBN;
    private javax.swing.JTextField tbDiaChiBS;
    private javax.swing.JTextField tbDiaChiDS;
    private javax.swing.JTextField tbDonGia;
    private javax.swing.JTextField tbEmailBN;
    private javax.swing.JTextField tbEmailBS;
    private javax.swing.JTextField tbEmailDS;
    private javax.swing.JTextField tbHSD;
    private javax.swing.JTextField tbHoTenBN;
    private javax.swing.JTextField tbHoTenBS;
    private javax.swing.JTextField tbHoTenDS;
    private javax.swing.JTextField tbMaBN;
    private javax.swing.JTextField tbMaBS;
    private javax.swing.JTextField tbMaDS;
    private javax.swing.JTextField tbMaThuoc;
    private javax.swing.JTextField tbNXS;
    private javax.swing.JTextField tbNamSinhBN;
    private javax.swing.JTextField tbNamSinhBS;
    private javax.swing.JTextField tbNamSinhDS;
    private javax.swing.JTextField tbNgheNghiepBN;
    private javax.swing.JTextField tbNhaSanXuat;
    private javax.swing.JTextField tbPackType;
    private javax.swing.JPasswordField tbPassword;
    private javax.swing.JPasswordField tbPasswordBN;
    private javax.swing.JPasswordField tbPasswordDS;
    private javax.swing.JTextField tbPhoneNumberBN;
    private javax.swing.JTextField tbSdtBS;
    private javax.swing.JTextField tbSdtDS;
    private javax.swing.JTextField tbSoLuong;
    private javax.swing.JTextField tbTenThuoc;
    private javax.swing.JTextField tbTrinhdoBS;
    private javax.swing.JTextField tbUnitPertype;
    private javax.swing.JTextField tbUnitType;
    private javax.swing.JTextField tbUser;
    private javax.swing.JTextField tbUserBN;
    private javax.swing.JTextField tbUserDS;
    // End of variables declaration//GEN-END:variables
}
