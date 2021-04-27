public class Gamemaster {
    private Ablagestapel ablagestapel;
    private Liste spielerliste;
    private boolean uhrzeigersinn;

    public Gamemaster(Liste s){
        spielerliste = s;
        uhrzeigersinn = true;

        //TODO: Zufällige Karte zuweisen
        //ablagestapel = new Ablagestapel();
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
