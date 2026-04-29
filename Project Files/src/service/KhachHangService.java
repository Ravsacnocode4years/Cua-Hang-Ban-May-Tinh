package service;

import java.util.Scanner;
import entity.DanhSachKhachHang;
import entity.KhachHang;

public class KhachHangService {
    private final DanhSachKhachHang ds;
    private final Scanner sc;

    public KhachHangService() {
        ds = new DanhSachKhachHang(100);
        sc = new Scanner(System.in);
    }

    public void add() {
        System.out.println("--------------- Nhap so luong khach hang muon them ---------------");
        int nummber = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < nummber; i++) {
            System.out.println("nhap thong tin cho khach hang so " + (i + 1) + ":");
            KhachHang kh = new KhachHang();
            kh.nhapthongtin();
            ds.addCustomer(kh);
            ds.updateFile();
        }
    }

    public void show() {
        ds.displayCustomers();
    }

    public void edit() {
        System.out.println("--------------- Nhap ma khach hang can sua ---------------");
        String MaKH = sc.nextLine();
        KhachHang kh = ds.findCustomerByCode(MaKH);
        if (kh != null) {
            System.out.print("Nhap ten moi:");
            kh.setTen(sc.nextLine());
            
            System.out.print("Nhap so dien thoai moi:");
            int sdt = Integer.parseInt(sc.nextLine());
            kh.setSDT(sdt);
            
            System.out.print("Nhap ngay sinh moi:");
            kh.setNgaySinh(sc.nextLine());
            
            ds.updateFile();
        } else {
            System.out.println("Khong tim thay khach hang voi ma: " + MaKH);
        }
    }

    public KhachHang timkiemKH(String MaKH){
        return ds.findCustomerByCode(MaKH);
    }
    
    public void timkiemMaKH(){
    System.out.println("Nhap ma khach hang can tim: ");
    String MaKH = sc.nextLine();
    ds.timkiem(kh -> kh.getMaKH().equalsIgnoreCase(MaKH));
    }
    
    public void timkiemTenVaNgaySinh(){
        System.out.println("Nhap ten khach hang: ");
        String Ten = sc.nextLine();
        System.out.println("Nhap ngay sinh: ");
        String NgaySinh = sc.nextLine();
        
        ds.timkiem(kh -> kh.getTen().toLowerCase().contains(Ten.toLowerCase()) && kh.getNgaySinh().toLowerCase().contains(NgaySinh));
    }
    
    public void timkiemTenHoacSDT() {
        System.out.println("Nhap ten: ");
        String Ten = sc.nextLine();
        
        System.out.println("Nhap SDT: "); 
        int SDT = Integer.parseInt(sc.nextLine());
        
        ds.timkiem(kh -> kh.getTen().toLowerCase().contains(Ten.toLowerCase()) || String.valueOf(kh.getSDT()).contains(String.valueOf(SDT)));
    }   
    
    public void delete() {
       System.out.println("Nhap ma khach hang can xoa: ");
       String MaKH = sc.nextLine();
       KhachHang kh = ds.removeCustomer(MaKH);
       if (kh == null) { 
           System.out.println("Khong co khach hang ton tai voi ma: " + MaKH);
       } else {
           System.out.println("Khach hang voi ma " + MaKH + " da duoc xoa.");
           ds.updateFile();
       }
    }

    public void manageKhachHang() {
        boolean back = false;
        while (!back) {
            System.out.println("--------------- quan ly khach hang ---------------");
            System.out.println("1. them khach hang");
            System.out.println("2. hien thi khach");
            System.out.println("3. chinh sua thong tin khach hang");
            System.out.println("4. xoa khach hang");
            System.out.println("5. tim kiem khach hang");
            System.out.println("6. Back");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> {
                    add();
                    break;
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
                    delete();
                    break;
                }
                case 5 -> {
                    timkiemMenu();
                }
                case 6 ->
                    back = true;
                default ->
                    System.out.println("khong co hay con lai");
            }
        }
    }
    
    private void timkiemMenu() {
        boolean back = false;
        while (!back){
             System.out.println("--------------- Tim kiem khach hang ---------------");
             
            System.out.println("1. tim kiem theo ma");
            System.out.println("2. tim kiem theo ten va ngay sinh");
            System.out.println("3. tim kiem theo ten hoac so dien thoai");
            System.out.println("4. Back");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 ->{
                    timkiemMaKH();
                    break;
                }
                case 2 ->{
                    timkiemTenVaNgaySinh();
                    break;
                }
                case 3 -> {
                    timkiemTenHoacSDT();
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
}
