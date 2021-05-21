public abstract class Listenelement {
    public abstract Listenelement getNaechster();
    public abstract Listenelement hintenAnfuegen(Datenelement d);
    public abstract int getAnzahl();
    public abstract Datenelement getInhalt();
    public abstract Listenelement inhaltErsetzen(Datenelement vorher, Datenelement nachher);
    public abstract Listenelement loeschen(Datenelement d);
}
