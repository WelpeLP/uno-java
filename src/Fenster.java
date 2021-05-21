import javax.swing.JFrame;
import java.awt.*;

public class Fenster {
    public static void oeffnen() {
        JFrame jf = new Hauptmenu();
        jf.setVisible(true);
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setSize((int) (Math.floor(size.getWidth()) - 80),(int) (Math.floor(size.getHeight()) - 80));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setTitle("Hauptmenü");
        jf.setResizable(false);
    }
}