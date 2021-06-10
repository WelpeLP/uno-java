import javax.swing.*;

public class Gamemaster {
    private Ablagestapel ablagestapel;
    private Liste spielerliste;
    private Spielkarten spielkarten;
    private boolean uhrzeigersinn, spielstopp;
    private int spielernr;

    public Gamemaster(Liste sl){
        spielerliste = sl;
        uhrzeigersinn = true;
        spielerliste.listeAusgeben();
        spielkarten = new Spielkarten();
        ablagestapel = new Ablagestapel(spielkarten.karteZiehen(true));
        kartenAusteilen(sl);
        reihenfolge();
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
            System.out.println(spielernr);
            Listenelement s = spielerliste.getErster();
            for (int i = 0; i < spielernr; i++) {
                s = s.getNaechster();
            }
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

    public void reihenfolgeTeilZwei(){

    }

    public void spielzug(Spieler s){
        String options[] = new String[4];
        options[0] = "Uno sagen";
        options[1] = "Ziehen (" + ablagestapel.getZiehen() + ")";
        options[2] = "Legen";
        options[3] = "Zug beenden";

        String option = (String) JOptionPane.showInputDialog(
                new JFrame(),
                "Wähle aus, was du tun willst. Ablagestapel: " + ablagestapel.getKarte().farbe().toString() + " " + kartenwertToString(ablagestapel.getKarte().kartenwert()),
                "Spieler " + s.spielername(),
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                "Legen"
        );

        if(option.equals(options[0])){
            //Uno sagen
        }else if(option.equals(options[1])){
            ziehen(s);
        }else if(option.equals(options[2])){
            legen(s);
        }else if(option.equals(options[3])){
            reihenfolgeTeilZwei();
        }else{
            System.out.println("Diese Auswahlmöglichkeit ist ungültig!");
        }
    }

    private void nullFct() {}

    private String kartenwertToString(int wert){
        String kartenwert;
        //kartenwert: 0-9 Normalkarten; 20 = Aussetzen; 30 = 2+ Karte; 40 = Richtungswechsel; 50 = 4+ Karte; 60 = Farbwunsch
        switch(wert){
            case 20 -> kartenwert = "Aussetzen";
            case 30 -> kartenwert = "2+";
            case 40 -> kartenwert = "Richtungswechsel";
            case 50 -> kartenwert = "4+";
            case 60 -> kartenwert = "Farbwunsch";
            default -> kartenwert = String.valueOf(wert);
        }
        return kartenwert;
    }

    private void ziehen(Spieler s){
        Liste hk = s.getHandkarten();
        for(int i=0; i<ablagestapel.getZiehen(); i++){
            hk.hintenAnfuegen(spielkarten.karteZiehen(false));
        }
        ablagestapel.resetZiehen();
        s.setHandkarten(hk);
        spielzug(s);
    }

    private String kartenDialog(Spieler s) {
        String karte = (String) JOptionPane.showInputDialog(
                    new JFrame(),
                    "Welche Karte willst du legen? Ablagestapel: " + ablagestapel.getKarte().farbe().toString() + " " + kartenwertToString(ablagestapel.getKarte().kartenwert()),
                    "Karte legen",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    handkartenFeld(s),
                    s.getHandkarten().getErster().getInhalt().farbe().toString() + String.valueOf(s.getHandkarten().getErster().getInhalt().kartenwert())
            );
        return karte;
    }

    private void legen(Spieler s){
        Karte k = null;
        String karte = kartenDialog(s);
        if(karte == null){
            spielzug(s);
        }
        System.out.println(karte);
        k = spielkarten.stringZuKarte(karte);
        if(!istStapelbar(k)){
            legen(s);
        }
        ablagestapel.karteLegen(k);
        Liste hk = s.getHandkarten();
        hk.loeschen(k);
        s.setHandkarten(hk);

        //kartenwert: 0-9 Normalkarten; 20 = Aussetzen; 30 = 2+ Karte; 40 = Richtungswechsel; 50 = 4+ Karte; 60 = Farbwunsch
        switch (k.kartenwert()) {
            case 20: spielernr++; break; //Aussetzen
            case 30: ablagestapel.addZiehen(2); break; //2+
            case 40:
                if(spielerliste.getAnzahl() == 2){
                    spielernr++;
                }else{
                    uhrzeigersinn = !uhrzeigersinn;
                }
                break; //Richtungswechsel (= Aussetzen bei 2 Spielern)
            case 50: ablagestapel.addZiehen(4); break; //4+ //TODO: Farbwunsch abfragen
            case 60: break; //TODO: Farbwunsch abfragen
            default: break; //Karten 0-9, nichts tun
        }
        spielzug(s);
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
