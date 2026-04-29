package service;

import java.util.Scanner;
import entity.OldDateLaptop;
import entity.GamingLaptop;
import entity.DanhSachLaptop;
import entity.Laptop;

public class LaptopService {
    private Scanner sc;
    private DanhSachLaptop ds;
    
    public LaptopService() {
        ds = new DanhSachLaptop(100);
        sc = new Scanner(System.in);
    }
    
    public void addGaming() {
        System.out.println("--------------- Nhap so luong laptop gaming muon them ---------------");
        int nummber = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < nummber; i++) {
            System.out.println("nhap thong tin cho laptop gaming so " + (i + 1) + ":");
            GamingLaptop gaming = new GamingLaptop();
            gaming.nhapthongtin();
            ds.addlaptop(gaming);
        }
        ds.updateFile();
    }
    
    public void addold() {
        System.out.println("--------------- Nhap so luong laptop outDate muon them ---------------");
        int nummber = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < nummber; i++) {
            System.out.println("nhap thong tin cho laptop outDate so " + (i + 1) + ":");
            OldDateLaptop old = new OldDateLaptop();
            old.nhapthongtin();
            ds.addlaptop(old);
        }
        ds.updateFile();
    }
    
    public void show() {
        ds.displayLap();
    }
    
    public Laptop timLaptopTheoMa(String mamaytinh){
        return ds.findLaptopByCode(mamaytinh);
        
    }
    
public void edit() {
        System.out.println("Nhap ma maytinh can chinh sua: ");
        String mamaytinh = sc.nextLine();
        Laptop laptop = timLaptopTheoMa(mamaytinh);
        if (laptop != null) {

            System.out.println("Nhap don gia moi:");
            double gia = sc.nextDouble();
            System.out.println("Nhap so luong moi:");
            int soLuong = sc.nextInt();
            sc.nextLine();
            laptop.setDongia(gia);
            laptop.setSoluong(soLuong);
            
            if (laptop instanceof GamingLaptop) {
                System.out.print("nhap mau sac: ");
                String RGBLED = sc.nextLine();
                System.out.print("nhap card do hoa: ");
                String GraphicsCard = sc.nextLine(); 
                ((GamingLaptop) laptop).setRGBLED(RGBLED);
                ((GamingLaptop) laptop).setGraphicsCard(GraphicsCard);
            } else if (laptop instanceof OldDateLaptop) {
                System.out.println("nhap day cam");
                String plugVGA = sc.nextLine();
                System.out.println("nhap o cung");
                String OpticalDrive = sc.nextLine(); 
                ((OldDateLaptop) laptop).setPlugVGA(plugVGA);
                ((OldDateLaptop) laptop).setOpticalDrive(OpticalDrive);
            }
            System.out.println("Chinh sua thanh cong.");
        } else {
            System.out.println("Khong tim thay laptop voi ma: " + mamaytinh);
        }
        ds.updateFile();
    }
    
    public void delete() {
       System.out.println("Nhap ma maytinh can xoa: ");
       String mamaytinh = sc.nextLine();
       Laptop ltp = ds.remove(mamaytinh);
       if (ltp == null) { 
           System.out.println("Khong co may tinh ton tai voi ma: " + mamaytinh);
       } else {
           System.out.println("may tinh voi ma " + mamaytinh + " da duoc xoa.");
       }
       ds.updateFile();
    }
    
    public void timkiemMaSP(){
        System.out.println("Nhap ma san pham can tim : ");
        String mamaytinh = sc.nextLine();
        
        ds.timkiem(lt -> lt.getMamaytinh().equalsIgnoreCase(mamaytinh));
    }
    
    public void timkiemMaSPvaDonGia(){
        System.out.println("Nhap ma san pham can tim : ");
        String mamaytinh = sc.nextLine();
        System.out.println("Nhap don gia :");
        double dongia = sc.nextDouble();
        
        ds.timkiem(lt -> lt.getMamaytinh().equalsIgnoreCase(mamaytinh) && lt.getDongia() == dongia);
        
    }
    
    public void timkiemKhoangDonGia(){
        System.out.println("Nhap khoang don gia ma ban muon theo doi (A <= X <= B).");
        System.out.println("Nhap don gia A :");
        double dongiaMin = sc.nextDouble();
        System.out.println("Nhap don gia B :");
        double dongiaMax = sc.nextDouble();
        
        ds.timkiem(lt -> lt.getDongia() >= dongiaMin && lt.getDongia() <= dongiaMax);
    }
    
    public void manageLaptop() {
        boolean back = false;
        while(!back) {
            System.out.println("--------------- quan ly san pham ---------------");
            System.out.println("1. them san pham");
            System.out.println("2. hien thi san pham");
            System.out.println("3. thay doi thong tin san pham");
            System.out.println("4. tim kiem san pham");
            System.out.println("5. xoa san pham");
            System.out.println("6. Back");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice) {
                case 1 -> {chonLoaiLapTop();
                }
                case 2 -> {
                    show();
                    break;
                }
                case 3 -> {
                    edit();
                    break;
                }
                case 4 -> {
                    timkiemMenu();
                }
                case 5 -> {
                    delete();
                    break;
                }
                case 6 -> back = true;
                default -> System.out.println("khong co hay con lai");
            }
        }
    }
    public void chonLoaiLapTop(){
        System.out.println("Chon loai laptop:");
        System.out.println("1. Gaming Laptop");
        System.out.println("2. Office Laptop");
        int subChoice = sc.nextInt();
        sc.nextLine();
        switch (subChoice) {
            case 1 -> {
                addGaming();
                break;
            } 
            case 2 -> {
                addold();
                break;
            }
            default -> System.out.println("Lua chon khong hop le. Vui long chon lai."); 
        }
    }
    
    private void timkiemMenu() {
        boolean back = false;
        while (!back){
             System.out.println("--------------- Tim kiem san pham ---------------");
            System.out.println("1. tim kiem theo ma san pham");
            System.out.println("2. tim kiem theo ma san pham va don gia");
            System.out.println("3. tim kiem theo khoang don gia");
            System.out.println("4. Back");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 ->{
                    timkiemMaSP();
                    break;
                }
                case 2 ->{
                    timkiemMaSPvaDonGia();
                    break;
                }
                case 3 -> {
                    timkiemKhoangDonGia();
                    break;
                }
                    
                case 4 -> {
                    back = true;
                    break;
                }                  
                default ->
                    System.out.println("Khong co hay chon lai");
            }
        }
    }
    
    public void saveFile(){
        ds.updateFile();
    }
}
