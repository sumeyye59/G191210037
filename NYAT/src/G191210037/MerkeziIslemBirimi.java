package G191210037;

public class MerkeziIslemBirimi implements IMerkeziIslemBirimi {
    private IEyleyici eyleyici;
    private ISicaklikAlgilayici sicaklikAlgilayici;

    public MerkeziIslemBirimi(){

        eyleyici=new Eyleyici();
        sicaklikAlgilayici=new SicaklikAlgilayici(new Publisher());
        sicaklikAlgilayici.aboneEkle(new Subscriber1());
        sicaklikAlgilayici.aboneEkle(new Subscriber2());
        sicaklikAlgilayici.aboneEkle(new Subscriber3());
    }
@Override
public void eyleyiciyeGonder(int secim){
if(secim==2){

eyleyici.sogutucuAc();

}
if(secim==3){

    eyleyici.sogutucuKapat();

}
}
@Override
public void sicaklikAlgilayiciyaGonder(){

        sicaklikAlgilayici.sicaklikOku();

}

}
