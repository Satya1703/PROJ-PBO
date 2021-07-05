/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import view.Form_Nota;   
import java.sql.SQLException;
/**
 *
 * @author Asus
 */
public interface controller_nota {
    public void Simpan(Form_Nota not) throws SQLException;        
    public void Ubah(Form_Nota not) throws SQLException;
    public void Hapus(Form_Nota not) throws SQLException;
    public void Tampil(Form_Nota not) throws SQLException;
    public void Baru(Form_Nota not);                               
    public void KlikTabel(Form_Nota not) throws SQLException;
}
