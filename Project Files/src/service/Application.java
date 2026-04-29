package service;

import java.util.Scanner;

public class Application {
    
    public void run() {
    Scanner sc = new Scanner(System.in);
    QuanLyCuaHangService QLCH = new QuanLyCuaHangService();
    BanHangService BH = new BanHangService();
    NhanVienService nv = new NhanVienService();
    KhachHangService kh = new KhachHangService();
    LaptopService ltp = new LaptopService();
    ThongKeService tk = new ThongKeService();
    HoaDonService hd = new HoaDonService();
    NhapHangService nh = new NhapHangService();
    
        boolean exit = false;

        while (!exit) {
            System.out.println("--------------- Chon ---------------");
            System.out.println("1. Ban hang");
            System.out.println("2. Nhap hang");
            System.out.println("3. Quan ly cua hang");
            System.out.println("0. Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> {
                    BH.BanHang(nv,hd,kh,ltp,sc);
                    break;
                }
                case 2 -> {
                    nh.NhapHang(nv,hd,kh,ltp,sc);
                    break;
                }
                case 3 -> {
                    QLCH.QuanLyCuaHang(nv,hd,nh,kh,ltp,tk,sc);
                    break;
                }
                case 0 ->
                    exit = true;
                default ->
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

}
