public class Liste{
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

    public void loeschen(Datenelement d){
        erster = erster.loeschen(d);
    }

    public void listeAusgeben(){
        int anzahl = getAnzahl();
        Listenelement l = getErster();
        for (int i=0; i<anzahl; i++){
            System.out.println(l.getInhalt().farbe().toString() + l.getInhalt().kartenwert());
            l = l.getNaechster();
        }
    }
}
