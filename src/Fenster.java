import javax.swing.JFrame;

public class Fenster {
    public static void main (String args []) {
        JFrame jf = new Hauptmenu();
        jf.setVisible(true);
        jf.setSize(1280,720);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setTitle("Hauptmenü");
        jf.setResizable(false);
    }
}