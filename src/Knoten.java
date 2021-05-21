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
    public Listenelement hintenAnfuegen(Datenelement d) {
        naechster = naechster.hintenAnfuegen(d);
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

    @Override
    public Listenelement loeschen(Datenelement d) {
        if(inhalt == d){
            return naechster;
        }else{
            naechster = naechster.loeschen(d);
            return this;
        }
    }
}
