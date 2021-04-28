public class Gamemaster {
    private Ablagestapel ablagestapel;
    private Liste spielerliste;
    private Spielkarten spielkarten;
    private boolean uhrzeigersinn;

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
}
