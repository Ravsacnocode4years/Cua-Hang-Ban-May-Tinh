package entity;

import java.util.Scanner;


public class OldDateLaptop extends Laptop {
    private String plugVGA;
    private String OpticalDrive;

    public OldDateLaptop(String mamaytinh , String loai, String donvitinh, int soluong, double dongia, String plugVGA, String OpticalDrive) {
        super(mamaytinh, donvitinh, soluong, dongia, loai);
        this.plugVGA = plugVGA;
        this.OpticalDrive = OpticalDrive;
    }
    
    public OldDateLaptop() { 
        super("", "", 0, 0.0,"");
    } 

    public String getPlugVGA() {
        return plugVGA;
    }

    public void setPlugVGA(String plugVGA) {
        this.plugVGA = plugVGA;
    }

    public String getOpticalDrive() {
        return OpticalDrive;
    }

    public void setOpticalDrive(String OpticalDrive) {
        this.OpticalDrive = OpticalDrive;
    }
    
    @Override
    public void nhapthongtin() {
        super.nhapthongtin();
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap day cam");
        plugVGA = sc.nextLine();
        System.out.println("nhap o cung");
        OpticalDrive = sc.nextLine(); 
        loai = "Olddate";
    }
    
    @Override
    public void xuatthongtin(int id){
        System.out.printf("%-5s %-10s %-10s %-10s %-10s %-10.0f %-15s %-10s %-10s %-10s\n", id, mamaytinh, loai, donvitinh, soluong, dongia, "null", "null", plugVGA, OpticalDrive);
    }
    
}
