package entity;

public class HoaDon {

    private String MaHoaDon;
    private String NgayLaphoadon;
    private String MaKH;
    private String MaNV;
    private double tongtien;
    private ChiTietHoaDon[] list;

    public HoaDon(String MaHoaDon, String NgayLaphoadon, String MaKH, String MaNV, ChiTietHoaDon[] list) {
        this.MaHoaDon = MaHoaDon;
        this.NgayLaphoadon = NgayLaphoadon;
        this.MaKH = MaKH;
        this.MaNV = MaNV;
        this.tongtien = 0;
        for(ChiTietHoaDon ct : list){
            this.tongtien +=ct.getThanhtien();
        }
    }

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public String getNgayLaphoadon() {
        return NgayLaphoadon;
    }

    public void setNgayLaphoadon(String NgayLaphoadon) {
        this.NgayLaphoadon = NgayLaphoadon;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }
    
    public double gettongtien(){
        return tongtien;
    }
    public void xuatthongtin(int id) {
        System.out.printf("%-5s %-10s %-10s %-15s %-10s %-10s\n", id, MaHoaDon, NgayLaphoadon, MaKH, MaNV, tongtien);
    }
}
