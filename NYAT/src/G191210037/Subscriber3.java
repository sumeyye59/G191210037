package G191210037;

public class Subscriber3 implements IObserver{
    private IEkran ekran;
    public Subscriber3(){
        ekran=new Ekran();

    }
    @Override
    public void update(int sicaklik) {
        ekran.mesajGoruntule("Abone3:Sicaklik goruntuleme birimine gonderiliyor..");
        ekran.mesajGoruntule("Sicaklik degeri:");
        ekran.degerGoruntule(sicaklik);
    }

}
