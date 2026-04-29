package service;

import java.util.Scanner;
import entity.NhanVien;
import entity.Laptop;

public class NhapHangService {

    public void NhapHang(NhanVienService nv, HoaDonService hd, KhachHangService kh, LaptopService ltp, Scanner sc) {
        System.out.print("Nhap ma nhan vien: ");
        String MaNV = sc.nextLine();
        NhanVien nhanvien = nv.timNhanVienTheoMa(MaNV);
        
        if (nhanvien != null) {
            System.out.println("Tim thay nhan vien voi ma " + MaNV);
            System.out.print("Nhap ma chi tiet hoa don muon nhap: ");
            String MaHoaDon = sc.nextLine();
            boolean addLaptop = true;
            
            while (addLaptop) {
                System.out.println("------------ Laptop hien co ----------");
                ltp.show();  // Hiển thị danh sách laptop hiện có
                System.out.print("Nhap ma laptop can nhap: ");
                String mamaytinh = sc.nextLine();
                Laptop laptop = ltp.timLaptopTheoMa(mamaytinh);
                
                if (laptop != null) {
                    System.out.print("Nhap so luong: ");
                    int soluong = sc.nextInt();
                    double dongia = laptop.getDongia();
                    sc.nextLine();  // Để xử lý dòng mới sau nextInt()

                    if (soluong > 0) {
                        // Cập nhật lại số lượng sản phẩm sau khi nhập hàng
                        laptop.setSoluong(laptop.getSoluong() + soluong);
                        
                        // Thêm chi tiết hóa đơn với giá âm
                        hd.addHoaDonChiTiet(MaHoaDon, mamaytinh, soluong, -dongia);  // Đơn giá âm cho nhập hàng
                    } else {
                        System.out.println("So luong phai la so duong.");
                    }
                } else {
                    System.out.println("------------------------- Nhap hang moi -------------------------");
                    ltp.chonLoaiLapTop();  // Xử lý nhập hàng mới
                }
                
                System.out.println("Ban co muon them san pham khac? (y/n)");
                String response = sc.nextLine();
                if (!response.equalsIgnoreCase("y")) {
                    addLaptop = false;
                }
            }
            
            // Hiển thị thông tin chi tiết hóa đơn nhập hàng
            System.out.println("---------- Thong tin chi tiet hoa don nhap ----------");
            hd.showChitiethoadon();
            
            System.out.print("Nhap ma nha san xuat: ");
            String MaKH = sc.nextLine();
            System.out.print("Nhap ngay lap hoa don: ");
            String NgayLapHoaDon = sc.nextLine();
            
            // Thêm hóa đơn nhập vào hệ thống
            hd.addHoaDon(MaHoaDon, NgayLapHoaDon, MaKH, MaNV);

            // Hiển thị thông tin hóa đơn nhập hàng
            System.out.println("---------- Thong tin hoa don nhap hang ----------");
            hd.showHoadon();

            // Lưu lại dữ liệu vào file
            ltp.saveFile();
            hd.saveFile();
            hd.saveFileChiTiet();

        } else {
            System.out.println("Khong tim thay nhan vien voi ma " + MaNV);
        }
    }
}
