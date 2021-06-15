public class Ablagestapel {
    private Karte karte;
    private int ziehen;
    private Karte.Kartenfarbe wunsch;

    public Ablagestapel(Karte k){
        karte = k;
        ziehen = 1;
        wunsch = Karte.Kartenfarbe.SCHWARZ;
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
        if(ziehen == 1){
            ziehen = 0;
        }
        ziehen += z;
    }

    public void resetZiehen(){
        ziehen = 1;
    }

    public void setFarbwunsch(Karte.Kartenfarbe f){
        wunsch = f;
    }

    public Karte.Kartenfarbe getFarbwunsch(){
        return wunsch;
    }
}
