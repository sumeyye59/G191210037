package G191210037;

public class SogutucuAcma implements IIslem{
    private IEkran ekran;

    private IMerkeziIslemBirimi merkeziIslemBirimi;
    public SogutucuAcma( IEkran ekran, IMerkeziIslemBirimi merkeziIslemBirimi) {

        this.ekran = ekran;
        this.merkeziIslemBirimi=merkeziIslemBirimi;
    }
    @Override
    public void islemYap() {
        ekran.mesajGoruntule("sogutucu acma işlemini seçtiniz");
        merkeziIslemBirimi.eyleyiciyeGonder(2);

    }
}
