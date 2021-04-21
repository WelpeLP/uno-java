public class Karte extends Datenelement{
    private int kartenwert; //0-9 Normalkarten; 20 = Aussetzen; 30 = 2+ Karte; 40 = 4+ Karte; 50 = Farbwunsch
    public enum Kartenfarbe{
        ROT, BLAU, GRUEN, GELB, SCHWARZ
    }
    private Kartenfarbe farbe;
    private int anzahl;

    public Karte(int w, Kartenfarbe f, int a){
        kartenwert = w;
        farbe = f;
        anzahl = a;
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
}
