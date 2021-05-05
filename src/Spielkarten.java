import java.util.List;

public class Spielkarten {
    private Liste kartenliste;

    public Spielkarten(){
        kartenliste = kartenInit();
    }

    public Liste getKartenliste(){
        return kartenliste;
    }

    private Liste kartenInit(){
        //kartenwert: 0-9 Normalkarten; 20 = Aussetzen; 30 = 2+ Karte; 40 = Richtungswechsel; 50 = 4+ Karte; 60 = Farbwunsch
        Liste kl = new Liste(new Abschluss());

        //Alle 0-9 Karten, alle Farben
        for(int i=0; i<10; i++){
            Karte k1 = new Karte(i, Karte.Kartenfarbe.BLAU, 2);
            Karte k2 = new Karte(i, Karte.Kartenfarbe.GRUEN, 2);
            Karte k3 = new Karte(i, Karte.Kartenfarbe.ROT, 2);
            Karte k4 = new Karte(i, Karte.Kartenfarbe.GELB, 2);
            kl.hintenAnfuegen(k1);
            kl.hintenAnfuegen(k2);
            kl.hintenAnfuegen(k3);
            kl.hintenAnfuegen(k4);
        }

        //Aussetzen, alle Farben
        Karte k5 = new Karte(20, Karte.Kartenfarbe.BLAU, 2);
        Karte k6= new Karte(20, Karte.Kartenfarbe.GRUEN, 2);
        Karte k7 = new Karte(20, Karte.Kartenfarbe.ROT, 2);
        Karte k8 = new Karte(20, Karte.Kartenfarbe.GELB, 2);
        kl.hintenAnfuegen(k5);
        kl.hintenAnfuegen(k6);
        kl.hintenAnfuegen(k7);
        kl.hintenAnfuegen(k8);

        //2Plus, alle Farben
        Karte k9 = new Karte(30, Karte.Kartenfarbe.BLAU, 2);
        Karte k10 = new Karte(30, Karte.Kartenfarbe.GRUEN, 2);
        Karte k11 = new Karte(30, Karte.Kartenfarbe.ROT, 2);
        Karte k12 = new Karte(30, Karte.Kartenfarbe.GELB, 2);
        kl.hintenAnfuegen(k9);
        kl.hintenAnfuegen(k10);
        kl.hintenAnfuegen(k11);
        kl.hintenAnfuegen(k12);

        //Richtungswechsel, alle Farben
        Karte k13 = new Karte(40, Karte.Kartenfarbe.BLAU, 2);
        Karte k14 = new Karte(40, Karte.Kartenfarbe.GRUEN, 2);
        Karte k15 = new Karte(40, Karte.Kartenfarbe.ROT, 2);
        Karte k16 = new Karte(40, Karte.Kartenfarbe.GELB, 2);
        kl.hintenAnfuegen(k13);
        kl.hintenAnfuegen(k14);
        kl.hintenAnfuegen(k15);
        kl.hintenAnfuegen(k16);

        //4Plus Karte
        Karte k17 = new Karte(50, Karte.Kartenfarbe.SCHWARZ, 4);
        kl.hintenAnfuegen(k17);

        //Farbwunsch Karte
        Karte k18 = new Karte(60, Karte.Kartenfarbe.SCHWARZ, 4);
        kl.hintenAnfuegen(k18);

        return kl;
    }

    public Karte zufallskarte(boolean nurZahlen) {
        int anzahl;
        if(nurZahlen){
            anzahl = 9 * 4;
        }else{
            anzahl = kartenliste.getAnzahl();
        }
        Listenelement l = kartenliste.getErster();
        boolean karteNichtVerfuegbar = true;
        while (karteNichtVerfuegbar) {
            int zufallszahl = (int) Math.floor(Math.random() * anzahl);
            for (int i = 0; i <= zufallszahl; i++) {
                l = l.getNaechster();
            }
            Karte k1 = (Karte) l.getInhalt();
            if (l.getInhalt().getAnzahl() > 0) {
                karteNichtVerfuegbar = false;
                Karte lNeu = new Karte(l.getInhalt().kartenwert(), l.getInhalt().farbe(), l.getInhalt().getAnzahl() - 1); //Neue Karte mit Anzahl-1
                kartenliste.inhaltErsetzen(l.getInhalt(), lNeu);
            }
        }
        return (Karte) l.getInhalt();
    }
}
