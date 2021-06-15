import javax.swing.*;

public class Gamemaster {
    private Ablagestapel ablagestapel;
    private Liste spielerliste;
    private Spielkarten spielkarten;
    private boolean uhrzeigersinn, spielstopp, zugBeendet;
    private int spielernr;

    public Gamemaster(Liste sl){
        spielerliste = sl;
        uhrzeigersinn = true;
        zugBeendet = false;
        spielerliste.listeAusgeben();
        spielkarten = new Spielkarten();
        ablagestapel = new Ablagestapel(spielkarten.karteZiehen(true));
        kartenAusteilen(sl);
        reihenfolge();
    }

    public void kartenAusteilen(Liste spieler){
        Listenelement l = spieler.getErster();
        int kartenanzahl = 7;
        for(int i=0; i<spieler.getAnzahl(); i++){
            for(int j=0; j<kartenanzahl; j++){
                Liste hk = l.getInhalt().getHandkarten();
                hk.hintenAnfuegen(spielkarten.karteZiehen(false));
                l.getInhalt().setHandkarten(hk);
            }
            l = l.getNaechster();
        }
    }

    public boolean istStapelbar(Karte k){
        if (k.farbe() == ablagestapel.getKarte().farbe()) {
            return true;
        } else if (k.kartenwert() == ablagestapel.getKarte().kartenwert()) {
            return true;
        } else if (k.farbe() == Karte.Kartenfarbe.SCHWARZ){
            return true;
        } else if (k.farbe() == ablagestapel.getFarbwunsch()){
            return true;
        } else {
            return false;
        }
    }

    public void reihenfolge(){
        spielstopp = false;
        spielernr = 0;
        while (!spielstopp) {
            System.out.println(spielernr);
            Listenelement s = spielerliste.getErster();
            for (int i = 0; i < spielernr; i++) {
                s = s.getNaechster();
            }
            zugBeendet = false;
            spielzug((Spieler) s.getInhalt());
            if(uhrzeigersinn){
                spielernr++;
                System.out.println("anzahl:" + spielerliste.getAnzahl());
                if(spielernr == spielerliste.getAnzahl()) {
                    System.out.println("spielernr = 0");
                    spielernr = 0;
                }else if(spielernr > spielerliste.getAnzahl()) {
                    spielernr = 1;
                }
            }else{
                spielernr--;
                if(spielernr == -1) {
                    spielernr = spielerliste.getAnzahl() - 1;
                }else if(spielernr < -1) {
                    spielernr = spielerliste.getAnzahl() - 2;
                }
            }
        }
    }

    public void spielzug(Spieler s){
        String options[] = new String[4];
        options[0] = "Uno sagen";
        options[1] = "Zug beenden";
        options[2] = "Legen";
        options[3] = "Ziehen (" + ablagestapel.getZiehen() + ")";

        if(zugBeendet){
            options = new String[2];
            options[0] = "Uno sagen";
            options[1] = "Zug beenden";
        }

        String option = (String) JOptionPane.showInputDialog(
                new JFrame(),
                "Wähle aus, was du tun willst. Ablagestapel: " + ablagestapel.getKarte().farbe().toString() + " " + spielkarten.kartenwertToString(ablagestapel.getKarte().kartenwert()),
                "Spieler " + s.spielername(),
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                "Legen"
        );

        if(option.equals(options[0])){
            //Uno sagen
        }else if(option.equals(options[1])){
            //nichts
        }else if(option.equals(options[2])){
            legen(s);
        }else if(option.equals(options[3])){
            ziehen(s);
        }else{
            System.out.println("Diese Auswahlmöglichkeit ist ungültig!");
            spielzug(s);
        }
    }

    private void farbwunsch(Spieler s){
        String farben[] = new String[4];
        farben[0] = "GRUEN";
        farben[1] = "ROT";
        farben[2] = "BLAU";
        farben[3] = "GELB";

        String farbe = (String) JOptionPane.showInputDialog(
                new JFrame(),
                "Wähle eine Farbe aus.",
                "Farbwahl",
                JOptionPane.QUESTION_MESSAGE,
                null,
                farben,
                farben[0]
        );

        if(farbe == farben[0]){
            ablagestapel.setFarbwunsch(Karte.Kartenfarbe.GRUEN);
        }else if(farbe == farben[1]){
            ablagestapel.setFarbwunsch(Karte.Kartenfarbe.ROT);
        }else if(farbe == farben[2]){
            ablagestapel.setFarbwunsch(Karte.Kartenfarbe.BLAU);
        }else if(farbe == farben[3]){
            ablagestapel.setFarbwunsch(Karte.Kartenfarbe.GELB);
        }else{
            farbwunsch(s);
        }

        spielzug(s);
    }

    private void ziehen(Spieler s){
        Liste hk = s.getHandkarten();
        for(int i=0; i<ablagestapel.getZiehen(); i++){
            hk.hintenAnfuegen(spielkarten.karteZiehen(false));
        }
        ablagestapel.resetZiehen();
        s.setHandkarten(hk);
        zugBeendet = true;
        spielzug(s);
    }

    private String kartenDialog(Spieler s) {
        String karte = (String) JOptionPane.showInputDialog(
                    new JFrame(),
                    "Welche Karte willst du legen? Ablagestapel: " + ablagestapel.getKarte().farbe().toString() + " " + spielkarten.kartenwertToString(ablagestapel.getKarte().kartenwert()),
                    "Karte legen",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    spielkarten.handkartenFeld(s),
                    s.getHandkarten().getErster().getInhalt().farbe().toString() + String.valueOf(s.getHandkarten().getErster().getInhalt().kartenwert())
            );
        return karte;
    }

    private void legen(Spieler s){
        Karte k = null;
        String karte = kartenDialog(s);
        boolean b = karte == null;
        if(b){
            spielzug(s);
        }
        System.out.println(karte);
        k = spielkarten.stringZuKarte(karte);
        try {
            if (!istStapelbar(k)) {
                legen(s);
            }else {
                ablagestapel.karteLegen(k);
                Liste hk = s.getHandkarten();
                hk.loeschen(k);
                s.setHandkarten(hk);
                ablagestapel.setFarbwunsch(k.farbe());
                zugBeendet = true;
                //kartenwert: 0-9 Normalkarten; 20 = Aussetzen; 30 = 2+ Karte; 40 = Richtungswechsel; 50 = 4+ Karte; 60 = Farbwunsch
                switch (k.kartenwert()) {
                    case 20:
                        spielernr++;
                        break; //Aussetzen
                    case 30:
                        ablagestapel.addZiehen(2);
                        break; //2+
                    case 40:
                        if (spielerliste.getAnzahl() == 2) {
                            spielernr++;
                        } else {
                            uhrzeigersinn = !uhrzeigersinn;
                        }
                        break; //Richtungswechsel (= Aussetzen bei 2 Spielern)
                    case 50:
                        ablagestapel.addZiehen(4);
                        farbwunsch(s);
                        break; //4+
                    case 60:
                        farbwunsch(s);
                        break;
                    default:
                        break; //Karten 0-9, nichts tun
                }
            }
        }catch(NullPointerException e){
            zugBeendet = false;
        }
        spielzug(s);
    }

    public void spielabschluss(){

    }
}
