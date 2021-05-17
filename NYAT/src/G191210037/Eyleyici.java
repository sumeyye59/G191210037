package G191210037;

public class Eyleyici implements IEyleyici{
    private IEkran ekran;
public Eyleyici(){
    ekran=new Ekran();


}
    @Override
public void sogutucuAc(){
       ekran.mesajGoruntule("Sogutucu aciliyor..");
        ekran.mesajGoruntule("Sogutucu acik!");

    }

    public void sogutucuKapat(){
        ekran.mesajGoruntule("Sogutucu kapatiliyor..");
        ekran.mesajGoruntule("Sogutucu kapali!");
    }
}
