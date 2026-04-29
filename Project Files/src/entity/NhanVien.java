package entity;

import java.util.Scanner;

public class NhanVien {

    private String MaNV;
    private String Ten;
    private String NgaySinh;
    private String QueQuan;
    private String ChucVu;
    private int SDT;

    public NhanVien(){
        MaNV = "";
        Ten = "";
        NgaySinh = "";
        QueQuan = "";
        ChucVu = "";
        SDT = 0;
    }
    public NhanVien(String MaNV, String Ten, String NgaySinh, String QueQuan, String ChucVu, int SDT) {
        this.MaNV = MaNV;
        this.Ten = Ten;
        this.NgaySinh = NgaySinh;
        this.QueQuan = QueQuan;
        this.ChucVu = ChucVu;
        this.SDT = SDT;
    }


    public String getMaNV() {
        if (MaNV != null) {
            
            return MaNV;
        }
        return null;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getQueQuan() {
        return QueQuan;
    }

    public void setQueQuan(String QueQuan) {
        this.QueQuan = QueQuan;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public int getSDT() {
        return SDT;
    }

    public void setSDT(int SDT) {
        this.SDT = SDT;
    }

    public void nhapthongtin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("nhap ma nhan vien: ");
        MaNV = scanner.nextLine();
        System.out.print("Nhap ten: ");
        Ten = scanner.nextLine();
        System.out.print("nhap ngay sinh: ");
        NgaySinh = scanner.nextLine();
        System.out.print("nhap que quan : ");
        QueQuan = scanner.nextLine();
        System.out.print("nhap chuc vu : ");
        ChucVu = scanner.nextLine();
        System.out.print("nhap so dien thoai : ");
        SDT = scanner.nextInt();

    }

    public void xuatthongtin(int id) {
        System.out.printf("%-5s %-10s %-25s %-15s %-15s %-15s %-15s\n", id, MaNV, Ten, NgaySinh, QueQuan, ChucVu, SDT);
    }
}
