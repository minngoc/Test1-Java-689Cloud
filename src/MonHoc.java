
import java.util.Scanner;

public class MonHoc {

    private String maMH;//ko đc trùng
    private String tenMH;
    private Float diem;//double

    public MonHoc() {

    }

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

    public String getStringDiem() {
        return String.valueOf(this.diem);
    }

    public void inputSubject() {
        Scanner s = new Scanner(System.in);
        System.out.println("\t.Input Mã môn học: ");
        this.maMH = s.nextLine();
        System.out.println("\t.Input Name of subject: ");
        this.tenMH = s.nextLine();
        System.out.println("\t.Input Score: ");
        this.diem = s.nextFloat();
    }

    @Override
    public String toString() {
        return maMH + ',' + tenMH + ',' + diem;
    }
}
