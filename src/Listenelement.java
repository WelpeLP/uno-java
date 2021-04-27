public abstract class Listenelement {
    public abstract Listenelement getNaechster();
    public abstract Listenelement hintenAnfuegen(Datenelement l);
    public abstract int getAnzahl();
    public abstract Datenelement getInhalt();
    public abstract Listenelement inhaltErsetzen(Datenelement vorher, Datenelement nachher);
}
