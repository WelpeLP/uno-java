public class Gamemaster {
    private Ablagestapel ablagestapel;
    private Liste spielerliste;
    private Spielkarten spielkarten;
    private boolean uhrzeigersinn, spielstopp;
    private int spielernr;

    public Gamemaster(Liste s){
        spielerliste = s;
        uhrzeigersinn = true;
        spielkarten = new Spielkarten();

        //TODO: Zufällige Karte zuweisen
        ablagestapel = new Ablagestapel(spielkarten.zufallskarte(true));
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
                }else(spielernr > spielerliste.getAnzahl()) {
                    spielernr = 1;
                }
            }else{
                spielernr--;
                if(spielernr == -1) {
                    spielernr = spielerliste.getAnzahl() - 1;
                }else(spielernr < -1) {
                    spielernr = spielerliste.getAnzahl() - 2;
                }
            }
        }
    }

    public void spielzug(Spieler s){
        Karte k;
        //warten, bis karte ausgewählt und istStapelbar(k); k = ausgewählte Karte
        //karte legen
        //karte bei Spieler - 1

        switch (k.kartenwert()) {
            case 20: spielernr++; break; //Aussetzen
        }
    }

    public void spielabschluss(){

    }
}
