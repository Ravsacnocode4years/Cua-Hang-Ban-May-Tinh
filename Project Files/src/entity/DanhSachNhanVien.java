package entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DanhSachNhanVien {

    private final NhanVien[] nhanvien;
    private int soluongnhanvien;

    public DanhSachNhanVien(int kichThuoc) {
        nhanvien = new NhanVien[kichThuoc];
        soluongnhanvien = 0;
        ReadEmployees();
    }

    public void addNhanVien(NhanVien nv) {
        if (soluongnhanvien < nhanvien.length) {
            nhanvien[soluongnhanvien] = nv;
            soluongnhanvien++;
        } else {
            System.out.println("Danh sach nhan vien da day.");
        }
    }

    public void displayEmployees() {
        System.out.printf("%-5s %-10s %-25s %-15s %-15s %-15s %-15s\n", "ID", "MaNV", "Ten", "NgaySinh", "QueQuan", "ChucVu", "SDT");
        int id = 1;
        for (int i = 0; i < soluongnhanvien; i++) {
            nhanvien[i].xuatthongtin(id++);
        }
    }
    
    public NhanVien findEmployeeByCode(String MaNV) {
        for (NhanVien nv : nhanvien) {
            if (nv == null) {
                break;
            }
            if (nv.getMaNV().equals(MaNV)) {
                return nv;
            }
        }
        return null;
    }

     @FunctionalInterface
    public interface ConditionChecker {
        // Phương thức này sẽ kiểm tra một điều kiện trên một đối tượng KhachHang
        boolean check(NhanVien nv);
    }
    
    public void timkiem(ConditionChecker checker) {
        boolean found = false;
        int id = 1;
        for (NhanVien nv : nhanvien) {
            if (nv != null && checker.check(nv)) {
                if (!found) {
                    System.out.println("Da tim thay nhan vien can tim ! \n");
                    System.out.printf("%-5s %-10s %-25s %-15s %-15s %-15s %-15s\n", "ID", "MaNV", "Ten", "NgaySinh", "QueQuan", "ChucVu", "SDT");
                    found = true;
                }
                nv.xuatthongtin(id++);  // Hiển thị thông tin nhân viên
            }
        }
        if (!found) {
            System.out.println("Khong tim thay nhan vien trong danh sach ! ");
        }
    }
    
    public void timkiemMaNV(String MaNV){
        timkiem(nv -> nv.getMaNV().equalsIgnoreCase(MaNV));
    }
    
    public void timkiemTenVaChucVu(String Ten, String ChucVu) {
        timkiem(nv -> nv.getTen().toLowerCase().contains(Ten.toLowerCase()) && nv.getChucVu().toLowerCase().contains(ChucVu));
    }
   
    public void timkiemQueQuanHoacSDT(String QueQuan, int SDT) {
        timkiem(nv -> nv.getQueQuan().toLowerCase().contains(QueQuan.toLowerCase()) || String.valueOf(nv.getSDT()).contains(String.valueOf(SDT)));
    }
    
    
    public NhanVien remove(String MaNV) {
        for (int i = 0; i < soluongnhanvien; i++) {
            if (nhanvien[i].getMaNV().equals(MaNV)) {
                NhanVien remove = nhanvien[i];
                System.arraycopy(nhanvien, i + 1, nhanvien, i, soluongnhanvien - i - 1);
                nhanvien[--soluongnhanvien] = null;
                return remove;
            }
        }
        return null;
    }
    private void ReadEmployees() {
    try (Scanner scanner = new Scanner(new File("data/nhanvien.txt"))) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim(); 
            if (line.isEmpty()) {
                continue;
            }

            String[] data = line.split(" ");
            if (data.length == 6) {
                String MaNV = data[0];
                String Ten = data[1];
                String NgaySinh = data[2];
                String QueQuan = data[3];
                String ChucVu = data[4];
                int SDT = Integer.parseInt(data[5]);
                NhanVien nv = new NhanVien(MaNV, Ten, NgaySinh, QueQuan, ChucVu, SDT);
                
                // Thêm trực tiếp mà KHÔNG gọi addNhanVien
                if (soluongnhanvien < nhanvien.length) {
                    nhanvien[soluongnhanvien++] = nv;
                }
            } else {
                System.err.println("Warning: Invalid data format in file nhanvien.txt");
            }
        }
        } catch (FileNotFoundException e) {
            System.err.println("Error: File nhanvien.txt not found");
        }
    }
    private void WriteEmployees() {
        try (FileWriter writer = new FileWriter(new File("data/nhanvien.txt"))) {
            for (int i = 0; i < soluongnhanvien; i++) {
            NhanVien nv = nhanvien[i];
            String line = nv.getMaNV() + " " + nv.getTen() + " " + nv.getNgaySinh() + " " +
                         nv.getQueQuan() + " " + nv.getChucVu() + " " + nv.getSDT();
            writer.write(line + "\n");            }
            writer.flush(); // Ensure data is written to the file
            //System.out.println("Da ghi danh sach nhan vien vao file nhanvien.txt!");
        } catch (IOException e) {
            System.err.println("Error: Failed to write to file nhanvien.txt - " + e.getMessage());
        }
    }
    public void updateFile() {
        WriteEmployees();  // Gọi phương thức private WriteCustomers()
    }
}
