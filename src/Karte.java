public class Karte extends Datenelement{
    private int kartenwert; //0-9 Normalkarten; 20 = Aussetzen; 30 = 2+ Karte; 40 = 4+ Karte; 50 = Farbwunsch
    private String kartenfarbe;

    public Karte(int wert, String farbe){
        kartenwert = wert;
        kartenfarbe = farbe;
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
    public String farbe() {
        return kartenfarbe;
    }
}
