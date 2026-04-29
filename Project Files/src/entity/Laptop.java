package entity;

import java.util.Scanner;

public abstract class Laptop {
    protected String mamaytinh;
    protected int soluong;
    protected double dongia;
    protected String donvitinh;
    protected String loai;
    @Override
    public String toString() {
        return "Laptop{" +  
                "mamaytinh='" + mamaytinh + '\'' +
                ", loai='" + loai + '\'' +
                ", soluong=" + soluong +
                ", dongia=" + dongia +               
                '}';
    }

    public Laptop(String mamaytinh, String donvitinh, int soluong, double dongia,String loai){
    this.mamaytinh = mamaytinh ;
    this.soluong=soluong;
    this.dongia = dongia;
    this.donvitinh=donvitinh;
    this.loai=loai;
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

    public String getDonvitinh() {
        return donvitinh;
    }

    public void setDonvitinh(String donvitinh) {
        this.donvitinh = donvitinh;
    }
    public String getLoai(){
        return loai;
    }
    public void setLoai(String loai){
        this.loai = loai;
    }
    
    public void nhapthongtin(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("nhap ma may tinh: ");
        mamaytinh = scanner.nextLine();
//        System.out.print("nhap loai may tinh: ");
//        loai = scanner.nextLine();
        System.out.print("Nhap so luong: ");
        soluong = scanner.nextInt();
        scanner.nextLine();
        System.out.print("nhap don gia: ");
        dongia = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("nhap don vi tinh: ");
        donvitinh = scanner.nextLine();
    }
    public abstract void xuatthongtin(int id);
} 


