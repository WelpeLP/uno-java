public class Abschluss extends Listenelement{

    @Override
    public Listenelement getNaechster() {
        return null;
    }

    @Override
    public Listenelement hintenAnfuegen(Datenelement d) {
        return new Knoten(this, d);
    }

    @Override
    public int getAnzahl() {
        return 0;
    }

    @Override
    public Datenelement getInhalt() {
        return null;
    }

    @Override
    public Listenelement inhaltErsetzen(Datenelement vorher, Datenelement nachher) {
        System.out.println("Datenelement " + vorher.toString() + " nicht gefunden!");
        return this;
    }

    @Override
    public Listenelement loeschen(Datenelement d) {
        System.out.println("Datenelement " + d.toString() + " nicht gefunden!");
        return this;
    }
}
