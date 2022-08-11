
import java.io.*;
import java.util.Scanner;

public class menu {

    Scanner s = new Scanner(System.in);

    public void Menu() {
        System.out.println("------MENU------");
        System.out.println("1.Xem sinh viên"); //done
        System.out.println("2.Thêm Sinh viên"); //done
        System.out.println("3.Cập nhật thông tin sinh viên");
        System.out.println("4.Xóa sinh viên"); //done
        System.out.println("5.Tìm sinh viên bằng ID"); //done
        System.out.println("6.In theo hạng từ lớn tới nhỏ");//done
        System.out.println("7.Người đứng đầu -  Nguời đứng cuối");//done
        System.out.println("8.Số sinh viên giỏi, khá, trung bình, yếu, kém"); //done
        System.out.println("9.Xem tỉ lệ % giỏi, khá trung bình, yếu kém"); //done
        System.out.println("10.In tên danh sách sinh viên theo bảng chữ cái từ A - Z");//done
        System.out.println("11.Cho biết có bao nhiêu Sinh viên trùng tên với nhau và Tên gì");
        System.out.println("12.Cho biết có bao nhiêu Sinh viên có cùng tháng sinh và đó là những ai");
        System.out.println("13.Tìm kiếm những sinh viên có Tên là An"); //done
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
                case 3:{
                    System.out.print("-Enter the ID of student you want to update: ");
                    Integer ID = s.nextInt();
                    csv.updateStudent(ID);
                    break;
                }
                case 4: {
                    System.out.print("\tEnter ID of student you want delete: ");
                    int ID = s.nextInt();
                    csv.deleteStudent(ID);
                }
                case 5: {
                    System.out.print("-Enter the ID you want to find: ");
                    Integer ID = s.nextInt();
                    if (csv.findWithID(ID)!=null) {
                        csv.rankedAcademic(ID);
                    } else {
                        System.out.println("INVALID STUDENT");
                    }
                    break;
                }
                case 6:{
                    csv.sortByRank();
                    break;
                }
                case 7:{
                    csv.showTopAndlastStudent();
                    break;
                }
                case 8:{
                    csv.countRankedAcademic();
                    break;
                }
                case 9:{
                    csv.percentRankedAcademic();
                    break;
                }
                case 10:{
                    csv.sortByName();
                    break;
                }
                case 11:{
                    csv.findSameName();
                    break;
                }
                case 13:{
                    csv.findNameAn();
                    break;
                }
            }

            System.out.println("\nPRESS KEY 1 TO CONTINUE. PRESS ANY KEY TO EXIT: ");
            option = s.nextInt();
        } while (option==1);

        System.out.println("\nEND PROGRAM! SEE YOU AGAIN!");
    }

}
