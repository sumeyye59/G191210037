package G191210037;

public class SogutucuKapatma implements IIslem{

    private IEkran ekran;

    private IMerkeziIslemBirimi merkeziIslemBirimi;
    public SogutucuKapatma( IEkran ekran, IMerkeziIslemBirimi merkeziIslemBirimi) {

        this.ekran = ekran;
        this.merkeziIslemBirimi=merkeziIslemBirimi;
    }
    @Override
    public void islemYap() {
        ekran.mesajGoruntule("sogutucu kapatma işlemini seçtiniz");
        merkeziIslemBirimi.eyleyiciyeGonder(3);

    }
}
