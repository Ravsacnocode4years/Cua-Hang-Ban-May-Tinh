package service;

import entity.DanhSachHoaDon;
import entity.DanhSachChiTietHoaDon;
import entity.HoaDon;
import entity.ChiTietHoaDon;
import java.util.Scanner;

public class HoaDonService {

    private Scanner sc;
    private DanhSachHoaDon ds;
    private DanhSachChiTietHoaDon dscthd;

    public HoaDonService() {
        dscthd = new DanhSachChiTietHoaDon(100);
        ds = new DanhSachHoaDon(100, dscthd);
        dscthd = new DanhSachChiTietHoaDon(100);
        sc = new Scanner(System.in);
    }

    public void addHoaDon(String MaHoaDon, String NgayLaphoadon, String MaKH, String MaNV) {
        ChiTietHoaDon[] list = dscthd.getDanhSachChiTietHoaDon(MaHoaDon);
        HoaDon hd = new HoaDon(MaHoaDon, NgayLaphoadon, MaKH, MaNV, list);
        ds.addHoaDon(hd);
    }

    public void addHoaDonChiTiet(String MaHoaDon, String mamaytinh, int soluong, double dongia) {
        ChiTietHoaDon cthd = new ChiTietHoaDon(MaHoaDon, mamaytinh, soluong, dongia);
        dscthd.addChiTietHoaDon(cthd);
    }

    public void showChitiethoadon() {
        dscthd.displayChiTietHoaDon();
    }

    public void showHoadon() {
        ds.displayHoaDon();
    }

    public void hienThiChiTietHoaDon(String MaHoaDon) {
        ChiTietHoaDon[] list = dscthd.getDanhSachChiTietHoaDon(MaHoaDon);
        if (list.length > 0) {
            System.out.println("Chi Tiet Hoa Don cho Ma Hoa Don: " + MaHoaDon);
            System.out.printf("%-5s %-10s %-10s %-10s %-10s %-10s\n", "ID", "MaHoaDon", "mamaytinh", "soluong", "dongia", "thanhtien");
            int id = 1;
            for (ChiTietHoaDon chiTiet : list) {
                chiTiet.xuatthongtin(id++);
            }
        } else {
            System.out.println("Khong tim thay chi tiet hoa don voi Ma Hoa Don: " + MaHoaDon);
        }
    }

    public void timkiemMaHoaDon(){
        System.out.println("Nhap ma hoa don can tim : ");
        String MaHoaDon = sc.nextLine();
        ds.timkiem(hd -> hd.getMaHoaDon().equalsIgnoreCase(MaHoaDon));
    }
    
    public void timkiemMaNVvaNLHD(){
        System.out.println("Nhap ma nhan vien can tim : ");
        String MaNV = sc.nextLine();
        System.out.println("Nhap ngay lap hoa don :");
        String NgayLaphoadon = sc.nextLine();
        ds.timkiem(hd -> hd.getMaNV().equalsIgnoreCase(MaNV) && hd.getNgayLaphoadon().toLowerCase().contains(NgayLaphoadon));
    }
    
    public void timkiemKhoangTongTien(){
        System.out.println("Nhap khoang tong tien ma ban muon theo doi (A <= X <= B).");
        System.out.println("Nhap tong tien A :");
        double minTien = sc.nextDouble();
        System.out.println("Nhap tong tien B :");
        double maxTien = sc.nextDouble();
        ds.timkiem(hd -> hd.gettongtien() >= minTien && hd.gettongtien() <= maxTien);
    }
    
    public void saveFile() {
        ds.updateFile(); // hàm ghi file trong DanhSachHoaDon
    }

    public void saveFileChiTiet() {
        dscthd.updateFile(); // hàm ghi file trong DanhSachChiTietHoaDon
    }
    
    public void manageHoaDon() {
        boolean back = false;
        while (!back) {
            System.out.println("--------------- quan ly hoa don ---------------");
            System.out.println("1. hien thi hoa don");
            System.out.println("2. hien thi chi tiet hoa don");
            System.out.println("3. tim kiem hoa don");
            System.out.println("4. Back");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> {
                    showHoadon();
                    break;
                }
                case 2 -> {
                    System.out.print("nhap ma hoa don: ");
                    String MaHoaDon = sc.nextLine();
                    hienThiChiTietHoaDon(MaHoaDon);
                }
                case 3 -> {
                    timkiemMenu();
                }
                case 4 ->
                    back = true;
                default ->
                    System.out.println("khong co hay chon lai");
            }
        }
    }
    
    private void timkiemMenu() {
        boolean back = false;
        while (!back){
             System.out.println("--------------- Tim kiem hoa don ---------------");
            System.out.println("1. tim kiem theo ma hoa don");
            System.out.println("2. tim kiem theo ma nhan vien va ngay lap hoa don");
            System.out.println("3. tim kiem theo khoang tong tien");
            System.out.println("4. Back");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 ->{
                    timkiemMaHoaDon();
                    break;
                }
                case 2 ->{
                    timkiemMaNVvaNLHD();
                    break;
                }
                case 3 -> {
                    timkiemKhoangTongTien();
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
