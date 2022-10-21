/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.Master.CPU;

/**
 *
 * @author mariq
 */
public class CPUModels {
    private String ID_CPU, Nama_CPU,Base_Clock,Max_Turbo_Clock,TDP,Socket;
    private int Cores,Thread,Harga;;

    public String getSocket() {
        return Socket;
    }

    public void setSocket(String Socket) {
        this.Socket = Socket;
    }


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

    public String getBase_Clock() {
        return Base_Clock;
    }

    public void setBase_Clock(String Base_Clock) {
        this.Base_Clock = Base_Clock;
    }

    public String getMax_Turbo_Clock() {
        return Max_Turbo_Clock;
    }

    public void setMax_Turbo_Clock(String Max_Turbo_Clock) {
        this.Max_Turbo_Clock = Max_Turbo_Clock;
    }

    public String getTDP() {
        return TDP;
    }

    public void setTDP(String TDP) {
        this.TDP = TDP;
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

    public int getHarga() {
        return Harga;
    }

    public void setHarga(int Harga) {
        this.Harga = Harga;
    }
    


}
    