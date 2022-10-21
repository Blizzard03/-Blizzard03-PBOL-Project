/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Slave.Detail_GPU;

/**
 *
 * @author mariq
 */
public class Detail_GPU_Models {
    private String Nomor_Transaksi,ID_GPU, Nama_GPU;
    private int Quantity,Harga,Total;

    public String getNama_GPU() {
        return Nama_GPU;
    }

    public void setNama_GPU(String Nama_GPU) {
        this.Nama_GPU = Nama_GPU;
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

    public String getID_GPU() {
        return ID_GPU;
    }

    public void setID_GPU(String ID_GPU) {
        this.ID_GPU = ID_GPU;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }
    
    
}
