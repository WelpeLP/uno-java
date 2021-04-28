public class Spieler extends Datenelement{
    private String spielername;
    public Spieler(String name){
        spielername = name;
    }

    @Override
    public String spielername() {
        return spielername;
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

    @Override
    public int getAnzahl() {
        System.out.println("Keine Karte!");
        return -1;
    }
}
