import java.io.*;
import java.util.*;

public class CSV {
    public static ArrayList<String> student = new ArrayList<String>();
    public CSV() {

    }
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    public static void readFileStudent(){
        try{
            File file = new File("C:\\Users\\MacBook\\Desktop\\student.csv");
            Reader reader =  new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line =  br.readLine()) != null){
                printStudent(parseCsvLine(line));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<String> parseCsvLine(String csvLine){
        ArrayList<String> result = new ArrayList<String>();
        if(csvLine != null){
            String[] splitData = csvLine.split(COMMA_DELIMITER);
            for(int i=0; i < splitData.length; i++){
                result.add(splitData[i]);
            }
        }
        return result;
    }
    public static void printStudent(ArrayList<String> student){
        System.out.println(
                student.get(0)+","
                +student.get(1)+","
                +student.get(2)+","
                +student.get(3)+","
                +student.get(4)+","
                +student.get(5)+","
                +student.get(6)+","
                +student.get(7)+","
                +student.get(8)
        );
        //System.out.println(student.get(0));
    }

    public static void insertStudent(){
        Scanner s = new Scanner(System.in);
        System.out.println("- Input ID: ");
        int ID = s.nextInt();
        s.nextLine();
        System.out.println("- Input First name: ");
        String firstName = s.nextLine();
        System.out.println("- Input Middle name: ");
        String middleName = s.nextLine();
        System.out.println("- Input Last name: ");
        String lastName = s.nextLine();
        System.out.println("- Input Day of birth: ");
        myDate day = new myDate();
        day.inputDay();
        System.out.println("- Input Adress: ");
        String adress = s.nextLine();
        int gender;
        do{
            System.out.println("- Select gender ( 1-Male, 0-Female ): ");
            gender = s.nextInt();
        }while(gender!=1 && gender!=0);
        System.out.println("- Input number of Subject: ");
        int numSub = s.nextInt();
        ArrayList<MonHoc> listSubject = new ArrayList<MonHoc>();
        ArrayList<String> tenMH = new ArrayList<String>();
        MonHoc mh = new MonHoc();
        Float totalScore = null, avgScore;
        do{
            mh.inputSubject();
            listSubject.add(mh);
            tenMH.add(mh.getTenMH());
            totalScore+=mh.getDiem();
            numSub--;
        }while(numSub>0);
        avgScore = totalScore/3;
        if(findWithID(ID)==false){
            Student student = new Student(ID, firstName, middleName, lastName, day, adress, gender, listSubject, avgScore);
            writeFileStudent(student,tenMH,numSub);
            System.out.println("INSERT STUDENT SUCCESS!!");
        }else{
            System.out.println("ERROR !!! THIS STUDENT IS EXISTED !!!");
        }

    }

    public static void writeFileStudent(Student s, ArrayList<String> tenMH, int numSub){
        String tempFile = "temp.csv";
        FileWriter fileWriter = null;
        try {
            File oldFile = new File("C:\\Users\\MacBook\\Desktop\\student.csv");
            File newFile = new File(tempFile);
            fileWriter = new FileWriter(tempFile,true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            PrintWriter pw = new PrintWriter(writer);
            Scanner x = new Scanner(new File("C:\\Users\\MacBook\\Desktop\\student.csv"));
            x.useDelimiter("\n");
            HashMap<Integer, Integer> map = new HashMap<>();
            Iterator itr = map.keySet().iterator();
            while (x.hasNext()){
                System.out.println(itr.hasNext());
                String ID = x.next();
                String firstName = x.next();
                String middleName = x.next();
                String lastName = x.next();
                String dob = x.next();
                String adress = x.next();
                String gender = x.next();
                String subject = x.next();
                String avgscore = x.next();
                if(Integer.parseInt(ID)==s.getID()){
                    pw.println(ID+","+firstName+","+middleName+","+lastName
                                +","+dob+","+adress+","+gender+","+subject+","+avgscore+"\n");
                }else {
                    String gender1;
                    if(s.getGender()==1){
                        gender1 = "Nam";
                    }else{
                        gender1 = "Nu";
                    }
                    pw.println(s.getID()+","
                            + s.getFirstName()+","
                            + s.getMiddleName()+","
                            + s.getLastName()+","
                            + s.getDob().toString()+","
                            + s.getAddress()+","
                            + gender1+","
                    );
                }
            }
            x.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File("C:\\Users\\MacBook\\Desktop\\student.csv");
            newFile.renameTo(dump);

//            writer.append(NEW_LINE_SEPARATOR);
//            //write a new student in file
//            writer.append(String.valueOf(s.getID()));
//            writer.append(COMMA_DELIMITER);
//            writer.append(s.getFirstName());
//            writer.append(COMMA_DELIMITER);
//            writer.append(s.getMiddleName());
//            writer.append(COMMA_DELIMITER);
//            writer.append((s.getLastName()));
//            writer.append(COMMA_DELIMITER);
//            writer.append(String.valueOf(s.getDob().toString()));
//            writer.append(COMMA_DELIMITER);
//            writer.append(s.getAddress());
//            writer.append(COMMA_DELIMITER);
//            if(s.getGender()==1){
//                writer.append("Nam");
//                writer.append(COMMA_DELIMITER);
//            }else{
//                writer.append("Nu");
//                writer.append(COMMA_DELIMITER);
//            }
//            while (numSub>0){
//                writer.append(tenMH.get(1));
//            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void readFileStudent1(){
        try{
            File file = new File("C:\\Users\\MacBook\\Desktop\\student.csv");
            Reader reader =  new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line =  br.readLine()) != null){
                parseCsvLine1(line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static ArrayList<String> parseCsvLine1(String csvLine){
        if(csvLine != null){
            String[] splitData = csvLine.split(COMMA_DELIMITER);
            for(int i=0; i < splitData.length; i++){
                student.add(splitData[i]);
            }
        }
        return student;
    }

    public static void deleteStudent(int ID){
        if(findWithID(ID)==false){

        }else{
            System.out.println("!!! INVALID STUDENT !!!");
        }
    }

    public static boolean findWithID(Integer ID){
        readFileStudent1();
        int i;
        for(i=1;i<ID;i++) {
            if (student.get(0).equals(ID.toString())==false) {
                continue;
            }
        }
        if(i<ID){
            return true;
        }else{
            return false;
        }
    }
}
