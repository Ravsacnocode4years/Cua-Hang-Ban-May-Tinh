package service;

import java.util.Scanner;

import entity.ChiTietHoaDon;
import entity.DanhSachChiTietHoaDon;
import entity.DanhSachHoaDon;
import entity.HoaDon;
import java.text.DecimalFormat;

public class ThongKeService {
    private Scanner sc;
    private DanhSachHoaDon dshd;
    private DanhSachChiTietHoaDon dscthd;
    private HoaDon[] hdArray;
    private ChiTietHoaDon[] cthdArray;
    private boolean isDataChanged;

    public ThongKeService() {
        sc = new Scanner(System.in);
        dscthd = new DanhSachChiTietHoaDon(100);
        dshd = new DanhSachHoaDon(100,dscthd);
        hdArray = dshd.getDSHDArray();
        if (dscthd.getDanhSachChiTietHoaDon()!= null) {
            cthdArray = dscthd.getDanhSachChiTietHoaDon();
        }
        isDataChanged = false;
    }

    // Thêm phương thức cập nhật lại dữ liệu từ file
    public void capNhatThongKe() {
        if(isDataChanged){
            dshd.loadHoaDon(dscthd); // Đọc lại dữ liệu từ file hoa don
            dscthd.loadChiTietHoaDon(); // Đọc lại dữ liệu từ file chi tiết hoa don
            hdArray = dshd.getDSHDArray(); // Cập nhật lại mảng hoa don
            cthdArray = dscthd.getDanhSachChiTietHoaDon(); // Cập nhật lại mảng chi tiết hoa don
            isDataChanged = false; //cập nhật xong thì reset lại
        }
    }

    
    public void xemThongKe() {
        capNhatThongKe();
        
        boolean back = false;
        while (back == false) {
            System.out.println("---------------- Xem thong ke ---------------------");
            System.out.println("1. Xem doanh thu");
            System.out.println("2. Xem so luong da ban");
            System.out.println("3. Xem so luong don hang");
            System.out.println("0. back");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    xemDoanhThu();
                    break;
                case 2:
                    xemSoLuongHangDaBan();
                    break;
                case 3:
                    xemSoLuongDonHang();
                    break;
                case 0:
                    back = true;
                    break;

                default:
                    System.out.println("Ban chon sai lua chon!");
                    break;
            }
        }

    }

    public void xemDoanhThu() {
        double doanhThu = 0;

        for (HoaDon hd : hdArray) {
            if (hd != null) {
                doanhThu += hd.gettongtien();
            }

        }
        DecimalFormat formatter = new DecimalFormat("#,###");
        System.out.println("Doanh thu cua cua hang la: " + formatter.format(doanhThu));
    }

    public void xemSoLuongHangDaBan() {
        int soLuong = 0;
        boolean daBan = false;

        for (ChiTietHoaDon chiTietHoaDon : cthdArray) {
            if (chiTietHoaDon != null) {
                String maHD = chiTietHoaDon.getMaHoaDon();

                // Bỏ qua hóa đơn nhập (HDN)
                if (!maHD.startsWith("HDN")) {
                    soLuong += chiTietHoaDon.getSoluong();
                    daBan = true;
                }
            }
        }

        if (daBan) {
            System.out.println("Cu hang ban duoc " +soLuong+" laptop");
        } else {
            System.out.println("Chua ban duoc san pham nao.");
        }
    }



    public void xemSoLuongDonHang() {
        int soLuong = 0;
        boolean coDon = false;

        for (HoaDon hoaDon : hdArray) {
            if (hoaDon != null) {
                String maHD = hoaDon.getMaHoaDon();
                if(!maHD.startsWith("HDN")){
                    ChiTietHoaDon cthd = dscthd.findChiTietHoaDonByCode(hoaDon.getMaHoaDon());
                    if (cthd != null && cthd.getSoluong() > 0) {
                        soLuong++;
                        coDon = true;
                    }
                }
            }
        }

        if (coDon) {
            System.out.println("Cua hang da ban " + soLuong + " don hang");
        } else {
            System.out.println("Chua co don hang nao ca");
        }
    }
}