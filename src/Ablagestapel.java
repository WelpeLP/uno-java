public class Ablagestapel {
    private Karte karte;
    private int ziehen;

    public Ablagestapel(Karte k){
        karte = k;
        ziehen = 0;
    }

    public Karte getKarte(){
        return karte;
    }

    public int getZiehen(){
        return ziehen;
    }
}
