package service;

import java.util.Scanner;
import entity.DanhSachNhanVien;
import entity.NhanVien;

public class NhanVienService {

    private final DanhSachNhanVien ds;
    private final Scanner sc;

    public NhanVienService() {
        ds = new DanhSachNhanVien(100);
        sc = new Scanner(System.in);
    }
    
    public void add() {
        System.out.println("--------------- nhap so luong nhan vien muon them ---------------");
        int number = sc.nextInt();
        sc.nextLine();
        
        for (int i = 0; i < number; i++) {
            System.out.println("nhap thong tin cho nhan vien so " + (i + 1) + ":");
            NhanVien nv = new NhanVien();
            nv.nhapthongtin();
            ds.addNhanVien(nv);
            ds.updateFile();
        }
    }

    public void show() {
        ds.displayEmployees();
    }
    
    public NhanVien timNhanVienTheoMa(String MaNV){
        return ds.findEmployeeByCode(MaNV);
    }
    

    public void edit() {
        System.out.println("--------------- Nhap ma nhan vien can sua ---------------");
        String MaNV = sc.nextLine();
        NhanVien nv = ds.findEmployeeByCode(MaNV);
        if (nv != null) { 
            System.out.println("Nhap ten moi:");
            nv.setTen(sc.nextLine());
            System.out.println("Nhap ngay sinh moi:");
            nv.setNgaySinh(sc.nextLine());
            System.out.println("Nhap que quan moi:");
            nv.setQueQuan(sc.nextLine());
            System.out.println("Nhap chuc vu moi:");
            nv.setChucVu(sc.nextLine());
            System.out.println("Nhap so dien thoai moi:");
            nv.setSDT(sc.nextInt());
            ds.updateFile();
        }
        else
        { 
            System.out.println("Khong tim thay nhan vien voi ma nhan vien: " + MaNV); 
        }
    }
    
    public void delete() {
       System.out.println("Nhap ma nhan vien can xoa: ");
       String MaNV = sc.nextLine();
       NhanVien nv = ds.remove(MaNV);
       if (nv == null) { 
           System.out.println("Khong co nhan vien ton tai voi ma: " + MaNV);
       } else {
           System.out.println("nhan vien voi ma " + MaNV + " da duoc xoa.");
           ds.updateFile();
       }
    }
    
    public void timkiemMaNV(){
        System.out.println("Nhap ma nhan vien can tim : ");
        String MaNV = sc.nextLine();
        ds.timkiem(nv -> nv.getMaNV().equalsIgnoreCase(MaNV));
    }
    
    public void timkiemTenVaChucVu(){
        System.out.println("Nhap ten nhan vien: ");
        String Ten = sc.nextLine();
        System.out.println("Nhap chuc vu: ");
        String ChucVu = sc.nextLine();

        // Tìm kiếm theo tên và chức vụ
        ds.timkiem(nv -> 
        nv.getTen().toLowerCase().contains(Ten.toLowerCase()) &&
        nv.getChucVu().toLowerCase().contains(ChucVu.toLowerCase())
    );
    }
    
    public void timkiemQueQuanHoacSDT() {
        System.out.println("Nhap que quan: ");
        String QueQuan = sc.nextLine();
        System.out.println("Nhap so dien thoai: ");
        int SDT = sc.nextInt();

        // Tìm kiếm theo quê quán hoặc số điện thoại
        ds.timkiem(nv -> nv.getQueQuan().toLowerCase().contains(QueQuan.toLowerCase()) || String.valueOf(nv.getSDT()).contains(String.valueOf(SDT)));
    } 
    
    public void manageNhanVien() {
        boolean back = false;
        while (!back) {
            System.out.println("--------------- quan ly nhan vien ---------------");
            System.out.println("1. them nhan vien");
            System.out.println("2. hien thi nhan vien");
            System.out.println("3. chinh sua thong tin nhan vien");
            System.out.println("4. xoa nhan vien");
            System.out.println("5. tim kiem nhan vien");
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
                    break;
                }
                case 6 ->
                    back = true;
                default ->
                    System.out.println("khong co hay chon lai");
            }
            
        }
    }
    private void timkiemMenu() {
        boolean back = false;
        while (!back){
             System.out.println("--------------- Tim kiem nhan vien ---------------");
            System.out.println("1. tim kiem theo ma");
            System.out.println("2. tim kiem theo ten va chuc vu");
            System.out.println("3. tim kiem theo que quan hoac so dien thoai");
            System.out.println("4. Back");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 ->{
                    timkiemMaNV();
                    break;
                }
                case 2 ->{
                    timkiemTenVaChucVu();
                    break;
                }
                case 3 -> {
                    timkiemQueQuanHoacSDT();
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
