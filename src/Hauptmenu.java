// JDialog
import javax.swing.*;
// JMenuBar
import java.awt.*;
import javax.swing.JDialog;
import javax.swing.border.LineBorder;
import javax.swing.border.Border;

public class Hauptmenu {
  
  public Hauptmenu(){
    JDialog hauptJDialog = new JDialog();
    hauptJDialog.setTitle("Hauptmenü");
    hauptJDialog.setSize(450,300);
      
    // Border evtl
    Border bo = new LineBorder(Color.yellow);
    
    JMenuBar bar = new JMenuBar();
    bar.setBorder(bo);
    JMenu menu = new JMenu("UNO");
    JMenuItem item = new JMenuItem("Spielen");
    menu.add(item);
    bar.add(menu);
    hauptJDialog.setJMenuBar(bar);
    hauptJDialog.setVisible(true);
  }
  
  
  
}
