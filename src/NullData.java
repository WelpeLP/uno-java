public class NullData extends Datenelement{
    @Override
    public String spielername() {
        return null;
    }

    @Override
    public int kartenwert() {
        return -1;
    }

    @Override
    public Karte.Kartenfarbe farbe() {
        return null;
    }

    @Override
    public int getAnzahl() {
        return -1;
    }
}
