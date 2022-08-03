import javax.swing.*;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuanLySVFrame extends JFrame {
    //public CSV csv;
    JFrame frame = new JFrame("QLSV");
    private JButton btnThem;
    private JButton btnCapNhat;
    private JButton btnXoa;
    public JTextArea textAreaStudent;
    private JPanel panelQLSV;
    private JTextField textFiledFindID;
    private JButton btnFindID;
    private JTextField textFieldThemID;
    private JTextField textFieldThemHo;
    private JTextField textFieldThemTenDem;
    private JTextField textFieldThemTen;
    private JTextField textFieldThemGTinh;
    private JTextField textFieldThemDChi;
    private JTextField textFieldThemDOB;
    private JTextField textFieldThemMHoc;
    private JLabel lblID;
    private JLabel lblFirstName;
    private JLabel lblMiddleName;
    private JLabel lblName;
    private JLabel lblNGSinh;
    private JLabel lblDChi;
    private JLabel lblGTinh;
    private JLabel lblMonHoc;
    private JScrollPane jScrollPane;

    public QuanLySVFrame() {
        setResizable(false);
        init();
        showTextAreaStudent();
    }

    public void init(){
        panelQLSV= new JPanel();
        jScrollPane.setViewportView(textAreaStudent);
        textAreaStudent.setEditable(false);
        panelQLSV.add(jScrollPane);
        panelQLSV.add(btnThem);
        textFieldThemID.setBounds(80,80,80,80);
        panelQLSV.add(lblID);
        panelQLSV.add(lblFirstName);
        panelQLSV.add(lblMiddleName);
        panelQLSV.add(lblName);
        panelQLSV.add(lblNGSinh);
        panelQLSV.add(lblDChi);
        panelQLSV.add(lblGTinh);
        panelQLSV.add(lblMonHoc);
        panelQLSV.add(textFieldThemID);
        panelQLSV.add(textFieldThemHo);
        panelQLSV.add(textFieldThemTenDem);
        panelQLSV.add(textFieldThemTen);
        panelQLSV.add(textFieldThemDOB);
        panelQLSV.add(textFieldThemDChi);
        panelQLSV.add(textFieldThemGTinh);
        panelQLSV.add(textFieldThemMHoc);
        panelQLSV.add(btnCapNhat);
        panelQLSV.add(btnXoa);
        panelQLSV.add(textFiledFindID);
        panelQLSV.add(btnFindID);
        frame.add(panelQLSV);
        frame.setBounds(100,100,600,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public void showTextAreaStudent(){
        readFileStudent();
    }

    public void readFileStudent() {
        try {
            File file = new File("C:\\Users\\MacBook\\Desktop\\student.csv");
            FileReader input = new FileReader(file);
            BufferedReader br = new BufferedReader(input);
            String line;
            while ((line = br.readLine()) != null) {
                textAreaStudent.append(line+"\n");
            }
            br.close();
            input.close();
        } catch(FileNotFoundException ex){
            Logger.getLogger(QuanLySVFrame.class.getName()).log(Level.SEVERE,null,ex);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]){
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            QuanLySVFrame q = new QuanLySVFrame();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
