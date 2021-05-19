import javax.swing.*;

public class Gamemaster {
    private Ablagestapel ablagestapel;
    private Liste spielerliste;
    private Spielkarten spielkarten;
    private boolean uhrzeigersinn, spielstopp;
    private int spielernr;

    public enum Spielzug{
        ZIEHEN, LEGEN
    }

    public Gamemaster(Liste sl){
        spielerliste = sl;
        uhrzeigersinn = true;
        spielkarten = new Spielkarten();
        ablagestapel = new Ablagestapel(spielkarten.karteZiehen(true));
        kartenAusteilen(sl);
        //reihenfolge();
    }

    public void kartenAusteilen(Liste spieler){
        Listenelement l = spieler.getErster();
        for(int i=0; i<spieler.getAnzahl(); i++){
            for(int j=0; j<7; j++){
                Liste hk = l.getInhalt().getHandkarten();
                hk.hintenAnfuegen(spielkarten.karteZiehen(false));
                l.getInhalt().setHandkarten(hk);
            }
            l = l.getNaechster();
        }
    }

    public boolean istStapelbar(Karte k){
        if(k.farbe() == ablagestapel.getKarte().farbe()){
            return true;
        }else if(k.kartenwert() == ablagestapel.getKarte().kartenwert()){
            return true;
        }else{
            return k.farbe() == Karte.Kartenfarbe.SCHWARZ;
        }
    }

    public void reihenfolge(){
        spielstopp = false;
        spielernr = 0;
        while (!spielstopp) {
            Listenelement s = spielerliste.getErster();
            for(int i = 0; i<spielernr; i++){
                s = s.getNaechster();
            }
            spielzug((Spieler) s.getInhalt());
            if(uhrzeigersinn){
                spielernr++;
                if(spielernr == spielerliste.getAnzahl()) {
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
        Spielzug spielzug = Spielzug.LEGEN; //TODO: Zug abfragen
        switch (spielzug) {
            case ZIEHEN -> ziehen(s);
            case LEGEN -> legen(s);
        }
    }

    private void ziehen(Spieler s){
        Liste hk = s.getHandkarten();
        for(int i=0; i<ablagestapel.getZiehen(); i++){
            hk.hintenAnfuegen(spielkarten.karteZiehen(false));
        }
        ablagestapel.resetZiehen();
        s.setHandkarten(hk);
    }

    private void legen(Spieler s){
        Karte k = null;
        String string = (String) JOptionPane.showInputDialog(
                new JFrame(),
                "Welche Karte willst du legen?",
                "Karte legen",
                JOptionPane.QUESTION_MESSAGE,
                null,
                handkartenFeld(s),
                "Karte wählen"
        );
        System.out.println(string);
        k = spielkarten.stringZuKarte(string);
        //warten, bis karte ausgewählt und istStapelbar(k); k = ausgewählte Karte
        //karte legen
        //karte bei Spieler - 1

        //kartenwert: 0-9 Normalkarten; 20 = Aussetzen; 30 = 2+ Karte; 40 = Richtungswechsel; 50 = 4+ Karte; 60 = Farbwunsch
        switch (k.kartenwert()) {
            case 20: spielernr++; break; //Aussetzen
            case 30: ablagestapel.addZiehen(2); break; //2+
            case 40: uhrzeigersinn = !uhrzeigersinn; break; //Richtungswechsel
            case 50: ablagestapel.addZiehen(4); break; //4+ //TODO: Farbwunsch abfragen
            case 60: break; //TODO: Farbwunsch abfragen
            default: break; //Karten 0-9, nichts tun
        }
    }

    public Object[] handkartenFeld(Spieler s){
        int anzahl = s.getHandkarten().getAnzahl();
        Listenelement l = s.getHandkarten().getErster();
        Object[] feld = new Object[anzahl];
        for(int i=0; i<anzahl; i++){
            feld[i] = l.getInhalt().farbe().toString() + l.getInhalt().kartenwert();
            l = l.getNaechster();
        }
        return feld;
    }

    public void spielabschluss(){

    }
}
