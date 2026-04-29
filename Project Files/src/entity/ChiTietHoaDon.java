package entity;

import java.util.Date;

public class ChiTietHoaDon {

    private String MaHoaDon;
    private String mamaytinh;
    private int soluong;
    private double dongia;
    private double thanhtien;

    public ChiTietHoaDon(String MaHoaDon, String mamaytinh, int soluong, double dongia) {
        this.MaHoaDon = MaHoaDon;
        this.mamaytinh = mamaytinh;
        this.soluong = soluong;
        this.dongia = dongia;
        this.thanhtien = dongia * soluong;
    }

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public String getMamaytinh() {
        return mamaytinh;
    }

    public void setMamaytinh(String mamaytinh) {
        this.mamaytinh = mamaytinh;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public double getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(double thanhtien) {
        this.thanhtien = thanhtien;
    }

    public void xuatthongtin(int id) {
        System.out.printf("%-5d %-10s %-10s %-10d %-15.0f %-15.0f\n", id, MaHoaDon, mamaytinh, soluong, dongia, thanhtien);
    }
}
