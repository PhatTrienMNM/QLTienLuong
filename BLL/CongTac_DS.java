/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

/**
 *
 * @author Administrator
 */
import java.sql.*;
import javax.swing.*;
import DAL.*;
/**
 *
 * @author Administrator
 */
public class CongTac_DS {
    static ConnectionDB kn = new ConnectionDB();
    public static PreparedStatement pst = null;
    public static ResultSet rs = null;
    public static Connection conn = kn.getConnect();
    
    public static void themCongTac(String maCT, String maNV, String tgbd, String tgkt,String maCV, String ct)
    {
        String sql="INSERT INTO dbo.QUATRINHCONGTAC (MAQTCT, MANV, TGBATDAU, TGKETTHUC, MACV, TENCONGTY) values (?, ?, ?, ?, ?, ?)";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1, maCT);
            pst.setString(2, maNV);
            pst.setString(3, tgbd);
            pst.setString(4, tgkt);
            pst.setString(5, maCV);
            pst.setString(6, ct);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Đã thêm thàng công", "Thông báo",1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thể thêm được, xin kiểm tra lại", "Thông báo",1);
        }
    }
    public static void suaCongTac(String maCT, String maNV, String tgbd, String tgkt,String maCV, String ct)
    {
        String sql = "UPDATE dbo.QUATRINHCONGTAC SET MANV='"+maNV+"', TGBATDAU='"+tgbd+"', TGKETTHUC='"+tgkt+"', MACV = '"+maCV+"', TENCONGTY='"+ct+"' where MAQTCT='"+maCT+"'";
        try {
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Đã sữa thành thàng công", "Thông báo",1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thể sữa được, xin kiểm tra lại", "Thông báo",1);
        }
    }
    public static void xoaCongTac(String maCT)
    {
        String sql ="DELETE FROM dbo.QUATRINHCONGTAC WHERE MAQTCT = '"+ maCT +"'";
        try {
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Đã xóa thành công", "Thông báo",1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thể xóa xin kiểm tra lại!", "Thông báo",1);
        }
    }
}
