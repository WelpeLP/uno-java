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

    public void addZiehen(int z){
        ziehen += z;
    }

    public Karte zufallskarte(Liste kl, boolean nurZahlen) {
        int anzahl = kl.getAnzahl();
        Listenelement l = kl.getErster();
        boolean karteNichtVerfuegbar = true;
        while (karteNichtVerfuegbar) {
            int zufallszahl = (int) Math.floor(Math.random() * anzahl);
            for (int i = 0; i <= zufallszahl; i++) {
                l = l.getNaechster();
            }
            if (l.getInhalt().getAnzahl() > 0) {
                karteNichtVerfuegbar = false;
                //TODO: int anzahl - 1!
            }
        }
        return (Karte) l.getInhalt();
    }
}
