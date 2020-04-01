public class Knjiga {

    private int brojKnjige;
    private String imeKnjige;
    private boolean statusKnjige;

    public Knjiga() {

    }

    public Knjiga(int brojKnjige, String imeKnjige, boolean statusKnjige) {
        this.brojKnjige = brojKnjige;
        this.imeKnjige = imeKnjige;
        this.statusKnjige = statusKnjige;
    }

    public int getBrojKnjige() {
        return brojKnjige;
    }

    public String getImeKnjige() {
        return imeKnjige;
    }

    public boolean getStatusKnjige() {
        return statusKnjige;
    }

    public void izdajKnjigu() {
        statusKnjige = false;
    }

    public void vratiKnjigu() {
        statusKnjige = true;
    }

    @Override
    public String toString() {
        return "Podaci za ovu knjigu su\n" + "Broj knjige: " + brojKnjige + "\nNaziv knjige: \"" + imeKnjige + "\"" + "\nDa li je knjiga dostupna na stanju: " + statusKnjige;
    }


}
