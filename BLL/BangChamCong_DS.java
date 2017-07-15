/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.sql.*;
import javax.swing.*;
import DAL.*;
public class BangChamCong_DS {
    static ConnectionDB kn = new ConnectionDB();
    public static PreparedStatement pst = null;
    public static ResultSet rs = null;
    public static Connection conn = kn.getConnect();
    public static void themBCC(String maBCC, String maNV, String thang, String songaylam, String songaynghiphep, String songaynghikhongphep)
    {
        String sql="INSERT INTO dbo.BANGCHAMCONG(MABCC, MANV,THANG,SONGAYLAM,SONGAYNGHIPHEP,SONGAYNGHIKHONGPHEP) values (?, ?, ?, ?, ?, ?)";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1, maBCC);
            pst.setString(2, maNV);
            pst.setString(3, thang);
            pst.setString(4, songaylam);
            pst.setString(5, songaynghiphep);
            pst.setString(6, songaynghikhongphep);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Đã thêm thàng công", "Thông báo",1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thể thêm được, xin kiểm tra lại", "Thông báo",1);
        }
    }
    public static void suaBCC(String maBCC, String maNV, String thang, String songaylam, String songaynghiphep, String songaynghikhongphep)
    {
        String sql = "UPDATE dbo.BANGCHAMCONG SET THANG='"+thang+"', MANV ='"+maNV+"', SONGAYLAM ='"+songaylam+"',SONGAYNGHIPHEP = '"+songaynghiphep+"', SONGAYNGHIKHONGPHEP = '"+songaynghikhongphep+"' where MABCC='"+maBCC+"'";
        try {
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Đã sữa thành thàng công", "Thông báo",1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thể sữa được, xin kiểm tra lại", "Thông báo",1);
        }
    }
    public static void xoaBCC(String maBCC)
    {
        String sql ="DELETE FROM dbo.BANGCHAMCONG WHERE MABCC = '"+ maBCC +"'";
        try {
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Đã xóa thành công", "Thông báo",1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thể xóa xin kiểm tra lại!", "Thông báo",1);
        }
    }
}
