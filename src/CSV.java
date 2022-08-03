import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class CSV {
    public CSV() {

    }

    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    public static void readFileStudent(){
        //BufferedReader br = null;
        try{
            File file = new File("C:\\User\\MacBook\\Desktop\\Student.csv");
            String[] test = null;
            FileReader input = new FileReader(file);
            BufferedReader br = new BufferedReader(input);
            String line;
        //    File file = new File("C:\\Users\\MacBook\\Desktop\\Student.csv");
            //Reader reader =  new FileReader(file);
            //br = new BufferedReader(reader);
            while ((line =  br.readLine()) != null){
                //printStudent(parseCsvLine(line));
                StringTokenizer token = new StringTokenizer(line);
                while(token.hasMoreTokens()){

                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static List<String> parseCsvLine(String csvLine){
        List<String> result= new ArrayList<String>();
        if(csvLine != null){
            String[] splitData = csvLine.split(COMMA_DELIMITER);
            for(int i=0; i< splitData.length; i++){
                result.add(splitData[i]);
            }
        }
        return result;
    }
    public static void printStudent(List<String> student){
        System.out.println(
                student.get(0)+","
                +student.get(1)+","
                +student.get(2)+","
                +student.get(3)+","
                +student.get(4)+","
                +student.get(5)+","
                +student.get(6)+","
                +student.get(7)
        );
    }

    public static void writeFileStudent(Student s){
        FileWriter fileWriter = null;
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
             File file = new File("C:\\Users\\MacBook\\Desktop\\Student.csv");
//            fileWriter = new FileWriter(file);

            reader = new BufferedReader(new FileReader(file));
//            fileWriter.append(NEW_LINE_SEPARATOR);
//            //write a new student in file
//            fileWriter.append(String.valueOf(s.getID()));
//            fileWriter.append(COMMA_DELIMITER);
//            fileWriter.append(s.getFirstName());
//            fileWriter.append(COMMA_DELIMITER);
//            fileWriter.append(s.getMiddleName());
//            fileWriter.append(COMMA_DELIMITER);
//            fileWriter.append((s.getLastName()));
//            fileWriter.append(String.valueOf(s.getDob().toString()));
//            fileWriter.append(COMMA_DELIMITER);
//            fileWriter.append(s.getAddress());
//            fileWriter.append(COMMA_DELIMITER);
//            fileWriter.append(String.valueOf(s.getDsMonHoc()));
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //public static void main(String[] args){
        //readFileStudent();
//        Student s = new Student("4","Dinh","Hoang","Tri",
//                new myDate(04,03,2022),"Ho Chi Minh", "Ly, Hoa, Sinh");
//        readFileStudent();
    //}
}
