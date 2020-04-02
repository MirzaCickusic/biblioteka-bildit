import java.util.Scanner;

public class Main {

    /**
     * ZADATAK:
     * https://docs.google.com/document/d/1Li5pK7dyuh-hXBVG8Dd93PjF0T3e2erSDbJ1njDbOQ4/edit
     */

    public static void main(String[] args) {

        Scanner unos = new Scanner(System.in);

        Biblioteka biblioteka = new Biblioteka();
        Knjiga knjiga = new Knjiga();
        Racun racun = new Racun();
        Statistika transakcije = new Statistika();

        int korisnikovUnos = -2;


        while (korisnikovUnos != 0) {

            System.out.println("\nDobro došli u bibloteku! \n\nUnesite broj za opciju koju želite pokrenuti: \n- ako " +
                    "želite" +
                    " " +
                    "kreirati račun utipkajte 1\n- ako želite kreirati knjigu utipkajte 2\n- ako želite pozajmiti knjigu " +
                    "utipkajte 3 \n- ako želite vratiti posuđenu knjigu utipkajte 4 \n\n SA BROJEM -1 ZAUSAVLJATE " +
                    "PROGRAM!");

            int drugiKorisnikovUnos = unos.nextInt();

            korisnikovUnos = drugiKorisnikovUnos;
            if (korisnikovUnos == -1) {
                System.out.println("PROGRAM JE ZAUSTAVLJEN");
                break;
            }

            while (drugiKorisnikovUnos >= 1 || drugiKorisnikovUnos <= 4) {
                if (drugiKorisnikovUnos < 1 || drugiKorisnikovUnos > 4) {
                    System.out.println("Vaš unos nije u rasponu koji očekujemo! Unesite valjan broj: ");
                    drugiKorisnikovUnos = unos.nextInt();
                } else if (drugiKorisnikovUnos == 1) {
                    System.out.println("Unesite broj vašeg računa: ");
                    int brojKreiranogRacuna = unos.nextInt();
                    System.out.println("Unesite vaše ime: ");
                    String imeKreiranogRacuna = unos.next();
                    System.out.println("Unesite koliko knjiga želite pozajmiti: ");
                    int brojPosudjenihKnjigaZaKreiraniRacun =
                            unos.nextInt();

                    Racun racun0 = new Racun(brojKreiranogRacuna, imeKreiranogRacuna, brojPosudjenihKnjigaZaKreiraniRacun);

                    biblioteka.ubaciRacun(racun0);
                    System.out.println(racun0.toString());

                    break;
                } else if (drugiKorisnikovUnos == 2) {
                    System.out.println("Unesite broj knjige: ");
                    int brojKreiraneKnjige = unos.nextInt();
                    System.out.println("Unesite naziv knjige: ");
                    String nazivKreiraneKnjige = unos.next();
                    System.out.println("Unesite dostupnost knjige: ");
                    boolean dostupnostKreiraneKnjige = unos.nextBoolean();

                    Knjiga knjiga0 = new Knjiga(brojKreiraneKnjige, nazivKreiraneKnjige, dostupnostKreiraneKnjige);
                    biblioteka.kreirajKnjigu(knjiga0);
                    System.out.println(knjiga0.toString());

                    break;
                } else if (drugiKorisnikovUnos == 3) {
                    biblioteka.ispisiBrojeveIImenaRacuna();
                    biblioteka.ispisiBrojeveIImenaKnjiga();
                    System.out.println("\n\nUnesite broj računa koji posudjuje knjigu: ");
                    int brojRacunaKojiPosudjujeKnjigu = unos.nextInt();
                    System.out.println("Unesite broj knjige koju želite posuditi: ");
                    int brojKnjigeKojaSePosudjuje = unos.nextInt();
                    System.out.println("Napišite na koliko dana želite posuditi ovu knjigu: ");
                    int brojDanaNaKolikoSeKnjigaPosudjuje = unos.nextInt();

                    Statistika transakcija0 = new Statistika(brojRacunaKojiPosudjujeKnjigu, brojKnjigeKojaSePosudjuje, brojDanaNaKolikoSeKnjigaPosudjuje);
                    biblioteka.posudiKnjigu(transakcija0);
                    break;
                } else if (drugiKorisnikovUnos == 4) {
                    biblioteka.spisakSvihPosudbi();
                    System.out.println("\n\nUnesite vaš broj računa: ");
                    int brojRacunaKojiVracaKnjigu = unos.nextInt();
                    System.out.println("Unesite broj knjige koju vraćate: ");
                    int brojKnjigeKojaSeVraća = unos.nextInt();

                    biblioteka.vratiKnjigu(brojRacunaKojiVracaKnjigu, brojKnjigeKojaSeVraća);
                    biblioteka.ispisiBrojeveIImenaRacuna();
                    break;
                }
            }

        }


        /**
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
         **/

    }
}