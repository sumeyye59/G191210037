package G191210037;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class Veritabani {
    private IEkran ekran;

    public Veritabani(){
        ekran=new Ekran();
    }
    private Connection baglan(){

        Connection conn=null;

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Proje",
                    "postgres", "meryem54");
            if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public Kullanici kullaniciDogrula(String kullaniciAdi,int sifre) {
     ekran.mesajGoruntule("kullanici doğrulaniyor..");

    Kullanici kullanici=null;

    String sql= "SELECT *  FROM \"Kullanicilar\" WHERE \"adi\"='"+kullaniciAdi+"' and \"sifresi\"='"+sifre+"'";

    Connection conn=this.baglan();
        try{
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        //***** Bağlantı sonlandırma *****
        conn.close();

        int sifresi;
        String adi;

        while(rs.next())
        {
            sifresi  = rs.getInt("sifresi");
            adi = rs.getString("adi");
            //builder kullanımı
            kullanici=new Kullanici.KullaniciBuilder().adi(adi).sifre(sifresi).build();
        }

        rs.close();
        stmt.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return kullanici;
    }
}
