* test veritabanınızda employee isimli sütun bilgileri id(INTEGER), name VARCHAR(50), birthday DATE, email VARCHAR(100) olan bir tablo oluşturalım.
```
CREATE TABLE employee(
    id INTEGER,
    name VARCHAR(50) NOT NULL,
    birthday DATE,
    email VARCHAR(100)
);
```
* Oluşturduğumuz employee tablosuna 'Mockaroo' servisini kullanarak 50 adet veri ekleyelim.
```
-----
```
* Sütunların her birine göre diğer sütunları güncelleyecek 5 adet UPDATE işlemi yapalım.
```
UPDATE employee
SET name = 'Murat',
    email = '1234@murat.com'
WHERE name = 'Saxon'
RETURNING *;
.
.
.
.
.
.

```
* Sütunların her birine göre ilgili satırı silecek 5 adet DELETE işlemi yapalım.
```
DELETE FROM employee
WHERE id = 1
RETURNING *;

DELETE FROM employee
WHERE id IN(4,10,20)
RETURNING *;

DELETE FROM employee
WHERE id BETWEEN 21 AND 50
RETURNING *;
```
