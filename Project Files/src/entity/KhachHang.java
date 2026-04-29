package entity;

import java.util.Scanner;

public class KhachHang {

    private String MaKH;
    private String Ten;
    private String NgaySinh;
    private int SDT;

    public KhachHang(){
        MaKH = "";
        Ten = "";
        NgaySinh = "";
        SDT = 0;
    }
    
    public KhachHang(String MaKH, String Ten, String NgaySinh , int SDT) {
        this.MaKH = MaKH;
        this.Ten = Ten;
        this.NgaySinh = NgaySinh;
        this.SDT = SDT;
    }
    
    public KhachHang(KhachHang kh){
        MaKH = kh.MaKH;
        Ten = kh.Ten;
        NgaySinh = kh.NgaySinh;
        SDT = kh.SDT;
    }
    

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public int getSDT() {
        return SDT;
    }

    public void setSDT(int SDT) {
        this.SDT = SDT;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public void nhapthongtin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("nhap ma khach hang: ");
        MaKH = scanner.nextLine();
        System.out.print("Nhap ten: ");
        Ten = scanner.nextLine();
        System.out.print("Nhap ngay sinh: ");
        NgaySinh = scanner.nextLine();
        System.out.print("nhap so dien thoai : ");
        SDT = scanner.nextInt();
    }

    public void xuatthongtin(int id) {
        System.out.printf("%-5d %-10s %-25s %-15s %-15s\n", id, MaKH, Ten,NgaySinh, SDT);

    }
}
