package service;

import java.util.Scanner;
import entity.NhanVien;
import entity.Laptop;
import java.text.DecimalFormat;

public class BanHangService {
    public void BanHang(NhanVienService nv, HoaDonService hd, KhachHangService kh, LaptopService ltp, Scanner sc) {
        System.out.print("Nhap ma nhan vien: ");
        String MaNV = sc.nextLine();
        NhanVien nhanvien = nv.timNhanVienTheoMa(MaNV);
        if (nhanvien != null) {
            System.out.println(" tim thay nhan vien voi ma " + MaNV);
            System.out.print("nhap ma chi tiet hoa don: ");
            String MaHoaDon = sc.nextLine();
            boolean addLaptop = true;
            while (addLaptop) {
                System.out.println("------------ laptop hien co ----------");
                ltp.show();
                System.out.print("nhap ma laptop can mua: ");
                String mamaytinh = sc.nextLine();
                Laptop laptop = ltp.timLaptopTheoMa(mamaytinh);
                if (laptop != null) {
                    System.out.print("nhap so luong: ");
                    int soluong = sc.nextInt();
                    double dongia = laptop.getDongia();
                    DecimalFormat formatter = new DecimalFormat("#,###");
                    System.out.println("Don gia cua san pham la:" + formatter.format(dongia));
                    if (soluong <= laptop.getSoluong()) {
                        laptop.setSoluong(laptop.getSoluong() - soluong);                                                                    
                        hd.addHoaDonChiTiet(MaHoaDon, mamaytinh, soluong, dongia);
                        sc.nextLine();
                    } else {
                        System.out.println("so luong san pham khong du. so luong con lai: " + laptop.getSoluong());
                        sc.nextLine(); // Làm sạch bộ đệm sau khi thông báo lỗi
                    }
                } else {
                    System.out.println("khong tim thay san pham voi ma: " + mamaytinh);
                }
                System.out.println("Ban co muon them san pham khac? (y/n)");
                String response = sc.nextLine();
                if (!response.equalsIgnoreCase("y")) {
                    addLaptop = false;
                }
            }

            System.out.println("---------- thong tin chi tiet hoa don mua hang ----------");
            hd.showChitiethoadon();

            System.out.print("nhap ma khach hang mua hang: ");
            String MaKH = sc.nextLine();

            System.out.print("nhap ngay lap hoa don: ");
            String NgayLaphoadon = sc.nextLine();

            hd.addHoaDon(MaHoaDon, NgayLaphoadon, MaKH, MaNV);

            System.out.println("---------- thong tin hoa don mua hang ----------");
            hd.showHoadon();
            ltp.saveFile();
            hd.saveFile();
            hd.saveFileChiTiet();
        } else {
            System.out.println("khong tim thay nhan vien voi ma " + MaNV);
        }
    }
}
