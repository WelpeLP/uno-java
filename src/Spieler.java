public class Spieler extends Datenelement{
    private String spielername;
    private Liste handkarten;

    public Spieler(String name){
        spielername = name;
        handkarten = new Liste(new Abschluss());
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
    public Liste getHandkarten() {
        return handkarten;
        //return new Liste(new Abschluss());
    }

    @Override
    public void setHandkarten(Liste kl) {
        handkarten = kl;
    }

}
