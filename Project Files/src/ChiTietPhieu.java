package entity;

public class ChiTietPhieu {
    
    private int maDH;
    private int soLuong;
    private int giaCa;
    private String tenHang;
    private int tongCong;

    public void setTenHang(String tenHang){
        this.tenHang = tenHang;
    }
    public String getTenHang(){
        return this.tenHang;
    }
    public void setMaDH(int ma){
        this.maDH = ma; 
    }
    public int getMaDH(){
        return this.maDH;
    }
    public void setSoLuong(int so){
        this.soLuong = so; 
    }
    public int getSoLuong(){
        return this.soLuong;
    }

    public void setGiaCa(int gia){
        this.giaCa = gia; 
    }
    public int getGiaCa(){
        return this.giaCa;
    }
    public void setTongCong(int tong){
        this.tongCong = tong; 
    }
    public int getTongCong(){
        return this.tongCong;
    }
    public ChiTietPhieu(
        int maDH,
        int soLuong,
        int giaCa,
        String tenHang,
        int tongCong
    ){
        this.maDH = maDH;
        this.tenHang = tenHang;
        this.giaCa = giaCa;
        this.tongCong = tongCong;
        this.soLuong = soLuong;
    }
    public ChiTietPhieu(
       ChiTietPhieu chiTiet
    ){
        this.maDH = chiTiet.maDH;
        this.tenHang = chiTiet.tenHang;
        this.giaCa = chiTiet.giaCa;
        this.tongCong = chiTiet.tongCong;
        this.soLuong = chiTiet.soLuong;
    }
}
