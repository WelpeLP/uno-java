public class Knoten extends Listenelement{
    private Listenelement naechster;
    private Datenelement inhalt;

    public Knoten(Listenelement l, Datenelement i){
        naechster = l;
        inhalt = i;
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

    @Override
    public Listenelement inhaltErsetzen(Datenelement vorher, Datenelement nachher) {
        if(vorher == inhalt){
            inhalt = nachher;
        }else{
            naechster = naechster.inhaltErsetzen(vorher, nachher);
        }
        return this;
    }
}
