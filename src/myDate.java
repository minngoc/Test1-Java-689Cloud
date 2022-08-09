import java.util.*;
public class myDate {
    private int day,month,year;

    public myDate(){

    }
    public myDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return day +"/"+month +"/"+ year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void inputDay(){
        Scanner s = new Scanner(System.in);
        System.out.println(". Input day: ");
        this.day = s.nextInt();
        System.out.println(". Input month: ");
        this.month = s.nextInt();
        System.out.println(". Input year: ");
        this.year = s.nextInt();
    }
}