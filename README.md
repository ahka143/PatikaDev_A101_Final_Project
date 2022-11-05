# PatikaDev_A101_Final_Project

Proje   **_Page Object Model_** prensiplerine uygun olarak  ve **_TestNG frameWork_**'uyle build edildi.
Loglama yontemi olarak **_slf4j_** kullanildi.

Testin yapildigi her sayfa icin gerekli elementler ve o sayfa ile ilgili reusable methodlar icin ayri ayri page class'lari olusturuldu. Bu classlardan element ve method cagirmak icin olusturulmasi gereken nesne sayisi cok olacakti. Bu yuzden  butun page'lere ulasabilmek icin bir tane  **_allPages class_**'i olusturup buraya her page ulasmak icin methodlar olusturdum. Ardindan test class'imda olusturdugum tek bir allPages objesiyle istedigim page class'ina ulasma sansi elde ettim.

Testlerin kodlari yazilirken her sayfayla ilgili **reusable methodlar** o sayfanin page class'inda yazilarak test classinda **kod fazlaliliginin** onune gecildi.

**_Assertion_** icin ise **_TestNG_**'den gelen assert methodu fail oldugunda kodun calismasini durdurdugu icin icinde **_try-catch_**'e alinmis bir TestNG assertion'i olan reusable bir method olusturuldu.Methodun icine konulan loglarla da testin gecmesi veya gecmemesi durumlari icin uyari mesajlarinin konsola ve text dosyasina yazdirilmasi saglandi.  **ReusableMethods** class'ina konan bu methodla assertion fail olsa bile kodlarin calismaya devam etmesi saglandi.
Son olarak da testlerin istenilen farkli sekillerde calistirilabilmesi icin **_xml_** dosyasi olusturuldu.(Simdilik icinde butun testlerin calistirilmasi icin kod yazildi)
