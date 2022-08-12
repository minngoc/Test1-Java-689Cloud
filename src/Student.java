
import java.io.BufferedReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.*;
import java.util.Comparator;

public class Student{

    private int ID;
    private String firstName, middleName, lastName;
    private myDate dob;
    private String address;
    private String gender;
    private ArrayList<MonHoc> dsMonHoc;
    private Float avgScore;
    private Integer yearOfAdmission;

    public Student(int ID, String firstName, String middleName, String lastName, myDate dob, String address, String gender, ArrayList<MonHoc> dsMonHoc, Float avgscore, Integer namnhaphoc) {
        this.ID = ID;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.gender = gender;
        this.dsMonHoc = dsMonHoc;
        this.avgScore = avgscore;
        this.yearOfAdmission = namnhaphoc;
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

    public Integer getYearOfAdmission() {
        return yearOfAdmission;
    }

    public void setYearOfAdmission(Integer yearOfAdmission) {
        this.yearOfAdmission = yearOfAdmission;
    }

    public String getTenMH() {
        String tenMH = null;
        return tenMH;
    }

    public static Comparator<Student> StuIDComparator = new Comparator<Student>() {
        public int compare(Student s1, Student s2) {
            Integer StudentName1 = s1.getID();
            Integer StudentName2 = s2.getID();

            return StudentName1.compareTo(StudentName2);
        }
    };
    public static Comparator<Student> StuMonthComparator = new Comparator<Student>() {
        public int compare(Student s1, Student s2) {
            Integer StudentName1 = s1.getDob().getMonth();
            Integer StudentName2 = s2.getDob().getMonth();

            return StudentName1.compareTo(StudentName2);
        }
    };
    public static Comparator<Student> StuAvgScoreComparator = new Comparator<Student>() {
        public int compare(Student s1, Student s2) {
            String StudentName1 = s1.getStrAvgScore().toUpperCase();
            String StudentName2 = s2.getStrAvgScore().toUpperCase();

            return StudentName2.compareTo(StudentName1);
        }
    };
    public static Comparator<Student> StuYearAdmissionComparator = new Comparator<Student>() {
        public int compare(Student s1, Student s2) {
            Integer StudentName1 = s1.getYearOfAdmission();
            Integer StudentName2 = s2.getYearOfAdmission();

            return StudentName1.compareTo(StudentName2);
        }
    };

    public static Comparator<Student> StuNameComparator = new Comparator<Student>() {
        public int compare(Student s1, Student s2) {
            String StudentName1 = s1.getLastName().toUpperCase();
            String StudentName2 = s2.getLastName().toUpperCase();

            return StudentName1.compareTo(StudentName2);
        }
    };
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
