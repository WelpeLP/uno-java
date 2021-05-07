public abstract class Datenelement {
    public abstract String spielername();
    public abstract int kartenwert();
    public abstract Karte.Kartenfarbe farbe();
    public abstract Liste getHandkarten();
    public abstract void setHandkarten(Liste kl);
}
