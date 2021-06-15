import java.util.List;

public class Spielkarten {
    private Karte[] kartenliste;
    private int[] kartenanzahl;

    public Spielkarten(){
        kartenliste = new Karte[54];
        kartenanzahl = new int[54];
        kartenInit();
    }

    private void kartenInit(){
        //kartenwert: 0-9 Normalkarten; 20 = Aussetzen; 30 = 2+ Karte; 40 = Richtungswechsel; 50 = 4+ Karte; 60 = Farbwunsch

        //Alle 0-9 Karten, alle Farben
        for(int i=0; i<10; i++){
            Karte k1 = new Karte(i, Karte.Kartenfarbe.BLAU);
            kartenliste[i] = k1;
            kartenanzahl[i] = 2;
        }
        for(int i=10; i<20; i++){
            Karte k2 = new Karte(i-10, Karte.Kartenfarbe.GRUEN);
            kartenliste[i] = k2;
            kartenanzahl[i] = 2;
        }
        for(int i=20; i<30; i++){
            Karte k3 = new Karte(i-20, Karte.Kartenfarbe.ROT);
            kartenliste[i] = k3;
            kartenanzahl[i] = 2;
        }
        for(int i=30; i<40; i++){
            Karte k4 = new Karte(i-30, Karte.Kartenfarbe.GELB);
            kartenliste[i] = k4;
            kartenanzahl[i] = 2;
        }

        //Aussetzen, alle Farben
        Karte k5 = new Karte(20, Karte.Kartenfarbe.BLAU);
        kartenliste[40] = k5;
        kartenanzahl[40] = 2;
        Karte k6 = new Karte(20, Karte.Kartenfarbe.GRUEN);
        kartenliste[41] = k6;
        kartenanzahl[41] = 2;
        Karte k7 = new Karte(20, Karte.Kartenfarbe.ROT);
        kartenliste[42] = k7;
        kartenanzahl[42] = 2;
        Karte k8 = new Karte(20, Karte.Kartenfarbe.GELB);
        kartenliste[43] = k8;
        kartenanzahl[43] = 2;

        //2Plus, alle Farben
        Karte k9 = new Karte(30, Karte.Kartenfarbe.BLAU);
        kartenliste[44] = k9;
        kartenanzahl[44] = 2;
        Karte k10 = new Karte(30, Karte.Kartenfarbe.GRUEN);
        kartenliste[45] = k10;
        kartenanzahl[45] = 2;
        Karte k11 = new Karte(30, Karte.Kartenfarbe.ROT);
        kartenliste[46] = k11;
        kartenanzahl[46] = 2;
        Karte k12 = new Karte(30, Karte.Kartenfarbe.GELB);
        kartenliste[47] = k12;
        kartenanzahl[47] = 2;

        //Richtungswechsel, alle Farben
        Karte k13 = new Karte(40, Karte.Kartenfarbe.BLAU);
        kartenliste[48] = k13;
        kartenanzahl[48] = 2;
        Karte k14 = new Karte(40, Karte.Kartenfarbe.GRUEN);
        kartenliste[49] = k14;
        kartenanzahl[49] = 2;
        Karte k15 = new Karte(40, Karte.Kartenfarbe.ROT);
        kartenliste[50] = k15;
        kartenanzahl[50] = 2;
        Karte k16 = new Karte(40, Karte.Kartenfarbe.GELB);
        kartenliste[51] = k16;
        kartenanzahl[51] = 2;

        //4Plus Karte
        Karte k17 = new Karte(50, Karte.Kartenfarbe.SCHWARZ);
        kartenliste[52] = k17;
        kartenanzahl[52] = 4;

        //Farbwunsch Karte
        Karte k18 = new Karte(60, Karte.Kartenfarbe.SCHWARZ);
        kartenliste[53] = k18;
        kartenanzahl[53] = 4;
    }

    public void kartenlisteAusgeben() {
        for(int i=0; i < kartenliste.length; i++){
            System.out.println(kartenliste[i].farbe() + " " + kartenliste[i].kartenwert() + " " + kartenanzahl[i]);
        }
    }

    public Karte karteZiehen(boolean nurZahlen) {
        int anzahl;
        //nurZahlen: wird am Anfang des Spiels verwendet
        if(nurZahlen){
            anzahl = 9 * 4;
        }else{
            anzahl = 54;
        }
        Karte k = null;
        int kAnzahl;

        //zufällige Karte finden, die noch gezogen werden kann
        boolean karteNichtVerfuegbar = true;
        while (karteNichtVerfuegbar) {
            int zufallszahl = (int) Math.floor(Math.random() * anzahl);
            k = kartenliste[zufallszahl];
            kAnzahl = kartenanzahl[zufallszahl];
            if (kAnzahl > 0) {
                karteNichtVerfuegbar = false;
                kartenanzahl[zufallszahl]--;
            }
        }
        return k;
    }

    //String, der eine Karte beschreibt, wieder zu dieser zurückkonvertieren
    //Anwendung: Auswahl der Karte im JOptionPane, der diese als String ausgibt, wieder in Datentyp Karte darzustellen
    public Karte stringZuKarte(String s){
        for(int i=0; i<kartenliste.length; i++){
            String kartenstring = kartenliste[i].farbe().toString() + " " + kartenwertToString(kartenliste[i].kartenwert());
            if(kartenstring.equals(s)){
                return kartenliste[i];
            }
        }
        System.out.println("Karte nicht gefunden!");
        return null;
    }

    //Funktion, um gespeicherten Werte einer Karte (siehe nächster Kommentar) lesbar zu machen
    public String kartenwertToString(int wert){
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

    //Handkarten eines Spielers in ein Feld umwandeln: Kartenauswahl im JOptionPane.showInputDialog
    public String[] handkartenFeld(Spieler s){
        int anzahl = s.getHandkarten().getAnzahl();
        Listenelement l = s.getHandkarten().getErster();
        String[] feld = new String[anzahl];
        for(int i=0; i<anzahl; i++){
            feld[i] = l.getInhalt().farbe().toString() + " " + kartenwertToString(l.getInhalt().kartenwert());
            l = l.getNaechster();
        }
        return feld;
    }

    //Funktion, ein Feld als einen String auszugeben.
    //Anwendung: Handkarten eines Spielers im Fenster ausgeben.
    public String stringfeldZuString(String[] feld){
        String feldstring = "";
        for(int i=0; i<feld.length-1; i++){
            feldstring += feld[i] + ", ";
        }
        feldstring += feld[feld.length-1];
        return feldstring;
    }
}
