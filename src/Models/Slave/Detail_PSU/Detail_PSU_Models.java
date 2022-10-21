/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Slave.Detail_PSU;

/**
 *
 * @author mariq
 */
public class Detail_PSU_Models {
    private String Nomor_Transaksi, IDID_PSU, Nama_PSU;
    private int Quantity,Harga,Total;

    public String getNama_PSU() {
        return Nama_PSU;
    }

    public void setNama_PSU(String Nama_PSU) {
        this.Nama_PSU = Nama_PSU;
    }

    public int getHarga() {
        return Harga;
    }

    public void setHarga(int Harga) {
        this.Harga = Harga;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int Total) {
        this.Total = Total;
    }

    public String getNomor_Transaksi() {
        return Nomor_Transaksi;
    }

    public void setNomor_Transaksi(String Nomor_Transaksi) {
        this.Nomor_Transaksi = Nomor_Transaksi;
    }

    public String getIDID_PSU() {
        return IDID_PSU;
    }

    public void setIDID_PSU(String IDID_PSU) {
        this.IDID_PSU = IDID_PSU;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }
    
    
}
