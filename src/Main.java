import java.sql.Date;

public class Main {

    /**
     * ZADATAK:
     * https://docs.google.com/document/d/1Li5pK7dyuh-hXBVG8Dd93PjF0T3e2erSDbJ1njDbOQ4/edit
     */

    public static void main(String[] args) {

        Biblioteka biblioteka = new Biblioteka();

        Racun racun0 = new Racun(0, "Mirza", 0); //Kreiranje računa
        Racun racun1 = new Racun(1, "Almir", 0);


        biblioteka.ubaciRacun(racun0); //Ubacivanje računa u bibloteku
        biblioteka.ubaciRacun(racun1);


        Knjiga knjiga0 = new Knjiga(0, "Knjiga 0", true); //Kreiranje knjige

        biblioteka.kreirajKnjigu(knjiga0); //Ubacivanje knjige u bibloteku


        Statistika posudiKnjigu0 = new Statistika(0, 0, 5); //Posuđivanje Knjige

        biblioteka.posudiKnjigu(posudiKnjigu0); //Ubacivanje posudbe u popis svih posudbi, mjenja status knjige i
        // povećava broj posuđenih knjiga za račun

        System.out.println("\nBroj posuđenih knjiga za ovaj račun: " + racun0.getBrojPosudjenihKnjiga()); //Broj
        // posuđenih knjiga za račun
        System.out.println("\nStatus posuđene knjige je sada: " + knjiga0.getStatusKnjige()); //Status posuđene
        // knjige prije posudbe
        System.out.println(posudiKnjigu0.toString()); //Status posuđene knjige poslije posudbe

        biblioteka.vratiKnjigu(0, 0); //Knjiga je vraćena u bibloteku
        System.out.println("\nStatus posuđene knjige je sada: " + knjiga0.getStatusKnjige()); //Status knjige poslije
        // vraćanja


        Knjiga knjiga1 = new Knjiga(1, "Knjiga 1", true);
        Knjiga knjiga2 = new Knjiga(2, "Knjiga 2", true);
        Knjiga knjiga3 = new Knjiga(3, "Knjiga 3", true);
        Knjiga knjiga4 = new Knjiga(4, "Knjiga 3", true);

        biblioteka.kreirajKnjigu(knjiga1);
        biblioteka.kreirajKnjigu(knjiga2);
        biblioteka.kreirajKnjigu(knjiga3);
        biblioteka.kreirajKnjigu(knjiga4);


        Statistika posudiKnjigu1 = new Statistika(0, 0, 5);
        Statistika posudiKnjigu2 = new Statistika(0, 1, 5);
        Statistika posudiKnjigu3 = new Statistika(0, 2, 5);
        Statistika posudiKnjigu4 = new Statistika(0, 3, 5);

        Statistika posudiKnjigu5 = new Statistika(1, 2, 5);

        Statistika posudiKnjigu6 = new Statistika(3, 2, 5);


        biblioteka.posudiKnjigu(posudiKnjigu1);
        biblioteka.posudiKnjigu(posudiKnjigu2);
        biblioteka.posudiKnjigu(posudiKnjigu3);
        biblioteka.posudiKnjigu(posudiKnjigu4); //Račun već ima 3 posuđene knjige
        biblioteka.posudiKnjigu(posudiKnjigu5); //Knjiga je već posuđena
        biblioteka.posudiKnjigu(posudiKnjigu6); //Broj računa ili broj knjige ne postoji u bibloteci, stoga sistem
        // ispisuje sve račune i sve knjige koje postoje i njihovu dostupnost

        System.out.println(posudiKnjigu1.toString()); //Metoda ispisuje detalje ove posudbe

        biblioteka.ispisiBrojeveIImenaRacuna(); //Ispisuje detalje postojećih računa



    }
}