public class Betrieb {

    public static void main(String[] args){
        Liste spieler = new Liste(new Abschluss());
        spieler.hintenAnfuegen(new Spieler("Thomas"));
        spieler.hintenAnfuegen(new Spieler("Anne"));
        spieler.hintenAnfuegen(new Spieler("John"));
        spieler.hintenAnfuegen(new Spieler("Kim"));
        Gamemaster gamemaster = new Gamemaster(spieler);
    }
}
