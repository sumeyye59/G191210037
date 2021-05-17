package G191210037;

public class Subscriber1 implements IObserver{
    private IEkran ekran;
    public Subscriber1(){
        ekran=new Ekran();

    }
    @Override
    public void update(int sicaklik) {
        ekran.mesajGoruntule("Abone1:Anormal durum tespiti yapiliyor..\n");

        if(sicaklik>50){

            ekran.mesajGoruntule("Sicaklik kritik seviyede!\n");
        }
        else{
            ekran.mesajGoruntule("Sicaklik seviyesi normal.\n");
        }
    }

}
