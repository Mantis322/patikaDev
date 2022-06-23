# Hayvanat Bahçesi UML Diagram

Bir hayvanat bahçesindeki hayvanlar hakkındaki bilgileri takip etmek için bir sistem tasarlıyorsunuz.

Hayvanlar:
* Atlar (atlar, zebralar, eşekler vb.),
* Kedigiller (kaplanlar, aslanlar vb.),
* Kemirgenler (sıçanlar, kunduzlar vb.) gibi gruplardaki türlerle karakterize edilir.
* Hayvanlar hakkında depolanan bilgilerin çoğu tüm gruplamalar için aynıdır.
tür adı, ağırlığı, yaşı vb.
* Sistem ayrıca her hayvan için belirli ilaçların dozajını alabilmeli => getDosage ()
* Sistem Yem verme zamanlarını hesaplayabilmelidir => getFeedSchedule ()
* Sistemin bu işlevleri yerine getirme mantığı, her gruplama için farklı olacaktır. Örneğin, atlar için yem verme algoritması farklı olup, kaplanlar için farklı olacaktır.
* Polimorfizm modelini kullanarak, yukarıda açıklanan durumu ele almak için bir sınıf diyagramı tasarlayın.


![Diagram 2022-06-23 16-38-38](https://user-images.githubusercontent.com/105947075/175313114-5d3643a1-142b-41cd-9c4b-380011d0cb0b.png)
