
import java.io.*;
import java.util.*;

public class CSV {

    public String header = "ID,FirstName,MiddleName,LastName,DOB,Address,Gender,KeySubject,ListSubject,ListScore,AvgScore";
    public ArrayList<Student> arrStudent = new ArrayList<Student>();
    public ArrayList<String> student = new ArrayList<String>();
    public ArrayList<String> studentID = new ArrayList<String>();
    public ArrayList<String> lastNameStudent = new ArrayList<String>();
    public ArrayList<String> avgStudent = new ArrayList<String>();
    public ArrayList<String> DOBstudent = new ArrayList<String>();
    public int index = 0;
    public String[] name = new String[index];

    public CSV() {

    }
    private final String COMMA_DELIMITER = ",";
    private final String SPACE_DELIMITER = " ";
    //private final String NEW_LINE_SEPARATOR = "\n";
    private String FILE_ADDRESS = "C:\\Users\\Admin\\Desktop\\student.csv";

    public void readFileStudent() {
        try {
            File file = new File(FILE_ADDRESS);
            Reader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                addStudent(parseCsvLine(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> parseCsvLine(String csvLine) {
        ArrayList<String> result = new ArrayList<String>();
        if (csvLine != null) {
            String[] splitData = csvLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    public myDate setDateOfBirth(String std) {
        myDate dayOfBirth = new myDate();
        String spl[] = std.split("/");
        dayOfBirth.setDay(Integer.parseInt(spl[0]));
        dayOfBirth.setMonth(Integer.parseInt(spl[1]));
        dayOfBirth.setYear(Integer.parseInt(spl[2]));
        return dayOfBirth;
    }

    public MonHoc setMonHoc(String mamon, String tenmon, float diem) {
        MonHoc Mh = new MonHoc();
        Mh.setDiem(diem);
        Mh.setMaMH(mamon);
        Mh.setTenMH(tenmon);
        return Mh;
    }

    public ArrayList<MonHoc> getMonHoc(String mamon, String tenmon, String diem) {
        ArrayList<MonHoc> arrMonHoc = new ArrayList<MonHoc>();
        String eachMaMon[] = mamon.split(SPACE_DELIMITER);
        String eachTenMon[] = tenmon.split(SPACE_DELIMITER);
        String eachStringDiem[] = diem.split(SPACE_DELIMITER);
        Float[] eachFloatDiem = Arrays.stream(eachStringDiem).map(Float::valueOf).toArray(Float[]::new);
        //conver string array to float array
        for (int i = 0; i < eachMaMon.length; i++) {
            arrMonHoc.add(setMonHoc(eachMaMon[i], eachTenMon[i], eachFloatDiem[i]));
        }
        return arrMonHoc;
    }

    public boolean canAddStudent(String testcase) {
        try {
            int test = Integer.parseInt(testcase);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void addStudent(ArrayList<String> student) {
        try {
            Student stu = new Student();
            if (canAddStudent(student.get(0))) {
                stu.setID(Integer.parseInt(student.get(0)));
                stu.setFirstName(student.get(1));
                stu.setMiddleName(student.get(2));
                stu.setLastName(student.get(3));
                stu.setDob(setDateOfBirth(student.get(4)));
                stu.setAddress(student.get(5));
                stu.setGender(student.get(6));
                stu.setDsMonHoc(getMonHoc(student.get(7), student.get(8), student.get(9)));
                stu.setAvgScore(Float.parseFloat(student.get(10)));
                arrStudent.add(stu);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void showStudents(){
        String input = printArrStu();
        System.out.println(input);
    }

    public String handleSubject(ArrayList<MonHoc> ds) {
        ArrayList<MonHoc> mh = new ArrayList<MonHoc>();
        for(int i=0;i<ds.size();i++){
            mh.add(setMonHoc(ds.get(i).getMaMH(), ds.get(i).getTenMH(), ds.get(i).getDiem()));
        }
        String output = "";
        String mamon = "", tenmon = "", diem = "";
        for( MonHoc mon: mh){
            mamon=mamon.concat(mon.getMaMH()+" ");
            tenmon=tenmon.concat(mon.getTenMH() + " ");
            diem=diem.concat(mon.getStringDiem() + " ");
        }
        //System.out.println(mamon+","+tenmon+","+diem);
//        mh.forEach((sub) -> {
//            System.out.println(sub);
//            mamon.concat(sub.getMaMH() + " ");
//            //System.out.println(mamon);
//            tenmon.concat(sub.getTenMH() + " ");
//            diem.concat(sub.getStringDiem() + " ");
//        });
        output=output.concat(mamon + "," + tenmon + "," + diem);
        return output;
    }

    public String printArrStu() {
        readFileStudent();
        System.out.println(header);
        String input = "";
        for(Student stu:arrStudent){
            String student = stu.getStringId() + COMMA_DELIMITER +
                    stu.getFirstName() + COMMA_DELIMITER +
                    stu.getMiddleName() + COMMA_DELIMITER +
                    stu.getLastName() + COMMA_DELIMITER +
                    stu.getDob().toString() + COMMA_DELIMITER +
                    stu.getAddress() + COMMA_DELIMITER +
                    stu.getGender() + COMMA_DELIMITER +
                    handleSubject(stu.getDsMonHoc()) + COMMA_DELIMITER +
                    stu.getStrAvgScore();
            input=input.concat(student + "\n");
        }
//        arrStudent.forEach((stu) -> {
//            //System.out.println(stu.getDsMonHoc());
//            String student = stu.getStringId() + COMMA_DELIMITER +
//                            stu.getFirstName() + COMMA_DELIMITER +
//                            stu.getMiddleName() + COMMA_DELIMITER +
//                            stu.getLastName() + COMMA_DELIMITER +
//                            stu.getDob().toString() + COMMA_DELIMITER +
//                            stu.getAddress() + COMMA_DELIMITER +
//                            stu.getGender() + COMMA_DELIMITER +
//                            handleSubject(stu.getDsMonHoc()) + COMMA_DELIMITER +
//                            stu.getStrAvgScore();
//            input=input.concat(student + "\n");
//        });
        //System.out.println(input);
        return input;
    }

    public void insertStudent() throws IOException {
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
        do {
            System.out.println("- Select gender ( 1-Male, 0-Female ): ");
            chose = s.nextInt();
        } while (chose != 1 && chose != 0);
        //select gender
        if (chose == 1) {
            gender = "Nam";
        } else {
            gender = "Nu";
        }
        System.out.println("- Input number of Subject: ");
        int numSub = s.nextInt();
        int numofSub = numSub;
        ArrayList<MonHoc> listSubject = new ArrayList<MonHoc>();
        ArrayList<String> tenMH = new ArrayList<String>();
        MonHoc mh = new MonHoc();
        Float totalScore = (float) 0;
        do {
            mh.inputSubject();
            listSubject.add(mh);
            tenMH.add(mh.getTenMH());
            totalScore += mh.getDiem();
            numSub--;
        } while (numSub > 0);
        float avgScore = Math.round(((totalScore / numofSub) * 10) / 10);//avgScore = total / number of subject
        if (!findWithID(ID)) { // this ID does not exist --> add
            Student Stu = new Student(ID, firstName, middleName, lastName, day, adress, gender, listSubject, avgScore);
            arrStudent.add(Stu);
            writeFileStudent(Stu, tenMH);
            System.out.println(Stu);
            System.out.println("INSERT STUDENT SUCCESS!!");

        } else {
            System.out.println("ERROR !!! THIS STUDENT IS EXISTED !!!");
        }

    }

    public void writeFileStudent(Student s, ArrayList<String> tenMH) throws IOException {

        File tmpDir = new File(FILE_ADDRESS);
        if (!tmpDir.exists() && !tmpDir.isDirectory()) { //checking file availability
            tmpDir.createNewFile(); //create new file
        }
        try ( FileWriter writer = new FileWriter(FILE_ADDRESS, true) //as mentioned if not available then create new file so here always available file
        ) {
            String input, subj = "";

            for (String mh : tenMH) {
                subj = subj + " " + mh;
            }

            input = s.getID() + ","
                    + s.getFirstName() + ","
                    + s.getMiddleName() + ","
                    + s.getLastName() + ","
                    + s.getDob() + ","
                    + s.getAddress() + ","
                    + s.getGender() + ","
                    + subj + ","
                    + s.getAvgScore() + "\n";

            writer.write("\n" + input); //writing continue to the existed file

        }
    }

    public ArrayList<String> parseCsvLine1(String csvLine) {
        ArrayList<String> inFoStudent = new ArrayList<>();
        if (csvLine != null) {
            String[] splitData = csvLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                inFoStudent.add(splitData[i]);
                student.add(splitData[i]);
            }
        }
        return inFoStudent;
    }

    public void separateInforStudent(ArrayList<String> inFoStudent) {
        studentID.add(inFoStudent.get(0));
        lastNameStudent.add(inFoStudent.get(3));
        DOBstudent.add(inFoStudent.get(4));
        avgStudent.add(inFoStudent.get(0) + inFoStudent.get(8));

    }

    public void deleteStudent(Integer ID) throws IOException {
        if (findWithID(ID)) {
            String temp = FILE_ADDRESS;
            File tmpDir = new File(temp);
            if (!tmpDir.exists() && !tmpDir.isDirectory()) { //checking file availability
                tmpDir.createNewFile(); //create new file
            }
            try ( FileWriter writer = new FileWriter(temp, true)) //as mentioned if not available then create new file so here always available file
            {
                for (String s : studentID) {
                    if (s.equals(ID.toString())) {
                        continue;
                    }
//                    String input = ;
//                    writer.write("\n"+ input);
                }
            }
            System.out.println("DELETE SUCCESS!!");
        } else {
            System.out.println("!!! INVALID STUDENT !!!");
        }
    }

    public void rankedAcademic(Float avgScore) {
        if (avgScore > 8) {
            System.out.println("Very good");
        } else if (avgScore > 6.5 && avgScore <= 8) {
            System.out.println("Good");
        } else if (avgScore <= 6.5 && avgScore > 5) {
            System.out.println("Pass");
        } else if (avgScore > 3 && avgScore <= 5) {
            System.out.println("Weak");
        } else {
            System.out.println("Poor");
        }
    }

    public boolean findWithID(Integer ID) {
        for (String s : studentID) {
            if (s.equals(ID.toString())) {
                return true;//find student
            }
        }
        return false;
    }

    public void showArrayInforStudent() {
        for (String s : student) {
            System.out.println(s);
        }
        for (String s : studentID) {
            System.out.println(s);
        }
        for (String s : lastNameStudent) {
            System.out.println(s);
        }
        for (String s : DOBstudent) {
            System.out.println(s);
        }
        for (String s : avgStudent) {
            System.out.println(s);
        }
    }// check

}
