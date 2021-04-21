public class Abschluss extends Listenelement{

    @Override
    public Listenelement getNaechster() {
        return null;
    }

    @Override
    public Listenelement hintenAnfuegen(Datenelement l) {
        return new Knoten(this);
    }

    @Override
    public int getAnzahl() {
        return 0;
    }
}
