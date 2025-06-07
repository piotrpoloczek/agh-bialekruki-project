# AGH-Bialekruki-Project

## Produkt – analiza danych firmy

### 1. Struktura katalogu:

Folder główny (rok)

* miesiąc

    * pliki Excela z danymi z danego miesiąca (imię nazwisko pracownika)

        * Struktura Excela:

#### Projekt 1

| Data       | Zadanie                                    | Czas \[h] |
| ---------- | ------------------------------------------ | --------- |
| 01.02.2012 | Wizyta u klienta, dopytanie o dane         | 7,25      |
| 02.02.2012 | Przygotoeanie anomimizatora danych i testy | 6,5       |

#### Projekt 2

| Data       | Zadanie                                                 | Czas \[h] |
| ---------- | ------------------------------------------------------- | --------- |
| 08.02.2012 | Testy prototypu                                         | 3         |
| 08.02.2012 | Przygotowanie pierwszej wersji dokumentacji użytkownika | 4         |

---

### 2. Uruchamianie programu:

* Podajemy ścieżkę do folderu:

    * `2024` -> raport z wszystkich podkatalogów
    * `2024/1` -> raport tylko z podkatalogu `1`

### 3. Uruchamianie z filtracją (opcjonalne):

* Po słowie klucz:

    * `2024 -t spotkanie`
    * `2024/1 -t spotkanie`
* Po # w Excelu:

    * `2024 -t #abc`
    * `2024/1 -t #abc`
* Po datach (priorytet niski):

    * `2024 16-01-2024 25-03-2024`
    * `2024/01 16-01-2024 25-01-2024`

---

### 4. Projekt minimum:

* Konsolowa aplikacja:

    * Po podaniu ścieżki zbiera dane z katalogu
    * Tworzy raporty w Excel:

#### Raport 1: Raport o pracownikach

Zlicza ilość godzin niezależnie od projektu.

| Pracownik     | Ilość godzin |
| ------------- | ------------ |
| Anna Kowalska | 40           |

#### Raport 2: Raport po projektach

Zlicza godziny z zakładek Projekt 1, Projekt 2 itd.

| Projekt   | Ilość godzin |
| --------- | ------------ |
| Projekt 1 | 120          |

Uwagi:

* Program ma pominąć puste wiersze
* Brak danych (np. brak daty lub godzin) ma zostać wypisany w konsoli z:

    * nazwą pliku
    * ścieżką
    * nazwą projektu
    * numerem wiersza
* Obsługuje tylko format `.xls`
* Konsola pokazuje zakres dat: np. od 02.03.2024 do 16.03.2024
* Program nie przeszukuje dysku globalnie

---

### 5. Projekt - wymagania średnie:

#### Raport 3: Procent pracy nad projektami

Anna Nowak – 80 h

| Nazwa projektu | Ilość godzin | Procent \[%] |
| -------------- | ------------ | ------------ |
| Projekt 1      | 10           | 12.5         |
| Projekt 2      | 70           | 87.5         |

Kamil Kowalski – 10 h

| Nazwa projektu | Ilość godzin | Procent \[%] |
| -------------- | ------------ | ------------ |
| Projekt 1      | 8            | 80           |
| Projekt 2      | 2            | 20           |

#### Raport 4: 10/20 najczęściej wykonywanych czynności

| Czynność                  | Suma godzin \[h] |
| ------------------------- | ---------------- |
| Testy prototypu           | 120              |
| Przygotowanie prezentacji | 340              |

#### Raport 5: Raport wg

| Czynność                                           | Suma godzin \[h] |
| -------------------------------------------------- | ---------------- |
| Wizyta u klienta, dopytanie o dane                 | 120              |
| Wizyta u klienta, przetworzenie i odebranie danych | 340              |

---

### 6. Projekt - wymagania MAX:

* Filtrowanie danych od dnia do dnia (data start, data koniec)
* (opcjonalnie) interfejs graficzny

---

### Testy jednostkowe:

* Wymagane dla funkcji parsujących pliki Excel
* Obsługa sytuacji błędnych (brak danych)
* Testy raportów (sprawdzenie poprawności wyników)

---

**UWAGA:** Projekt powinien zostać przetestowany na danych z większą liczbą plików, aby upewnić się, że działa dla wszystkich przypadków.
