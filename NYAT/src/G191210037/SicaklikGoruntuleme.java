package G191210037;

public class SicaklikGoruntuleme implements IIslem{
    private IEkran ekran;
    private IMerkeziIslemBirimi merkeziIslemBirimi;
    public SicaklikGoruntuleme( IEkran ekran, IMerkeziIslemBirimi merkeziIslemBirimi) {

        this.ekran = ekran;
        this.merkeziIslemBirimi=merkeziIslemBirimi;
    }
    @Override
    public void islemYap() {
        ekran.mesajGoruntule("sıcaklık görüntüleme işlemini seçtiniz");
        merkeziIslemBirimi.sicaklikAlgilayiciyaGonder();

        }


}
