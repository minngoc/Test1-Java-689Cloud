
import java.io.BufferedReader;
import java.nio.file.Files;
import java.util.ArrayList;

public class Student {

    private int ID;
    private String firstName, middleName, lastName;
    private myDate dob;
    private String address;
    private String gender;
    private ArrayList<MonHoc> dsMonHoc;
    private Float avgScore;

    public Student(int ID, String firstName, String middleName, String lastName, myDate dob, String address, String gender, ArrayList<MonHoc> dsMonHoc, Float avgscore) {
        this.ID = ID;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.gender = gender;
        this.dsMonHoc = dsMonHoc;
        this.avgScore = avgscore;
    }

    public Student() {
    }

    public int getID() {
        return ID;
    }

    public String getStringId() {
        return String.valueOf(ID);
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public myDate getDob() {
        return dob;
    }

    public void setDob(myDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ArrayList<MonHoc> getDsMonHoc() {
        return dsMonHoc;
    }

    public void setDsMonHoc(ArrayList<MonHoc> dsMonHoc) {
        this.dsMonHoc = dsMonHoc;
    }

    public Float getAvgScore() {
        return avgScore;
    }
    public String getStrAvgScore(){
        return String.valueOf(avgScore);
    }

    public void setAvgScore(Float avgScore) {
        this.avgScore = avgScore;
    }

    public String getTenMH() {
        String tenMH = null;
        return tenMH;
    }

    @Override
    public String toString() {
        return ID + ","
                + firstName + ","
                + middleName + ","
                + lastName + ","
                + dob + ","
                + address + ","
                + gender + ","
                + dsMonHoc + ","
                + avgScore;
    }
}
