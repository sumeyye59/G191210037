package G191210037;
import java.util.Scanner;
public class Arayuz {
    private IEkran ekran;
    private IMerkeziIslemBirimi merkeziIslemBirimi;
    private static final int SICAKLIK_GORUNTULEME = 1;
    private static final int SOGUTUCU_AC = 2;
    private static final int SOGUTUCU_KAPAT = 3;
    private static final int CIKIS = 4;

    public Arayuz(){
        ekran=new Ekran();
        merkeziIslemBirimi=new MerkeziIslemBirimi();
    }
public void basla(){
    ekran.mesajGoruntule("Kullanici Adi:");

    Scanner input=new Scanner(System.in);
    String kullaniciAd=input.next();
    ekran.mesajGoruntule("Sifre:");
    input=new Scanner(System.in);

    int sifre=input.nextInt();
    Veritabani veritabani=new Veritabani();
    Kullanici kullanici1=this.kullaniciDogrulama(kullaniciAd,sifre,veritabani);
    if (kullanici1 != null){
        ekran.mesajGoruntule("Kullanıcı doğrulama işlemi başarılı...");
        islemSecimi(veritabani, kullanici1);
    } else{
        ekran.mesajGoruntule("kullanıcı doğrulanamadı");
    }
}

    private Kullanici kullaniciDogrulama(String kullaniciadi,int sifre,Veritabani veritabani){

        return veritabani.kullaniciDogrula(kullaniciadi,sifre);
    }
    private void islemSecimi(Veritabani veritabani, Kullanici kullanici){
        int secim;
        do{
            secim=anaMenuyuGoster();

            switch (secim) {
                case SICAKLIK_GORUNTULEME:
                    IIslem sicaklikGoruntuleme=new SicaklikGoruntuleme(ekran, merkeziIslemBirimi);
                    sicaklikGoruntuleme.islemYap();
                    break;
                case SOGUTUCU_AC:
                    IIslem sogutucuAcma=new SogutucuAcma(ekran, merkeziIslemBirimi);
                    sogutucuAcma.islemYap();
                    break;

                case SOGUTUCU_KAPAT:
                    IIslem sogutucuKapatma=new SogutucuKapatma(ekran, merkeziIslemBirimi);
                    sogutucuKapatma.islemYap();
                    break;

                case CIKIS:
                    ekran.mesajGoruntule("Çıkılıyor");
                    break;
                default:
                    ekran.mesajGoruntule("1-4 arasında bir sayı girmelisiniz");
            }
        }while(secim!=4);
    }
    private int anaMenuyuGoster()
    { Scanner input=new Scanner(System.in);

        ekran.mesajGoruntule("**********************************************");
        ekran.mesajGoruntule("Ana Menu");
        ekran.mesajGoruntule("1-Sıcaklık Görüntüle");
        ekran.mesajGoruntule("2-Soğutucu Aç");
        ekran.mesajGoruntule("3-Soğutucu Kapat");
        ekran.mesajGoruntule("4-Cikis");
        ekran.mesajGoruntule("Seciminiz:");
        ekran.mesajGoruntule("**********************************************");
        return input.nextInt();
    }
}
