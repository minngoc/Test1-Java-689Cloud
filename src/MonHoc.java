public class MonHoc {
    private String maMH;
    private String tenMH;
    private Float diem;

    public MonHoc(String maMH, String tenMH, Float diem) {
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.diem = diem;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public Float getDiem() {
        return diem;
    }

    public void setDiem(Float diem) {
        this.diem = diem;
    }
}
