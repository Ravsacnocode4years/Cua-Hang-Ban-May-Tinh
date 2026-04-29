package entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class DanhSachHoaDon {
    
    private final HoaDon[] hoadon;
    private int soLuongHoaDon;

    public DanhSachHoaDon(int kichThuoc, DanhSachChiTietHoaDon dscthd) {
        hoadon = new HoaDon[kichThuoc];
        soLuongHoaDon = 0;
        ReadHoaDon(dscthd);
    }

    public void addHoaDon(HoaDon HD) {
        if (soLuongHoaDon < hoadon.length) {
            hoadon[soLuongHoaDon] = HD;
            soLuongHoaDon++;
        } else {
            System.out.println("Danh sach khach hang da day.");
        }
    }

    public void displayHoaDon() {
        DecimalFormat formatter = new DecimalFormat("#,###");
        System.out.printf("%-5s %-10s %-15s %-10s %-10s %-10s\n", "ID", "MaHoaDon", "NgayLaphoadon", "MaKH", "MaNV", "tongtien");
        int id = 1;
        for (int i = 0; i < soLuongHoaDon; i++) {
            HoaDon hoaDon = hoadon[i];
            // Định dạng tongtien
            String formattedTongTien = formatter.format(hoaDon.gettongtien());
            System.out.printf("%-5d %-10s %-15s %-10s %-10s %-10s\n", id++, hoaDon.getMaHoaDon(), hoaDon.getNgayLaphoadon(), hoaDon.getMaKH(), hoaDon.getMaNV(), formattedTongTien);
        }
    }

    public HoaDon findHoaDonByCode(String MaHoaDon) {
        for (HoaDon HD : hoadon) {
            if (HD.getMaHoaDon().equals(MaHoaDon)) {
                return HD;
            }
        }
        return null;
    }
    
    @FunctionalInterface
    public interface ConditionChecker {
        // Phương thức này sẽ kiểm tra một điều kiện trên một đối tượng KhachHang
        boolean check(HoaDon hd);
    }
    
    public void timkiem(ConditionChecker checker) {
        boolean found = false;
        DecimalFormat formatter = new DecimalFormat("#,###");
        int id = 1;
        for (HoaDon hd : hoadon) {
            if (hd != null && checker.check(hd)) {
                if (!found) {
                    System.out.println("Da tim thay hoa don can tim ! ");
                    System.out.printf("%-5s %-10s %-10s %-10s %-10s %-10s\n", "ID", "MaHoaDon", "NgayLaphoadon", "MaKH", "MaNV", "tongtien");
                    found = true;
                }
                String formattedTongTien = formatter.format(hd.gettongtien());
                System.out.printf("%-5d %-10s %-15s %-10s %-10s %-10s\n", id++, hd.getMaHoaDon(), hd.getNgayLaphoadon(), hd.getMaKH(), hd.getMaNV(), formattedTongTien);
            }
        }
        if (!found) {
            System.out.println("Khong tim thay hoa don trong danh sach ! ");
        }
    }
    
    public void timkiemMaHoaDon(String MaHoaDon){
        timkiem(hd -> hd.getMaHoaDon().equalsIgnoreCase(MaHoaDon));
    }
    
    public void timkiemMaNVvaNLHD(String NgayLaphoadon, String MaNV){
    timkiem(hd -> hd.getMaNV().equalsIgnoreCase(MaNV) && hd.getNgayLaphoadon().toLowerCase().contains(NgayLaphoadon));
    }   

    public void timkiemKhoangTongTien(double minTien, double maxTien){
        timkiem(hd -> hd.gettongtien() >= minTien && hd.gettongtien() <= maxTien);
    }
    public HoaDon[] getDSHDArray(){
        return hoadon;
    }
    
    private void ReadHoaDon(DanhSachChiTietHoaDon dscthd) {
        try (Scanner scanner = new Scanner(new File("data/hoadon.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] data = line.split(" ");
                if (data.length == 5) {  // Giả sử file này không chứa tổng tiền
                    String maHoaDon = data[0];
                    String ngayLapHoaDon = data[1];
                    String maKH = data[2];
                    String maNV = data[3];
                    double tongTien = Double.parseDouble(data[4]);
                    
                    ChiTietHoaDon[] list = dscthd.getDanhSachChiTietHoaDon(maHoaDon);

                    HoaDon hoaDon = new HoaDon(maHoaDon, ngayLapHoaDon, maKH, maNV, list);
                    addHoaDon(hoaDon);
                } else {
                    System.err.println("Warning: Invalid data format in file HoaDon.txt");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: File HoaDon.txt not found");
        } catch (NumberFormatException e) {
        System.err.println("Error: Cannot parse tongTien to number");
        }
    }
    private void WriteHoaDons() {
        try (FileWriter writer = new FileWriter(new File("data/hoadon.txt"))) {
            for (int i = 0; i < soLuongHoaDon; i++) {
                HoaDon hoaDon = hoadon[i];
                // Xây dựng chuỗi dữ liệu từ các thuộc tính của HoaDon
                String line = hoaDon.getMaHoaDon() + " " + hoaDon.getNgayLaphoadon() + " " 
                    + hoaDon.getMaKH() + " " + hoaDon.getMaNV() + " " + hoaDon.gettongtien();
                writer.write(line + "\n");
            }
            writer.flush(); // Đảm bảo dữ liệu được ghi vào file
        } catch (IOException e) {
            System.err.println("Error: Failed to write to file hoadon.txt - " + e.getMessage());
        }
    }

    public void updateFile() {
        WriteHoaDons();  // Gọi phương thức private WriteHoaDons()
    }
    public void loadHoaDon(DanhSachChiTietHoaDon dscthd){
        ReadHoaDon(dscthd);
    }
}

