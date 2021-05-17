package G191210037;

public class Kullanici {
    private String kullaniciAdi;
    private int sifre;

    private Kullanici(KullaniciBuilder builder) {
        this.kullaniciAdi = builder.kullaniciAdi;
        this.sifre= builder.sifre;
    }
    public static class KullaniciBuilder
    {
        private String kullaniciAdi;
        private int sifre;

        public KullaniciBuilder() {
        }
        public KullaniciBuilder adi (String adi) {
            this.kullaniciAdi = adi;
            return this;
        }
        public KullaniciBuilder sifre (int sifre) {
            this.sifre = sifre;
            return this;
        }
        public Kullanici build() {

            return new Kullanici(this);
        }
}}
