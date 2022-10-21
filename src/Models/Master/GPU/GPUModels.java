/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Master.GPU;

/**
 *
 * @author mariq
 */
public class GPUModels {
    private String ID_GPU,Vendor,VRAM,Memory_Type,Frequency,GDP,Nama_GPU;
    private int Harga;

    public String getNama_GPU() {
        return Nama_GPU;
    }

    public void setNama_GPU(String Nama_GPU) {
        this.Nama_GPU = Nama_GPU;
    }

    public String getID_GPU() {
        return ID_GPU;
    }

    public void setID_GPU(String ID_GPU) {
        this.ID_GPU = ID_GPU;
    }

    public String getVendor() {
        return Vendor;
    }

    public void setVendor(String Vendor) {
        this.Vendor = Vendor;
    }

    public String getVRAM() {
        return VRAM;
    }

    public void setVRAM(String VRAM) {
        this.VRAM = VRAM;
    }

    public String getMemory_Type() {
        return Memory_Type;
    }

    public void setMemory_Type(String Memory_Type) {
        this.Memory_Type = Memory_Type;
    }

    public String getFrequency() {
        return Frequency;
    }

    public void setFrequency(String Frequency) {
        this.Frequency = Frequency;
    }

    public String getGDP() {
        return GDP;
    }

    public void setGDP(String GDP) {
        this.GDP = GDP;
    }

    public int getHarga() {
        return Harga;
    }

    public void setHarga(int Harga) {
        this.Harga = Harga;
    }
    
    
}
