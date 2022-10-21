/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Master.Cooler;

/**
 *
 * @author mariq
 */
public class CoolerModels {
    private String ID_COOLER,Nama_Cooler,Type,Socket;
    private int Harga;

    public String getID_COOLER() {
        return ID_COOLER;
    }

    public void setID_COOLER(String ID_COOLER) {
        this.ID_COOLER = ID_COOLER;
    }

    public String getNama_Cooler() {
        return Nama_Cooler;
    }

    public void setNama_Cooler(String Nama_Cooler) {
        this.Nama_Cooler = Nama_Cooler;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getSocket() {
        return Socket;
    }

    public void setSocket(String Socket) {
        this.Socket = Socket;
    }

    public int getHarga() {
        return Harga;
    }

    public void setHarga(int Harga) {
        this.Harga = Harga;
    }
    
}
