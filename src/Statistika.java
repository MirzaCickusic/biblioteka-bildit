import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Statistika {

    private int brojRacuna;
    private int brojKnjige;
    private Date date;
    private int brojDana;


    public Statistika(int brojRacuna, int brojKnjige, int brojDana) {
        this.brojKnjige = brojKnjige;
        this.brojRacuna = brojRacuna;
        this.brojDana = brojDana;
        date = new Date(System.currentTimeMillis());

    }

    public int getBrojRacuna() {
        return brojRacuna;
    }


    public int getBrojKnjige() {
        return brojKnjige;
    }

    public boolean getStatusKnjige(){
        Knjiga knjiga = new Knjiga();
        boolean statusKnjige = knjiga.getStatusKnjige();
        return statusKnjige;
    }

    public Date getDate() {
        return date;
    }

    public int getBrojDana() {
        return brojDana;
    }

    @Override
    public String toString() {
        return "\n\nNajam se desio na datum " + date + ", broj računa koji je iznajmio knjigu je " + brojRacuna +
                " i broj knjige koja je iznajmljena je " + brojKnjige + ". Ovaj kupac bi trebao da vrati knjigu za " + brojDana + " dana!";
    }
}
