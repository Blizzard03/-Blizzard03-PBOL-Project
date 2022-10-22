/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Master.RAM;

/**
 *
 * @author mariq
 */
public class RAMModels {
    private String ID_RAM,Nama_RAM,Frequency,Capacity,CL;
    private int DDR,Harga;

    public String getCL() {
        return CL;
    }

    public void setCL(String CL) {
        this.CL = CL;
    }


    public String getID_RAM() {
        return ID_RAM;
    }

    public void setID_RAM(String ID_RAM) {
        this.ID_RAM = ID_RAM;
    }

    public String getNama_RAM() {
        return Nama_RAM;
    }

    public void setNama_RAM(String Nama_RAM) {
        this.Nama_RAM = Nama_RAM;
    }

    public String getFrequency() {
        return Frequency;
    }

    public void setFrequency(String Frequency) {
        this.Frequency = Frequency;
    }

    public String getCapacity() {
        return Capacity;
    }

    public void setCapacity(String Capacity) {
        this.Capacity = Capacity;
    }

    public int getDDR() {
        return DDR;
    }

    public void setDDR(int DDR) {
        this.DDR = DDR;
    }

    public int getHarga() {
        return Harga;
    }

    public void setHarga(int Harga) {
        this.Harga = Harga;
    }
}
