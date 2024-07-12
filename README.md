# Projenin Amacı
Bir soğutucuyu kontrol etmek üzere akıllı cihaz üretilmiştir.Çalışma kapsamında, bu cihaz için geliştirilecek yazılımın 
analizini ve tasarımını yaptım.

Geliştirdiğim yazılım konsol uygulaması Java ile PostgreSQL kullanılarak oluşturulmuştur.
Uygulama içerisinde SOLID tasarım ilkelerinden “Dependency 
Inversion” gerçeklenmektedir.
Geliştirdiğiniz uygulama içerisinde tasarım desenlerinden “Builder” ve “Observer” 
kullanılmaktadır.
Uygulamada giriş ekranı bulunmaktadır (kullanıcı adı ve şifre sorulmalıdır) ve 
veritabanına bağlanılarak kullanıcı doğrulaması yapılmaktadır.
Kullanıcı doğrulama işlemleri sırasında oluşturulan kullanıcı nesnesi builder nesnesiyle oluşuruluyor.

![Ekran Alıntısı2](https://github.com/user-attachments/assets/86df2cd7-fed0-455e-8560-d4761c791ced)

## Sıcaklığın Görüntülenmesi ve Soğutucunun Açılıp Kapatılması
1 seçeneği seçildiğinde komut sıcaklık görüntüleme işlemi üzerinden merkezi işlem birimine gider oradanda sıcaklık algılayıcının sıcaklık oku metodun çağrılır. Sıcaklık algılayıcı rastgele değer atayarak sıcaklığı ölçüyor. Ve observer deseni sayesinde 3 aboneye değeri gönderiyor. Abone 1 anormal durum var mı diye control ediyor.Sıcaklık 50 derecenin üstündeyse uyarı mesajı gönderiyor. Değilse sicaklik normal mesajı gönderiyor. Abone 2 sıcaklık değerini kaydetme görevinden sorumlu. Abone 3 ise sıcaklık  görüntüleme birimi. Sıcaklık değerini ekrana yani kullanıcıya gösteriyor. Eğer 2 veya 3 seçilirse soğutucu açma , soğutucu kapatma işlemleri üzerinden merkezi işlem birimine gönderilir. Merkezi işlem biriminden de eyleyiciye iletilerek soğutucu açılır veya kapatılır.

## Dependency Inversion İlkesi
Nesneler arasındaki bir bağlantıda, yüksek seviyeli modül ile düşük seviyeli modül soyutlamaya bağlı olmalı. Her ikisi birbirine doğrudan değil arayüz üzerinden bağlanmalı. Böylece modülde yapılacak değişiklik diğer modülleri etkilememiş olur. Değişiklik yapmak kolaylaşır. Yeni özellik eklemek kolaylaşır . Modüllerin tekrar kullanım oranı artar. 
Ben de projem içinde arayüzler kullanmaya özen gösterdim. Bir örnek vermek gerekirse Islem arayuzunden ıslem yap fonksiyonunu SicaklikGörüntüleme, SogutucuAcma ve SogutucuKapatma nesneleri kullandı.
## Observer Tasarım Deseni
Observer gözlemci /izleyici demektir.Elimizdeki mevcut bir veride değişiklik olduğunda bu verinin değiştiğini bu veriyi gözleyen nesnelerinde haberinin olmasıdır ki bunlara aboneler denir.Benim projemde 3 abone var bunların görevleri sırasıyla; anormal durum tespiti, sıcaklığı kaydetme ve görüntüleme birimi. Sıcaklık okunduğu anda bu üçüne sıcaklık değeri ulaşıyor ve hepsi kendi görevlerine göre hareket ediyor. Mesela abone 1 sıcaklık 50 derecenin üstündeyse uyarı mesajı gönderiyor. 
## Builder Tasarım Deseni
Daha çok karmaşık nesneler için kullanılır.Karmaşık bir nesnenin yapımını temsilinden ayırır. Böylece aynı yapım süreci farklı temsiller oluşturabilir. 
Nesnelerin farklı temsillerinin (sunumunlarının) her biri için ayrı ayrı yapıcı tanımlamak yerine, nesne oluşturma işini adım adım gerçekleştiren “builder” deseni kullanılabilir. Böylece nesne oluşturma işi nesnenin kendisinden ayrılmış olur. Nesne oluşturma işlemi istemci koddan ayrılmış olur. Tabi benim projemde karmaşık sınıf yoktu ama ben kullanıcı sınıfında builder kullanmayı tercih ettim.
Nesne oluşturmak gerektiğinde, builder sınıfının nesnenin ilgili özelliklerine ilk değer ataması yapan yöntemleri sırasıyla çağrılır. Çağrılan son yöntem (build) Kullanici nesnesini oluşturur. Nesne oluşturmak için, nesnenin varsayılan yapıcısına, nesnenin ilgili üyelerinin değerlerini içeren KullaniciBuilder sınıfı gönderilir.

## Kullanım Durumu Diyagramı
