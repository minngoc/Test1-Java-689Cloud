import java.io.IOException;
import javax.swing.UIManager;
public class main {
    public static void main(String[] args) throws IOException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            menu m = new menu();
            m.Menu();
            m.selection();
        } catch (Exception e) {

        }

    }
}
