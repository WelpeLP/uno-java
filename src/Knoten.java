public class Knoten extends Listenelement{
    private Listenelement naechster;
    private Datenelement inhalt;

    public Knoten(Listenelement l){
        naechster = l;
    }

    @Override
    public Listenelement getNaechster(){
        return naechster;
    }

    @Override
    public Listenelement hintenAnfuegen(Datenelement l) {
        naechster = naechster.hintenAnfuegen(l);
        return this;
    }

    @Override
    public int getAnzahl() {
        return 1 + naechster.getAnzahl();
    }

    @Override
    public Datenelement getInhalt() {
        return inhalt;
    }
}
