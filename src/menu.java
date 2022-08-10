
import java.io.*;
import java.util.Scanner;

public class menu {

    Scanner s = new Scanner(System.in);

    public void Menu() {
        System.out.println("------MENU------");
        System.out.println("1.Xem sinh viên");
        System.out.println("2.Thêm Sinh viên");
        System.out.println("3.Cập nhật thông tin sinh viên");
        System.out.println("4.Xóa sinh viên");
        System.out.println("5.Tìm sinh viên bằng ID");
        System.out.println("6.In theo hạng từ lớn tới nhỏ");
        System.out.println("7.Người đứng đầu -  Nguời đứng cuối");
        System.out.println("8.Số sinh viên giỏi, khá, trung bình, yếu, kém");
        System.out.println("9.Xem tỉ lệ % giỏi, khá trung bình, yếu kém");
        System.out.println("10.In tên danh sách sinh viên theo bảng chữ cái từ A - Z");
        System.out.println("11.Cho biết có bao nhiêu Sinh viên trùng tên với nhau và Tên gì");
        System.out.println("12.Cho biết có bao nhiêu Sinh viên có cùng tháng sinh và đó là những ai");
        System.out.println("13.Tìm kiếm những sinh viên có Tên là An");
        System.out.println("14.Thống kê số lượng sinh viên theo năm vào học");
    }

    public void selection() throws IOException {
        int choice = 0;
        int option;
        CSV csv = new CSV();
        csv.readFileStudent();
        do {
            System.out.print("---Select your choice: ");
            choice = s.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("\n---HERE IS THE LIST OF STUDENT---");
                    csv.showStudents();
                    break;
                }
                case 2: {
                    csv.insertStudent();
                    break;
                }
                case 4: {
                    System.out.print("\tEnter ID of student you want delete: ");
                    int ID = s.nextInt();
                    csv.deleteStudent(ID);
                    break;
                }
                case 5: {
                    System.out.print("-Enter the ID you want to find: ");
                    Integer ID = s.nextInt();
                    //CSV.showArrayInforStudent();
                    //boolean find = csv.findWithID(ID);
                    if (csv.findWithID(ID)!=null) {
                        csv.rankedAcademic(ID);
                        //System.out.println("THIS STUDENT IS EXIST");
                    } else {
                        System.out.println("INVALID STUDENT");
                    }
                    break;
                }
                case 13:{
                    csv.findNameAn();
                    break;
                }
            }

            System.out.println("PRESS KEY 1 TO CONTINUE. PRESS ANY KEY TO EXIT: ");
            option = s.nextInt();
        } while (option==1);

        System.out.println("END PROGRAM! SEE YOU AGAIN!");
    }

}
