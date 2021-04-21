public class Spieler extends Datenelement{
    @Override
    public String spielername() {
        return null;
    }

    @Override
    public int kartenwert() {
        System.out.println("Keine Karte!");
        return -1;
    }

    @Override
    public Karte.Kartenfarbe farbe() {
        System.out.println("Keine Karte!");
        return null;
    }
}
