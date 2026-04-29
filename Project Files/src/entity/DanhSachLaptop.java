package entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DanhSachLaptop {

    private final Laptop[] laptop;
    private int soluonglaptop;

    public DanhSachLaptop(int kichThuoc) {
        laptop = new Laptop[kichThuoc];
        soluonglaptop = 0;
        ReadLapTop();
    }

    public void addlaptop(Laptop ltp) {
        if (soluonglaptop < laptop.length) {
            laptop[soluonglaptop] = ltp;
            soluonglaptop++;
        } else {
            System.out.println("Danh sach laptop da day.");
        }
    }

    public void displayLap() {
        System.out.printf("%-5s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n", "ID", "mamaytinh", "loai","donvitinh", "soluong", "dongia", "RGBLED", "GraphicsCard", "plugVGA", "OpticalDrive");
        int id = 1;
        for (int i = 0; i < soluonglaptop; i++) {
            laptop[i].xuatthongtin(id++);
        }
    }

    public Laptop findLaptopByCode(String mamaytinh) {

        for (Laptop ltp : laptop) {
            if (ltp == null) {
                return null;
            }
            if (ltp.getMamaytinh().equals(mamaytinh)) {
                return ltp;
            }
        }
        return null;
    }

    @FunctionalInterface
    public interface ConditionChecker {

        // Phương thức này sẽ kiểm tra một điều kiện trên một đối tượng KhachHang
        boolean check(Laptop lt);
    }

    public void timkiem(ConditionChecker checker) {
        boolean found = false;
        int id = 1;
        for (Laptop lt : laptop) {
            if (lt != null && checker.check(lt)) {
                if (!found) {
                    System.out.println("Da tim thay san pham can tim ! ");
                    System.out.printf("%-5s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n", "ID", "mamaytinh", "loai","donvitinh", "soluong", "dongia", "RGBLED", "GraphicsCard", "plugVGA", "OpticalDrive");
                    found = true;
                }
                lt.xuatthongtin(id++);  // Hiển thị thông tin nhân viên
            }
        }
        if (!found) {
            System.out.println("Khong tim thay san pham trong danh sach ! ");
        }
    }

    public void timkiemMaSP(String mamaytinh) {
        timkiem(lt -> lt.getMamaytinh().equalsIgnoreCase(mamaytinh));
    }

    public void timkiemMaSPvaDonGia(String mamaytinh, double dongia) {
        timkiem(lt -> lt.getMamaytinh().equalsIgnoreCase(mamaytinh) && lt.getDongia() == dongia);
    }

    public void timkiemKhoangDonGia(double dongiaMin, double dongiaMax) {
        timkiem(lt -> lt.getDongia() >= dongiaMin && lt.getDongia() <= dongiaMax);
    }

    public Laptop remove(String mamaytinh) {
        for (int i = 0; i < soluonglaptop; i++) {
            if (laptop[i].getMamaytinh().equals(mamaytinh)) {
                Laptop remove = laptop[i];
                System.arraycopy(laptop, i + 1, laptop, i, soluonglaptop - i - 1);
                laptop[--soluonglaptop] = null;
                return remove;
            }
        }
        return null;
    }

    private void ReadLapTop() {
        try (Scanner scanner = new Scanner(new File("data/sanpham.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] data = line.split(" ");
                if (data.length == 9) {
                    String mamaytinh = data[0];
                    String loai = data[1];
                    String donvitinh = data[2];
                    String soluongStr = data[3];
                    int soluong;
                    try {
                        soluong = Integer.parseInt(soluongStr);
                    } catch (NumberFormatException e) {
                        System.err.println("Error: Invalid number format for soluong: " + soluongStr);
                        continue;
                    }
                    String dongiaStr = data[4];
                    double dongia;
                    try {
                        dongia = Double.parseDouble(dongiaStr);
                    } catch (NumberFormatException e) {
                        System.err.println("Error: Invalid number format for dongia: " + dongiaStr);
                        continue;
                    }
                    String RGBLED = data[5];
                    String GraphicsCard = data[6];
                    String plugVGA = data[7];
                    String OpticalDrive = data[8];
                    
                    Laptop laptop = null;
                    if (loai.equals("Gaming")) {
                        laptop = new GamingLaptop(mamaytinh, loai, donvitinh, soluong, dongia, RGBLED, GraphicsCard);
                    } else {
                        laptop = new OldDateLaptop(mamaytinh, loai, donvitinh, soluong, dongia, plugVGA, OpticalDrive);
                    }
                    addlaptop(laptop);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: File nhanvien.txt not found");
        }
    }

    private void WriteLapTops() {
        try (FileWriter writer = new FileWriter(new File("data/sanpham.txt"))) {
            for (int i = 0; i < soluonglaptop; i++) {
                Laptop lap = laptop[i];

                if (lap instanceof GamingLaptop) {
                    GamingLaptop g = (GamingLaptop) lap;
                    writer.write(String.format("%s %s %s %d %.0f %s %s null null\n",
                            g.getMamaytinh(), g.getLoai(), g.getDonvitinh(), g.getSoluong(), g.getDongia(),
                            g.getRGBLED(), g.getGraphicsCard()));
                } else if (lap instanceof OldDateLaptop) {
                    OldDateLaptop o = (OldDateLaptop) lap;
                    writer.write(String.format("%s %s %s %d %.0f null null %s %s\n",
                            o.getMamaytinh(), o.getLoai(), o.getDonvitinh(), o.getSoluong(), o.getDongia(),
                            o.getPlugVGA(), o.getOpticalDrive()));
                }
            }
            writer.flush();
        } catch (IOException e) {
            System.err.println("Error: Failed to write to file sanpham.txt - " + e.getMessage());
        }
    }

    
    public void updateFile(){
        WriteLapTops();
    }

}
