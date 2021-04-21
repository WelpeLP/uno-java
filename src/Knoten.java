public class Knoten extends Listenelement{
    private Knoten naechster;

    public Knoten(Knoten l){
        naechster = l;
    }

    @Override
    public Knoten getNaechster(){
        return naechster;
    }
}
