/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Master.Transaksi;


import java.sql.Date;
import java.sql.Time;
/**
 *
 * @author mariq
 */
public class TransaksiModels {
    private int ID_User;
    private String Nomor_Transaksi;
    private Date Tanggal_Transaksi;
    private Time Waktu_Transaksi;

    public int getID_User() {
        return ID_User;
    }

    public void setID_User(int ID_User) {
        this.ID_User = ID_User;
    }

      

    public String getNomor_Transaksi() {
        return Nomor_Transaksi;
    }

    public void setNomor_Transaksi(String Nomor_Transaksi) {
        this.Nomor_Transaksi = Nomor_Transaksi;
    }

    public Date getTanggal_Transaksi() {
        return Tanggal_Transaksi;
    }

    public void setTanggal_Transaksi(Date Tanggal_Transaksi) {
        this.Tanggal_Transaksi = Tanggal_Transaksi;
    }

    public Time getWaktu_Transaksi() {
        return Waktu_Transaksi;
    }

    public void setWaktu_Transaksi(Time Waktu_Transaksi) {
        this.Waktu_Transaksi = Waktu_Transaksi;
    }
           
    
}
