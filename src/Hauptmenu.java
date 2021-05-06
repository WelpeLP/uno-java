// JDialog
import javax.swing.JDialog;
// JMenuBar
import java.awt.Color;
import javax.swing.JDialog;
import javax.swing.JMenuBar;
import javax.swing.border.LineBorder;
import javax.swing.border.Border;

public class Hauptmenu {
  
  public Hauptmenu(){
    JDialog hauptJDialog = new JDialog;
    hauptJDialog.setTitel("Hauptmenü");
    haputJDialog.setSize(450,300)
      
    // Border evtl
    Border bo = new LineBorder(Color.yellow);
    
    JMenuBar bar = new MenuBar;
    bar.setborder(bo);
    JMenu menu = new JMenu("UNO");
    JMenuItem item = new JMenuItem("Spielen");
    menu.add(item);
    bar.add(menu);
    hauptJDialog.setJMenuBar(bar);
    hauptJDialog.setVisible(true);
  }
  
  
  
}
