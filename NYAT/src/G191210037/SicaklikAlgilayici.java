package G191210037;
import java.util.Random;
public class SicaklikAlgilayici implements ISicaklikAlgilayici{

    public int sicaklik;
    Random rastgele = new Random();
    ISubject publisher;
public SicaklikAlgilayici(ISubject publisher){

    this.publisher=publisher;
}
public void aboneEkle(IObserver abone){

    publisher.attach(abone);
}
public void sicaklikOku(){

sicaklik=Math.abs(rastgele.nextInt()%100);
publisher.notify(sicaklik);
}


}
