package entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DanhSachKhachHang {

    private final KhachHang[] khachhang;
    private int soLuongKhachHang;

    public DanhSachKhachHang(int kichThuoc) {
        khachhang = new KhachHang[kichThuoc];
        soLuongKhachHang = 0;
        ReadCustomers();
    }

    public void addCustomer(KhachHang kh) {
        if (soLuongKhachHang < khachhang.length) {
            khachhang[soLuongKhachHang] = kh;
            soLuongKhachHang++;

        } else {
            System.out.println("Danh sach khach hang da day.");
        }
    }

    public void displayCustomers() {
        System.out.printf("%-5s %-10s %-25s %-15s %-15s\n", "ID", "MaKH", "Ten", "NgaySinh", "SDT");
        int id = 1;
        for (int i = 0; i < soLuongKhachHang; i++) {
            khachhang[i].xuatthongtin(id++);
        }
    }

    public KhachHang findCustomerByCode(String MaKH) {
        for (KhachHang customer : khachhang) {
            if (customer.getMaKH().equals(MaKH)) {
                return customer;
            }
        }
        return null;
    }
    
    @FunctionalInterface
    public interface ConditionChecker {
        boolean check(KhachHang kh);
    }
    
     public void timkiem(ConditionChecker checker) {
        boolean found = false;
        int id = 1;
        for (KhachHang kh : khachhang) {
            if (kh != null && checker.check(kh)) {
                if (!found) {
                    System.out.println("Da tim thay khach hang can tim !\n");
                    System.out.printf("%-5s %-10s %-25s %-15s %-15s\n", "ID", "MaKH", "Ten", "NgaySinh", "SDT");
                    found = true;
                }
                kh.xuatthongtin(id++);  // Hiển thị thông tin nhân viên, bạn có thể thay 1 bằng id động nếu cần
            }
        }
        if (!found) {
            System.out.println("Khong tim thay khach hang trong danh sach !");
        }
    }
    
    public void timkiemMaKH(String MaKH){
        timkiem(kh -> kh.getMaKH().equalsIgnoreCase(MaKH));
    }
    public void timkiemTenvaNgaySinh(String Ten, String NgaySinh) {
        timkiem(kh -> kh.getTen().toLowerCase().contains(Ten.toLowerCase()) && kh.getNgaySinh().toLowerCase().contains(NgaySinh));
    }
    
    public void timkiemTenHoacSDT(String Ten, int SDT) {
        timkiem(kh -> kh.getTen().toLowerCase().contains(Ten.toLowerCase()) || String.valueOf(kh.getSDT()).contains(String.valueOf(SDT)));
    }
     
    public KhachHang removeCustomer(String MaKH) {
        for (int i = 0; i < soLuongKhachHang; i++) {
            if (khachhang[i].getMaKH().equals(MaKH)) {
                KhachHang remove = khachhang[i];
                System.arraycopy(khachhang, i + 1, khachhang, i, soLuongKhachHang - i - 1);
                khachhang[--soLuongKhachHang] = null;
                WriteCustomers();
                return remove;
            }
        }
        return null;
    }
     private void ReadCustomers() {
        try (Scanner scanner = new Scanner(new File("data/Khachhang.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim(); 
                if (line.isEmpty()) {
                    continue;
                }
                String[] data = line.split(" ");
                if (data.length == 4) {
                    String MaKH = data[0];
                    String Ten = data[1];
                    String NgaySinh = data[2];
                    int SDT = Integer.parseInt(data[3]);
                    KhachHang kh = new KhachHang(MaKH, Ten, NgaySinh, SDT);
                    addCustomer(kh);
                } else {
                    System.err.println("Warning: Invalid data format in file Khachhang.txt");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: File khachhang.txt not found");
        }
    }
    private void WriteCustomers() {
        try (FileWriter writer = new FileWriter(new File("data/Khachhang.txt"))) {
            for (int i = 0; i < soLuongKhachHang; i++) {
            KhachHang kh = khachhang[i];
            String line = kh.getMaKH() + " " + kh.getTen() + " " + kh.getNgaySinh() +  " " + kh.getSDT();
            writer.write(line + "\n");            }
            writer.flush(); // Ensure data is written to the file
     //       System.out.println("Da ghi danh sach khach hang vao file khachhang.txt!");
        } catch (IOException e) {
            System.err.println("Error: Failed to write to file khachhang.txt - " + e.getMessage());
        }
    }
    public void updateFile() {
        WriteCustomers();  // Gọi phương thức private WriteCustomers()
    } 
}
