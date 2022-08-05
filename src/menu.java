import java.io.*;
import java.util.Scanner;

public class menu {
    Scanner s = new Scanner(System.in);
    public void Menu(){
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
        int choice=0;
        int option;
        do{
            System.out.print("---Select your choice: ");
            choice = s.nextInt();
            switch(choice){
                case 1:{
                    System.out.println("\n---HERE IS THE LIST OF STUDENT---");
                    CSV.readFileStudent();
                    break;
                }
                case 2:{
                    CSV.insertStudent();
                    break;
                }
                case 3:{
                    System.out.println("\tInput ID of student you want delete: ");
                    int ID = s.nextInt();
                    CSV.deleteStudent(ID);
                    break;
                }
                case 5:{
                    System.out.print("-Enter the ID you want to find: ");
                    Integer ID = s.nextInt();
                    boolean find = CSV.findWithID(ID);
                    if(find==true){
                        System.out.println("THIS STUDENT IS EXIST");
                    }else{
                        System.out.println("INVALID STUDENT");
                    }
                    break;
                }
            }

            System.out.println("Press key 1 to continue. Press any key to exit: ");
            option = s.nextInt();
        }while(option==1);

        System.out.println("END PROGRAM! SEE YOU AGAIN!");
    }

}
