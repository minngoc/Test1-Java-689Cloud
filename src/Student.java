import java.io.BufferedReader;
import java.nio.file.Files;
import java.util.ArrayList;


public class Student {
    private String ID;
    private String firstName, middleName, lastName;
    private myDate dob;
    private String address;
    private String gender;
    private String dsMonHoc;

    public Student(String ID, String firstName, String middleName, String lastName, myDate dob, String address, String gender, String dsMonHoc) {
        this.ID = ID;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.gender = gender;
        this.dsMonHoc = dsMonHoc;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
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

    public String getDsMonHoc() {
        return dsMonHoc;
    }

    public void setDsMonHoc(String dsMonHoc) {
        this.dsMonHoc = dsMonHoc;
    }

    @Override
    public String toString() {
        return ID + ','
                +","+ firstName
                +","+ middleName
                +","+ lastName
                +","+ dob
                +","+ address
                +","+ gender
                +","+ dsMonHoc;
    }
}
