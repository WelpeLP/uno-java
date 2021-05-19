import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Hauptmenu extends JFrame {

  JLabel text;
  JLabel text2;
  JLabel texts1;
  JLabel texts2;
  JLabel texts3;
  JLabel texts4;

  JButton nSpiel;
  JButton Spiels;

  JTextField eingabes1;
  JTextField eingabes2;
  JTextField eingabes3;
  JTextField eingabes4;

  JCheckBox enables3;
  JCheckBox enables4;



  public Hauptmenu() {
    setVisible(true);
    setSize(500,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setTitle("Hauptmenü");
    setResizable(false);
    setLayout(null);

    //Schriftzug UNO

    //1,2 = Position im Fenster 2,3 = Größe des Textfeldes
    text = new JLabel("UNO");
    text.setBounds(500, 10, 500, 100);
    Font schrift = new Font("Serif", Font.BOLD + Font.ITALIC, 100 ); //Schriftart + Kursiv etc. + Größe
    text.setFont(schrift);
    add(text);

    //Schriftzug Spieler wählen
    text2 = new JLabel("Spieler wählen");
    text2.setBounds(450, 150, 500, 70);
    Font schrift2 = new Font("Serif", Font.BOLD + Font.ITALIC, 50);
    text2.setFont(schrift2);
    add (text2);
    text2.setVisible(false);

    //Schriftzug Spieler 1
    texts1 = new JLabel("Spieler 1");
    texts1.setBounds(450, 230, 200, 25);
    Font schrifts1 = new Font("Serif", Font.BOLD, 50);
    text2.setFont(schrifts1);
    add(texts1);
    texts1.setVisible(false);

    //Schriftzug Spieler 2
    texts2 = new JLabel("Spieler 2");
    texts2.setBounds(450, 300, 200, 25);
    Font schrifts2 = new Font("Serif", Font.BOLD, 50);
    text2.setFont(schrifts2);
    add(texts2);
    texts2.setVisible(false);

    //Schriftzug Spieler 3
    texts3 = new JLabel("Spieler 3");
    texts3.setBounds(450, 370, 200, 25);
    Font schrifts3 = new Font("Serif", Font.BOLD, 50);
    text2.setFont(schrifts3);
    add(texts3);
    texts3.setVisible(false);

    //Schriftzug Spieler 4
    texts4 = new JLabel("Spieler 4");
    texts4.setBounds(450, 440, 200, 25);
    Font schrifts4 = new Font("Serif", Font.BOLD, 50);
    text2.setFont(schrifts4);
    add(texts4);
    texts4.setVisible(false);

    Listener l = new Listener();

    //Button Neues Spiel
    nSpiel = new JButton("Neues Spiel");
    nSpiel.setBounds(500, 200, 200, 25);
    nSpiel.addActionListener(l);
    add(nSpiel);

    //Button Spiel starten
    Spiels = new JButton("Spiel starten");
    Spiels.setBounds(500, 550, 200, 25);
    Spiels.addActionListener(l);
    add(Spiels);
    Spiels.setVisible(false);

    //Textfeld Spieler 1
    eingabes1 = new JTextField();
    eingabes1.setBounds(450, 260, 200, 25);
    add(eingabes1);
    eingabes1.setVisible(false);

    //Textfeld Spieler 2
    eingabes2 = new JTextField();
    eingabes2.setBounds(450, 330, 200, 25);
    add(eingabes2);
    eingabes2.setVisible(false);

    //Textfeld Spieler 3
    eingabes3 = new JTextField();
    eingabes3.setBounds(450, 400, 200, 25);
    add(eingabes3);
    eingabes3.setEnabled(false);
    eingabes3.setVisible(false);

    //Textfeld Spieler 4
    eingabes4 = new JTextField();
    eingabes4.setBounds(450, 470, 200, 25);
    add(eingabes4);
    eingabes4.setEnabled(false);
    eingabes4.setVisible(false);

    cbListener lcb = new cbListener();

    //CheckBox Spieler 3
    enables3 = new JCheckBox ("");
    enables3.setBounds(520, 370, 150, 25);
    enables3.addItemListener(lcb);
    add(enables3);
    enables3.setVisible(false);

    //CheckBox Spieler 4
    enables4 = new JCheckBox ("");
    enables4.setBounds(520, 440, 150, 25);
    enables4.addItemListener(lcb);
    add(enables4);
    enables4.setEnabled(false);
    enables4.setVisible(false);
  }

  //Unterklassen Listener

  private class Listener implements ActionListener {
    //Listener für Buttons

    public void actionPerformed (ActionEvent e) {

      //Der Button Neues Spiel wird gedrückt und der User wird auf die Seite der Spielerauswahl weitergeleitet
      if (e.getSource() == nSpiel) {
        nSpiel.setVisible(false);

        text2.setVisible(true);
        texts1.setVisible(true);
        texts2.setVisible(true);
        texts3.setVisible(true);
        texts4.setVisible(true);
        Spiels.setVisible(true);
        eingabes1.setVisible(true);
        eingabes2.setVisible(true);
        eingabes3.setVisible(true);
        eingabes4.setVisible(true);
        enables3.setVisible(true);
        enables4.setVisible(true);
      }
      else {}
      
      //Ein neues Spiel wird gestartet
      if (e.getSource() == Spiels){
        text2.setVisible(false);
        texts1.setVisible(false);
        texts2.setVisible(false);
        texts3.setVisible(false);
        texts4.setVisible(false);
        Spiels.setVisible(false);
        eingabes1.setVisible(false);
        eingabes2.setVisible(false);
        eingabes3.setVisible(false);
        eingabes4.setVisible(false);
        enables3.setVisible(false);
        enables4.setVisible(false);
        text.setVisible(false);
        
        Gamemaster gamemaster = new Gamemaster(spieler);
      }
      else{}
    }
  }

  private class cbListener implements ItemListener{
    //Listener für Checkboxen
    
    public void itemStateChanged(ItemEvent e) {
      if (enables3.isSelected()){
        eingabes3.setEnabled(true);
        enables4.setEnabled(true);
      }
      else {
        eingabes3.setEnabled(false);
        enables4.setEnabled(false);
      }

      if (enables4.isSelected()){
        eingabes4.setEnabled(true);
      }
      else {
        eingabes4.setEnabled(false);
      }
    }
  }
}
