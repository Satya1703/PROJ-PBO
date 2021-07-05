/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.controller_nota;
import koneksi.Koneksi;
import view.Form_Nota;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author Asus
 */
public class MainModel implements controller_nota {

    @Override
    public void Simpan(Form_Nota not) throws SQLException {
        try {
     
            Connection con = Koneksi.getKoneksi();
            Statement stt = con.createStatement();
            String sql = "insert into menu values(NULL, '"+ not.fnamapemesan.getText() + "','" + not.fnomeja.getText() + "','"+ not.fnamamakan.getText() +"','"+ not.fjumlahmakan.getText() +"','"+ not.fnamaminum.getText() + "','"+ not.fjumlahminum.getText() +"')";
            stt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan!", "Hasil",JOptionPane.INFORMATION_MESSAGE);            
            stt.close();
       } catch (Exception e){
           JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!", "Hasil", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        }

    @Override
    public void Ubah(Form_Nota not) throws SQLException {
        try {
            Connection con = Koneksi.getKoneksi();
            Statement stt = con.createStatement();
            String sql = "update menu set "
                        + "nama_pemesan       = '" + not.fnamapemesan.getText()    +"', "
                        + "meja     = '" + not.fnomeja.getText()  +"', "
                        + "nama_makanan    = '" + not.fnamamakan.getText() +"', "
                        + "jumlah_makanan   = '" + not.fjumlahmakan.getText()+"', "
                        + "nama_minuman    = '" + not.fnamaminum.getText() +"', "
                        + "jumlah_minuman    = '" + not.fjumlahminum.getText() +"' "
                        + "where id = '" + not.id.getText()    + "'";
            stt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
            stt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah!", "Hasil", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    @Override
    public void Hapus(Form_Nota not) throws SQLException {
         try {
           
            
            Connection con = Koneksi.getKoneksi();
            Statement stt = con.createStatement();
            String sql = "delete from menu where id= '" + not.id.getText()    + "'";
            stt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil di Dihapus");
            stt.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "gagal", "Hasil", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    

    @Override
    public void Tampil(Form_Nota not) throws SQLException {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Connection con = Koneksi.getKoneksi();
            Statement stt = con.createStatement();
            String sql = "select * from menu";
            ResultSet res = stt.executeQuery(sql);
            while(res.next())
            {
                Object[] ob= new Object[8];
                ob[0] = res.getString(1);
                ob[1] = res.getString(2);
                ob[2] = res.getString(3);
                ob[3] = res.getString(4);
                ob[4] = res.getString(5);
                ob[5] = res.getString(6);
                ob[6] = res.getString(7);
                not.tblmodel.addRow(ob);
            } 
            stt.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "gagal", "Hasil", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    @Override
    public void Baru(Form_Nota not) {
       not.id.setText("");
       not.fnamapemesan.setText("");
       not.fnomeja.setText("");
       not.fnamamakan.setText("");
       not.fjumlahmakan.setText("");
       not.fnamaminum.setText("");
       not.fjumlahminum.setText("");
    }

    @Override
    public void KlikTabel(Form_Nota not) throws SQLException {
        try{
            int pilih = not.tabel1.getSelectedRow();
            not.id.setText(not.tblmodel.getValueAt(pilih, 0).toString());
            not.fnamapemesan.setText(not.tblmodel.getValueAt(pilih, 1).toString());
            not.fnomeja.setText(not.tblmodel.getValueAt(pilih, 2).toString());
            not.fnamamakan.setText(not.tblmodel.getValueAt(pilih, 3).toString());
            not.fjumlahmakan.setText(not.tblmodel.getValueAt(pilih, 4).toString());
            not.fnamaminum.setText(not.tblmodel.getValueAt(pilih, 5).toString());
            not.fjumlahminum.setText(not.tblmodel.getValueAt(pilih, 6).toString());
        }
        catch(Exception e){
            
        }
    }
    
}
