public class Ablagestapel {
    private Karte karte;
    private int ziehen;

    public Ablagestapel(Karte k){
        karte = k;
        ziehen = 1;
    }

    public Karte getKarte(){
        return karte;
    }

    public void karteLegen(Karte k){
        karte = k;
    }

    public int getZiehen(){
        return ziehen;
    }

    public void addZiehen(int z){
        ziehen += z;
    }

    public void resetZiehen(){
        ziehen = 1;
    }
}
