import java.io.*;
import java.util.*;

public class CSV {
    //public static String header ="ID,FirstName,MiddleName,LastName,DOB,Address,Gender,ListSubject,AvgScore";
    public static ArrayList<String> studentID = new ArrayList<String>();
    public static ArrayList<String> student = new ArrayList<>();
    public CSV() {

    }
    private static final String COMMA_DELIMITER = ",";
    //private static final String NEW_LINE_SEPARATOR = "\n";
    private static String fileName = "C:\\Users\\MacBook\\Desktop\\student.csv";
    public static void readFileStudent(){
        try{
            File file = new File(fileName);
            Reader reader =  new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line =  br.readLine()) != null){
                //System.out.println(line);
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
    public static void printStudent(ArrayList<String>student){
        System.out.println(student.get(0)+","
                        +student.get(1)+","
                        +student.get(2)+","
                        +student.get(3)+","
                        +student.get(4)+","
                        +student.get(5)+","
                        +student.get(6)+","
                        +student.get(7)+","
                        +student.get(8)
        );
        //System.out.println(student.get(8));
    }

    public static void insertStudent() throws IOException{
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
        int chose;
        String gender;
        do{
            System.out.println("- Select gender ( 1-Male, 0-Female ): ");
            chose = s.nextInt();
        }while(chose!=1 && chose!=0);
        //select gender
        if(chose ==1){
            gender = "Nam";
        }else{gender = "Nu";}
        System.out.println("- Input number of Subject: ");
        int numSub = s.nextInt();
        int numofSub = numSub;
        ArrayList<MonHoc> listSubject = new ArrayList<MonHoc>();
        ArrayList<String> tenMH = new ArrayList<String>();
        MonHoc mh = new MonHoc();
        Float totalScore = (float)0;
        do{
            mh.inputSubject();
            listSubject.add(mh);
            tenMH.add(mh.getTenMH());
            totalScore+=mh.getDiem();
            numSub--;
        }while(numSub>0);
        float avgScore = Math.round(((totalScore/numofSub)*10)/10);//avgScore = total / number of subject
        if(!findWithID(ID)){ // this ID does not exist --> add
            Student student = new Student(ID, firstName, middleName, lastName, day, adress, gender, listSubject, avgScore);
            writeFileStudent(student,tenMH);
            System.out.println(student);
            System.out.println("INSERT STUDENT SUCCESS!!");

        }else{
            System.out.println("ERROR !!! THIS STUDENT IS EXISTED !!!");
        }

    }
    public static void writeFileStudent(Student s, ArrayList<String> tenMH) throws IOException{

        File tmpDir = new File(fileName);
        if (!tmpDir.exists() && !tmpDir.isDirectory()){ //checking file availability
            tmpDir.createNewFile(); //create new file
        }
        try (FileWriter writer = new FileWriter(fileName, true) //as mentioned if not available then create new file so here always available file
        ) {
            String input,subj = "";

            for(String mh : tenMH){
                subj = subj +" "+ mh ;
            }

            input=s.getID()+ ","+ s.getFirstName() +","+s.getMiddleName() +","+ s.getLastName() +","+ s.getDob() +","+ s.getAddress() +","+ s.getGender() +","+ subj +","+ s.getAvgScore()+"\n";

            writer.write("\n"+input); //writing continue to the existed file

        }
    }

    public static void readFileStudent1(){
        try{
            File file = new File(fileName);
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
            studentID.add(splitData[0]);
            for(int i=0; i < splitData.length; i++){
                student.add(splitData[i]);
            }
        }
        return studentID;
    }

    public static void deleteStudent(int ID){
        if(findWithID(ID)){
            readFileStudent1();
            for(String s: student){

            }
        }else{
            System.out.println("!!! INVALID STUDENT !!!");
        }
    }

    public static void rankedAcademic(Float avgScore){
        if(avgScore>8){
            System.out.println("Very good");
        }else if(avgScore>6.5&&avgScore<=8){
            System.out.println("Good");
        }else if(avgScore<=6.5&&avgScore>5){
            System.out.println("Pass");
        }else if(avgScore>3&&avgScore<=5){
            System.out.println("Weak");
        }else{
            System.out.println("Poor");
        }
    }
    public static boolean findWithID(Integer ID) {
        readFileStudent1();
        for (String s : studentID) {
            if (s.equals(ID.toString())) {
                return true;//find student
            }
        }
        return false;
    }
}