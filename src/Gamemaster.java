public class Gamemaster {
    private Ablagestapel ablagestapel;
    private Liste kartenliste, spielerliste;
    private boolean uhrzeigersinn;

    public Gamemaster(Liste s){
        spielerliste = s;
        kartenliste = new Liste(new Abschluss());
        uhrzeigersinn = true;

        //TODO: Zufällige Karte zuweisen
        //ablagestapel = new Ablagestapel();
    }

    private void kartenInit(){
        //kartenwert: 0-9 Normalkarten; 20 = Aussetzen; 30 = 2+ Karte; 40 = Richtungswechsel; 50 = 4+ Karte; 60 = Farbwunsch

        //Alle 0-9 Karten, alle Farben
        for(int i=0; i<10; i++){
            Karte k1 = new Karte(i, Karte.Kartenfarbe.BLAU, 2);
            Karte k2 = new Karte(i, Karte.Kartenfarbe.GRUEN, 2);
            Karte k3 = new Karte(i, Karte.Kartenfarbe.ROT, 2);
            Karte k4 = new Karte(i, Karte.Kartenfarbe.GELB, 2);
            kartenliste.hintenAnfuegen(k1);
            kartenliste.hintenAnfuegen(k2);
            kartenliste.hintenAnfuegen(k3);
            kartenliste.hintenAnfuegen(k4);
        }

        //Aussetzen, alle Farben
        Karte k5 = new Karte(20, Karte.Kartenfarbe.BLAU, 2);
        Karte k6= new Karte(20, Karte.Kartenfarbe.GRUEN, 2);
        Karte k7 = new Karte(20, Karte.Kartenfarbe.ROT, 2);
        Karte k8 = new Karte(20, Karte.Kartenfarbe.GELB, 2);
        kartenliste.hintenAnfuegen(k5);
        kartenliste.hintenAnfuegen(k6);
        kartenliste.hintenAnfuegen(k7);
        kartenliste.hintenAnfuegen(k8);

        //2Plus, alle Farben
        Karte k9 = new Karte(30, Karte.Kartenfarbe.BLAU, 2);
        Karte k10 = new Karte(30, Karte.Kartenfarbe.GRUEN, 2);
        Karte k11 = new Karte(30, Karte.Kartenfarbe.ROT, 2);
        Karte k12 = new Karte(30, Karte.Kartenfarbe.GELB, 2);
        kartenliste.hintenAnfuegen(k9);
        kartenliste.hintenAnfuegen(k10);
        kartenliste.hintenAnfuegen(k11);
        kartenliste.hintenAnfuegen(k12);

        //Richtungswechsel, alle Farben
        Karte k13 = new Karte(40, Karte.Kartenfarbe.BLAU, 2);
        Karte k14 = new Karte(40, Karte.Kartenfarbe.GRUEN, 2);
        Karte k15 = new Karte(40, Karte.Kartenfarbe.ROT, 2);
        Karte k16 = new Karte(40, Karte.Kartenfarbe.GELB, 2);
        kartenliste.hintenAnfuegen(k13);
        kartenliste.hintenAnfuegen(k14);
        kartenliste.hintenAnfuegen(k15);
        kartenliste.hintenAnfuegen(k16);

        //4Plus Karte
        Karte k17 = new Karte(50, Karte.Kartenfarbe.SCHWARZ, 4);
        kartenliste.hintenAnfuegen(k17);

        //Farbwunsch Karte
        Karte k18 = new Karte(60, Karte.Kartenfarbe.SCHWARZ, 4);
        kartenliste.hintenAnfuegen(k18);
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
}
