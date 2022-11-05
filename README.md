# PatikaDev_A101_Final_Project

Proje   Page Object Model prensiplerine uygun olarak  ve TestNG frameWork'uyle build edildi.
Loglama yontemi olarak slf4j kullanildi.

Testin yapildigi her sayfa icin gerekli elementler ve o sayfa ile ilgili reusable methodlar icin ayri ayri page class'lari olusturuldu. Bu classlardan element ve method cagirmak icin olusturulmasi gereken nesne sayisi cok olacakti. Bu yuzden  butun page'lere ulasabilmek icin bir tane  allPages class'i olusturup buraya her page ulasmak icin methodlar olusturdum. Ardindan test class'imda olusturdugum tek bir allPages objesiyle istedigim page class'ina ulasma sansi elde ettim.

Testlerin kodlari yazilirken her sayfayla ilgili reusable methodlar o sayfanin page class'inda yazilarak test classinda kod fazlaliliginin onune gecildi.

Assertion icin ise TestNG'den gelen assert methodu fail oldugunda kodun calismasini durdurdugu icin icinde try-catch'e alinmis bir TestNG assertion'i olan reusable bir method olusturuldu.Methodun icine konulan loglarla da testin gecmesi veya gecmemesi durumlari icin uyari mesajlarinin konsola ve text dosyasina yazdirilmasi saglandi.  ReusableMethods class'ina konan bu methodla assertion fail olsa bile kodlarin calismaya devam etmesi saglandi.
Son olarak da testlerin istenilen farkli sekillerde calistirilabilmesi icin xml dosyasi olusturuldu.(Simdilik icinde butun testlerin calistirilmasi icin kod yazildi)
