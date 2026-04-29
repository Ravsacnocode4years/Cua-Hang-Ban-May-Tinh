package entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class DanhSachChiTietHoaDon {

    private final ChiTietHoaDon[] chitiethoadon;
    private int soLuongChiTietHoaDon;

    public DanhSachChiTietHoaDon(int kichThuoc) {
        chitiethoadon = new ChiTietHoaDon[kichThuoc];
        soLuongChiTietHoaDon = 0;
        ReadChiTietHoaDon();
    }

    public void addChiTietHoaDon(ChiTietHoaDon CTHD) {
        if (soLuongChiTietHoaDon < chitiethoadon.length) {
            chitiethoadon[soLuongChiTietHoaDon] = CTHD;
            soLuongChiTietHoaDon++;
        } else {
            System.out.println("Danh sach chi tiet hoa don da day.");
        }
    }

    public ChiTietHoaDon[] getDanhSachChiTietHoaDon(String MaHoaDon) {
        int count = 0;
        for (int i = 0; i < soLuongChiTietHoaDon; i++) {
            if (chitiethoadon[i].getMaHoaDon().equals(MaHoaDon)) {
                count++;
            }
        }
        ChiTietHoaDon[] result = new ChiTietHoaDon[count];
        int index = 0;
        for (int i = 0; i < soLuongChiTietHoaDon; i++) {
            if (chitiethoadon[i].getMaHoaDon().equals(MaHoaDon)) {
                result[index++] = chitiethoadon[i];
            }
        }

        return result;
    }

    public ChiTietHoaDon[] getDanhSachChiTietHoaDon() {
        if (chitiethoadon != null) {
            return chitiethoadon;
        }
        return null;
    }

    public void displayChiTietHoaDon() {
        DecimalFormat formatter = new DecimalFormat("#,###");
        System.out.printf("%-5s %-10s %-10s %-10s %-10s %-10s\n", "ID", "MaHoaDon", "mamaytinh", "soluong", "dongia", "thanhtien");
        int id = 1;
        for (int i = 0; i < soLuongChiTietHoaDon; i++) {
        ChiTietHoaDon cthd = chitiethoadon[i];
        // Định dạng dongia và thanhtien
        String formattedDongia = formatter.format(cthd.getDongia());
        String formattedThanhtien = formatter.format(cthd.getThanhtien());
        System.out.printf("%-5d %-10s %-10s %-10d %-10s %-10s\n", id++, cthd.getMaHoaDon(), cthd.getMamaytinh(), cthd.getSoluong(), formattedDongia, formattedThanhtien);
        }
    }

    public ChiTietHoaDon findChiTietHoaDonByCode(String MaHoaDon) {
        for (int i = 0; i < soLuongChiTietHoaDon; i++) {
            ChiTietHoaDon CTHD = chitiethoadon[i];
            if (CTHD != null && CTHD.getMaHoaDon().equals(MaHoaDon)) {
                return CTHD;
            }
        }
        return null;
    }

    private void ReadChiTietHoaDon() {
        try (Scanner scanner = new Scanner(new File("data/ChiTietHoaDon.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] data = line.split(" ");
                if (data.length == 5) {
                    String MaHoaDon = data[0];
                    String mamaytinh = data[1];
                    String soluongStr = data[2];
                    int soluong = Integer.parseInt(soluongStr);
                    String dongiaStr = data[3];
                    double dongia = Double.parseDouble(dongiaStr);
                    ChiTietHoaDon cthd = new ChiTietHoaDon(MaHoaDon, mamaytinh, soluong, dongia);
                    addChiTietHoaDon(cthd);
                } else {
                    System.err.println("Warning: Invalid data format in file hoadon.txt");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: File hoadon.txt not found");
        }
    }
        private void WriteChiTietHoaDons() {
        try (FileWriter writer = new FileWriter(new File("data/ChiTietHoaDon.txt"))) {
            for (int i = 0; i < soLuongChiTietHoaDon; i++) {
                ChiTietHoaDon cthd = chitiethoadon[i];
                // Xây dựng chuỗi dữ liệu từ các thuộc tính của ChiTietHoaDon
                String line = cthd.getMaHoaDon() + " " + cthd.getMamaytinh() + " " 
                    + cthd.getSoluong() + " " + cthd.getDongia() + " " + cthd.getThanhtien();
                writer.write(line + "\n");
            }
            writer.flush(); // Đảm bảo dữ liệu được ghi vào file
        } catch (IOException e) {
            System.err.println("Error: Failed to write to file hoadon.txt - " + e.getMessage());
        }
    }

    public void updateFile() {
        WriteChiTietHoaDons();  // Gọi phương thức private WriteHoaDons()
    }
    
    public void loadChiTietHoaDon(){
        ReadChiTietHoaDon();
    }
}
