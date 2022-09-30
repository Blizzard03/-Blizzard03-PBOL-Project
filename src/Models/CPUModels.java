/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author mariq
 */
public class CPUModels {
    private String ID_CPU, Nama_CPU,Frequency,TDP;
    private int Cores,Thread;
    private double Harga;

    public String getID_CPU() {
        return ID_CPU;
    }

    public void setID_CPU(String ID_CPU) {
        this.ID_CPU = ID_CPU;
    }

    public String getNama_CPU() {
        return Nama_CPU;
    }

    public void setNama_CPU(String Nama_CPU) {
        this.Nama_CPU = Nama_CPU;
    }

    public String getFrequency() {
        return Frequency;
    }

    public void setFrequency(String Frequency) {
        this.Frequency = Frequency;
    }

    public int getCores() {
        return Cores;
    }

    public void setCores(int Cores) {
        this.Cores = Cores;
    }

    public int getThread() {
        return Thread;
    }

    public void setThread(int Thread) {
        this.Thread = Thread;
    }

    public double getHarga() {
        return Harga;
    }

    public void setHarga(double Harga) {
        this.Harga = Harga;
    }
}
