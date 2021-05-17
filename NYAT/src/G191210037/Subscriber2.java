package G191210037;

public class Subscriber2 implements IObserver {
    private IEkran ekran;
    public Subscriber2(){
        ekran=new Ekran();

    }

        @Override
        public void update(int sicaklik) {

            ekran.mesajGoruntule("Abone2:");
        ekran.mesajGoruntule("Sicaklik veritabanina kaydedildi..\n");
        }
}
