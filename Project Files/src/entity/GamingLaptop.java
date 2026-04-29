package entity;

import java.util.Scanner;

public class GamingLaptop extends Laptop {
    private String RGBLED;
    private String GraphicsCard;

    public GamingLaptop(String mamaytinh , String loai, String donvitinh, int soluong, double dongia, String RGBLED, String GraphicsCard) {
        super(mamaytinh, donvitinh, soluong, dongia, loai);
        this.RGBLED = RGBLED;
        this.GraphicsCard = GraphicsCard;
    }
    
    public GamingLaptop() { 
        super("", "", 0, 0.0,"");
    } 
    
    public String getRGBLED(){
       return RGBLED;
    }
    public void setRGBLED(String RGBLED){
        this.RGBLED = RGBLED;     
    }
    public String getGraphicsCard(){
        return GraphicsCard;
    }
    public void setGraphicsCard(String GraphicsCard){
        this.GraphicsCard=GraphicsCard;
    }
    
    @Override
    public void nhapthongtin() {
        super.nhapthongtin();
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap mau sac: ");
        RGBLED = sc.nextLine();
        System.out.print("nhap card do hoa: ");
        GraphicsCard = sc.nextLine(); 
        loai = "Gaming";
    }
    
    @Override
    public void xuatthongtin(int id){
        System.out.printf("%-5s %-10s %-10s %-10s %-10s %-10.0f %-15s %-10s %-10s %-10s\n",id, mamaytinh,loai, donvitinh, soluong, dongia, RGBLED, GraphicsCard, "null", "null");
    }
} 

