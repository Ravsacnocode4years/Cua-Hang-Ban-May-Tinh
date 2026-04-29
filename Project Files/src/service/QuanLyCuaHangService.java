package service;

import java.util.Scanner;

public class QuanLyCuaHangService {

    public void QuanLyCuaHang(NhanVienService nv, HoaDonService hd,NhapHangService nh, KhachHangService kh, LaptopService ltp,ThongKeService tk,Scanner sc) {
        boolean back = false;
        while (!back) {
            System.out.println("--------------- quan ly cua hang ---------------");
            System.out.println("1. Quan Ly San Pham");
            System.out.println("2. Quan Ly Nhan Vien");
            System.out.println("3. Quan Ly Khach Hang");
            System.out.println("4. Quan Ly Hoa Don");
            System.out.println("5. Xem Thong Ke");

            System.out.println("0. Back");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> {
                    ltp.manageLaptop();
                }
                case 2 -> {
                    nv.manageNhanVien();
                    break;
                }
                case 3 -> {
                    kh.manageKhachHang();
                }
                case 4 -> {
                    hd.manageHoaDon();
                }
                case 5 -> {
                    tk.xemThongKe();
                }
                case 0 ->
                    back = true;
                default ->
                    System.out.println("khong co hay con lai");
            }
        }
    }
}
