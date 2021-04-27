public class Liste {
    private Listenelement erster;

    public Liste(Listenelement l){
        erster = l;
    }

    public void hintenAnfuegen(Datenelement d){
        erster = erster.hintenAnfuegen(d);
    }

    public int getAnzahl(){
        return erster.getAnzahl();
    }

    public Listenelement getErster(){
        return erster;
    }

    public void inhaltErsetzen(Datenelement vorher, Datenelement nachher){
        erster = erster.inhaltErsetzen(vorher, nachher);
    }
}
