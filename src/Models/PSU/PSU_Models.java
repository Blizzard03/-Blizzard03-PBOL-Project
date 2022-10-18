/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.PSU;

import java.sql.Blob;

/**
 *
 * @author mariq
 */
public class PSU_Models {
        private String ID_PSU, Vendor, Nama_PSU, Tier;
    private int Watt, Harga;
    private Blob Image;

    public String getID_PSU() {
        return ID_PSU;
    }

    public void setID_PSU(String ID_PSU) {
        this.ID_PSU = ID_PSU;
    }

    public String getVendor() {
        return Vendor;
    }

    public void setVendor(String Vendor) {
        this.Vendor = Vendor;
    }

    public String getNama_PSU() {
        return Nama_PSU;
    }

    public void setNama_PSU(String Nama_PSU) {
        this.Nama_PSU = Nama_PSU;
    }

    public String getTier() {
        return Tier;
    }

    public void setTier(String Tier) {
        this.Tier = Tier;
    }

    public int getWatt() {
        return Watt;
    }

    public void setWatt(int Watt) {
        this.Watt = Watt;
    }

    public int getHarga() {
        return Harga;
    }

    public void setHarga(int Harga) {
        this.Harga = Harga;
    }
}
