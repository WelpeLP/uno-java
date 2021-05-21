public class Betrieb {

    public static void main(String[] args){
        Fenster.oeffnen();
        //test();
    }

    public void test(){
        Liste spieler = new Liste(new Abschluss());

        spieler.hintenAnfuegen(new Spieler("Thomas"));
        spieler.hintenAnfuegen(new Spieler("Anne"));
        spieler.hintenAnfuegen(new Spieler("John"));
        spieler.hintenAnfuegen(new Spieler("Kim"));
        Gamemaster gamemaster = new Gamemaster(spieler);

        Spielkarten spielkarten = new Spielkarten();
        //Karte k = spielkarten.karteZiehen(false);
        //System.out.println(k.farbe() + " " + k.kartenwert());
        //spielkarten.kartenlisteAusgeben();
        Spieler s = (Spieler) spieler.getErster().getInhalt();
        Liste hk = s.getHandkarten();
        for (int i=0; i<7; i++) {
            hk.hintenAnfuegen(spielkarten.karteZiehen(false));
        }
        s.setHandkarten(hk);
        gamemaster.spielzug(s);
        spieler.getErster().getInhalt().getHandkarten().listeAusgeben();
    }
}
