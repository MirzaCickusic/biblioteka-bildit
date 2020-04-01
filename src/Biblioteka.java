import java.util.ArrayList;
import java.util.Date;

public class Biblioteka {

    ArrayList<Racun> listaRacuna = new ArrayList<>();
    ArrayList<Knjiga> listaKnjiga = new ArrayList<>();
    ArrayList<Statistika> listaStatistike = new ArrayList<>();

    public Biblioteka() {

    }

    public void getlistaRacuna() {
        System.out.println(listaRacuna.isEmpty());
    }

    public void ubaciRacun(Racun kupac) {
        if (kupac.getBrojRacuna() < 0) {
            System.out.println("\nBroj računa ne smije biti negativan broj. Unesite pozitivan broj računa!");
            return;
        }
        for (int i = 0; i < listaRacuna.size(); i++) {

            Racun racun = listaRacuna.get(i);
            int brojRacuna = racun.getBrojRacuna();

            if (brojRacuna == kupac.getBrojRacuna()) {
                System.out.println("\nVeć postoji taj broj računa! Morate unijeti drugi broj.");
                return;
            }
        }
        listaRacuna.add(kupac);
        System.out.println("Kupac " + kupac.getImeMusterije() + " je dodan u Biblioteku!");
    }

    public void kreirajKnjigu(Knjiga knjiga) {
        if (knjiga.getBrojKnjige() < 0) {
            System.out.println("\nBroj knjige ne smije biti negativan broj. Unesite pozitivan broj knjige!");
            return;
        }
        for (int i = 0; i < listaKnjiga.size(); i++) {

            Knjiga knjigaID = listaKnjiga.get(i);
            int brojKnjige = knjigaID.getBrojKnjige();

            if (brojKnjige == knjiga.getBrojKnjige()) {
                System.out.println("\nVeć postoji knjiga sa tim brojem! Morate unijeti drugi broj.");
                return;
            }
        }
        listaKnjiga.add(knjiga);
        System.out.println("\nKnjiga \"" + knjiga.getImeKnjige() + "\" je dodata!");
    }

    public void ispisiBrojeveIImenaRacuna() {
        System.out.print("\n\nSvi brojevi i imena računa koji se nalaze u bibloteci su: ");
        for (int i = 0; i < listaRacuna.size(); i++) {
            System.out.print("\n - " + listaRacuna.get(i).toString());

        }
    }

    public void ispisiBrojeveIImenaKnjiga() {
        System.out.print("\n\nDetalji svih knjiga u bibloteci su:\n");
        for (int i = 0; i < listaKnjiga.size(); i++) {
            System.out.print("\n - " + listaKnjiga.get(i).toString());

        }
    }

    public void spisakSvihPosudbi() {
        System.out.println("\n\nSve transakcije koje su se desile u bibloteci:");
        for (int i = 0; i < listaStatistike.size(); i++) {
            System.out.print(listaStatistike.get(i).toString());
        }
    }


    public void posudiKnjigu(Statistika stats) {

        for (int s = 0; s < listaRacuna.size(); s++) {
            Racun racun = listaRacuna.get(s);
            int brojRacuna = racun.getBrojRacuna();
            if (brojRacuna == stats.getBrojRacuna()) {
                if (racun.getBrojPosudjenihKnjiga() > 2) {
                    System.out.println("\nOvaj račun ima već posuđene tri knjige! ");
                    return;
                }
                for (int d = 0; d < listaKnjiga.size(); d++) {
                    Knjiga knjiga = listaKnjiga.get(d);
                    int brojKnjige = knjiga.getBrojKnjige();
                    if (brojKnjige == stats.getBrojKnjige()) {
                        if (!knjiga.getStatusKnjige()) {
                            System.out.println("\nŽao nam je ali knjiga je već posuđena! ");
                            return;
                        }
                        if (knjiga.getStatusKnjige()) {
                            racun.povecajBrojIzdatihKnjiga();
                            knjiga.izdajKnjigu();
                            listaStatistike.add(stats);
                            System.out.println("\nKNJIGA JE USPJEŠNO POSUĐENA!");
                            return;
                        }
                    }
                }
            }
        }

        System.out.println("\nUneseni broj knjige i broj računa nije važeći. Odnosno ne postoji u sistemu bibloteke! ");
        System.out.println("Molimo da vas da pogledate sadržaj bibloteke te da obarete račun i knjigu koja je u " +
                "sistemu: ");
        ispisiBrojeveIImenaRacuna();
        ispisiBrojeveIImenaKnjiga();

        return;

    }

    public void vratiKnjigu(int brojRacuna, int brojKnjige) {


        for (int i = 0; i < listaKnjiga.size(); i++) {
            Knjiga knjigaID = listaKnjiga.get(i);
            int stanjeKnjige = knjigaID.getBrojKnjige();
            if (brojKnjige == stanjeKnjige) {
                knjigaID.vratiKnjigu();
            }
        }
        for (int a = 0; a < listaRacuna.size(); a++) {
            Racun racun = listaRacuna.get(a);
            int brojUnesenogRacuna = racun.getBrojRacuna();
            if (brojRacuna == brojUnesenogRacuna) {
                racun.smanjiBrojIzdatihKnjiga();
            }
        }
    }


}
