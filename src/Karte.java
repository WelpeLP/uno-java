public class Karte extends Datenelement{
    private int kartenwert; //0-9 Normalkarten; 20 = Aussetzen; 30 = 2+ Karte; 40 = 4+ Karte; 50 = Farbwunsch
    public enum Kartenfarbe{
        ROT, BLAU, GRUEN, GELB, SCHWARZ
    }
    private Kartenfarbe farbe;

    public Karte(int w, Kartenfarbe f){
        kartenwert = w;
        farbe = f;
    }

    @Override
    public String spielername() {
        System.out.println("Kein Spieler!");
        return null;
    }

    @Override
    public int kartenwert() {
        return kartenwert;
    }

    @Override
    public Kartenfarbe farbe() {
        return farbe;
    }

    @Override
    public Liste getHandkarten() {
        System.out.println("Kein Spieler!");
        return null;
    }

    @Override
    public void setHandkarten(Liste kl) {
        System.out.println("Kein Spieler!");
    }
}
