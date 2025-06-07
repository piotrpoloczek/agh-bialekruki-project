# agh-bialekruki-project

Produkt – analiza danych firmy

1)	Struktura katalogu:

Folder główny (rok)
- miesiąc 
- pliki excela z danymi z danego miesiąca (imie nazwisko pracownika) 
   Struktura excela:
 Projekt 1
------------------------------------------------------------------------
| Data	     | Zadanie	                                    | Czas [h] |
------------------------------------------------------------------------
| 01.02.2012 |	Wizyta u klienta, dopytanie o dane	        | 7,25     |
------------------------------------------------------------------------
| 02.02.2012 |	Przygotoeanie anomimizatora danych i testy	| 6,5      |
------------------------------------------------------------------------

 Projekt 2
-----------------------------------------------------------------------------------
| Data	      | Zadanie	                                               | Czas [h] |
-----------------------------------------------------------------------------------
| 08.02.2012	| Testy prototypu	                                        | 3       |
-----------------------------------------------------------------------------------
| 08.02.2012	| Przygotowanie pierwszej wersji dokumentacji użytkownika	| 4       |
-----------------------------------------------------------------------------------

2)	Uruchamiając program mamy podać ścieżkę do foldera np.
a.	2024 -> ma robić raport z wszystkich podkatalogów
b.	2024/1 -> ma robić raport z danego podkatalogu

3)	Uruchamianie z filtracją
a.	Po słowie klucz (opcjonalne)
i.	2024 -t spotkanie
ii.	2024/1 -t spotkanie
b.	Po # w excelu
i.	2024 -t #abc
ii.	2024/1 -t #abc
c.	Po datach (wymagania MAX – mały priorytet) 
i.	2024 16-01-2024 25-03-2024 -> dzień, miesiąc, rok
ii.	2024/01 16-01-2024 25-01-2024 -> dzień, miesiąc, rok
4)	Projekt minimum
Aplikacja konsolowa, w której po podaniu ścieżki program pobiera wszystkie dane z podanego katalogu. Następnie tworzy raporty w Excel (Raport 1 i raport 2). 

UWAGA! Dane mogą zawierać błędy: pusty wiersz, brak jednej danej np. data, ilość godzin. Program ma pomijać puste wiersze, w przypadku braku danych w komórce ma wypluć informację wyjściową o znalezieniu błędu: nazwa pliku i ścieżka do niego oraz który projekt i który wiersz brak danej. Program odczytuje tylko format Excel (.xls). PROGRAM NIE MOŻE SIĘ WYWALIĆ. PROGRAM NIE SZUKA PO CAŁYM DYSKU PODANEGO FOLDERA – zakładamy, że wiemy gdzie jest folder, z którego mamy pobrać dane. KONSOLA MA RÓWNIEŻ POINFORMAĆ OD JAKIEJ DANY TO JAKIEJ DANY ZBIERA DANE, czyli jak mamy ogólnie cały marzec to ma podać, że filtracja jest od 02.03.2024 do 16.03.2024. 

Raport 1:

Jest to raport o pracownikach. Zlicza ilość godzin przepracowanych niezależnie od Projektu czy też typu wykonywanej pracy. Tabela wyjściowa: 
--------------------------------
| Pracownik     |	Ilość godzin |
--------------------------------
| Anna Kowalska | 40           |
--------------------------------


Raport 2:

Jest to raport po projektach, które są w zakładkach. Czyli pobiera wszystkie projekty 1 z wszystkich plików, wszystkie projekty 2 z wszystkich plików. Tabela wyjściowa:

----------------------------
| Projekt   | Ilość godzin |
----------------------------
| Projekt 1	| 120          |
----------------------------

NALEŻY ROZBUDOWAĆ DANE ABY SPRAWDZIĆ CZY DZIAŁA NA WIĘKSZEJ ILOŚCI.

5)	Projekt - wymagania średnie

Raport 3:

Jest to raport po pracownikach z informacją ile % swojego czasu spędził nad danym projektem. Czyli mamy nagłówek imię nazwisko  oraz ile godzin przez wybrany okres spędził na pracy oraz tabelę z numerem projektu, ile godzin nad tym projektem spędził oraz procent (ile godzin spędził nad projektem / ile godzin spędził w pracy * 100%). Tabela wynikowa: 

Anna Nowak – 80 [h]
----------------------------
-----------------------------------------------------------------------------------------
| Nazwa projektu | Ilość godzin nad projektem [h] |	Procent pracy w danym projekcie [%] |
-----------------------------------------------------------------------------------------
| Projekt 1	     | 10                             |	12,5                                |
-----------------------------------------------------------------------------------------
|Projekt 2	     | 70	                            | 87,5                                |
-----------------------------------------------------------------------------------------


Kamil Kowalski – 10 [h]
-------------------------------
-------------------------------------------------------------------------------------------
| Nazwa projektu |	Ilość godzin nad projektem [h] |	Procent pracy w danym projekcie [%] |
-------------------------------------------------------------------------------------------
| Projekt 1	     | 8	                             | 80                                   |
-------------------------------------------------------------------------------------------
| Projekt 2	     | 2	                             | 20                                   |
-------------------------------------------------------------------------------------------


Raport 4:

Jest to raport mówiący o 10 lub 20 najczęściej wykonywanych czynności w danym okresie (wszyscy pracownicy, wszystkie pliki ze ścieżki wejściowej). Ma sumować godziny po słowach klucz (Słownik słów kodowanych – sumuje wszystkie ). Tabela wynikowa:

-----------------------------------------------
| Czynność                  | Suma godzin [h] |
-----------------------------------------------
| Testy prototypu	          | 120             |
-----------------------------------------------
| Przygotowanie prezentacji	| 340             |
-----------------------------------------------


Raport 5:

Jest to raport dający informacje o wszystkich czynnościach zakwalifikowanych do danego #
Przykład: #abc – oznacza pracę z klientem i wypisuje wszystkie informacje z danym #

-------------------------------------------------------------------------
| Czynność	                                          | Suma godzin [h] |
-------------------------------------------------------------------------
| Wizyta u klienta, dopytanie o dane                  |	120             | 
-------------------------------------------------------------------------
| Wizyta u klienta, przetworzenie i odebranie danych	| 340             |
-------------------------------------------------------------------------

Filtracja po # - wymaganie średnie.

MAMY WYKONAĆ TESTY JEDNOSKOWE

6)	Projekt - wymagania MAX
•	Filtrowanie od dnia do dnia
•	Można dodać interfejs wizualny
