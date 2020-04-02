import java.util.Date;

public class Racun {

    private int brojRacuna;
    private int brojKnjiga;
    private int brojPosudjenihKnjiga = 0;
    private String imeMusterije;
    private Date datum;

    public Racun() {

    }

    public Racun(int brojRacuna, String imeMusterije, int brojKnjiga) {
        this.brojRacuna = brojRacuna;
        this.imeMusterije = imeMusterije;
        this.brojKnjiga = brojKnjiga;
        this.datum = new java.util.Date();

        brojPosudjenihKnjiga = this.brojKnjiga + brojKnjiga;
        if (brojPosudjenihKnjiga > 4) {
            System.out.println("Dozvoljeno je imati ne više od 3 posuđene knjige! Promjenite vaš unos.");
        }

    }

    public int getBrojRacuna() {
        return brojRacuna;
    }

    public String getImeMusterije() {
        return imeMusterije;
    }

    public int getBrojKnjiga() {
        return brojKnjiga;
    }

    public int getBrojPosudjenihKnjiga() {
        return brojPosudjenihKnjiga;
    }

    public Date getDatum() {
        return datum;
    }

    public void povecajBrojIzdatihKnjiga(){
        brojPosudjenihKnjiga++;
    }
    public void smanjiBrojIzdatihKnjiga(){
        brojPosudjenihKnjiga--;
    }

    @Override
    public String toString() {
        return "Broj ovog računa je " + brojRacuna + ". Račun je napravljen na datum " + datum +
                ", a broj iznajmljenih knjiga za ovaj račun je: " + brojPosudjenihKnjiga + ". Ime nosioca računa je: " + imeMusterije;
    }
}
