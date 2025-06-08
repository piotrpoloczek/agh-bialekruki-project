# Produkt – Analiza danych firmy

## 1) Struktura katalogu

**Folder główny (rok):**
- `miesiąc/`
    - pliki Excela z danymi z danego miesiąca: `Imię Nazwisko.xlsx`

**Struktura pliku Excel:**

Zakładki:
- **Projekt 1**
```
Data        | Zadanie                                        | Czas [h]
------------|------------------------------------------------|---------
01.02.2012  | Wizyta u klienta, dopytanie o dane             | 7,25
02.02.2012  | Przygotowanie anonimizatora danych i testy     | 6,5
```

- **Projekt 2**
```
Data        | Zadanie                                                | Czas [h]
------------|--------------------------------------------------------|---------
08.02.2012  | Testy prototypu                                        | 3
08.02.2012  | Przygotowanie pierwszej wersji dokumentacji użytkownika | 4
```

---

## 2) Uruchamianie programu

**Ścieżka do folderu:**
- `2024` – raport z wszystkich podkatalogów
- `2024/1` – raport z danego podkatalogu

---

## 3) Uruchamianie z filtracją

### a. Po słowie klucz (opcjonalne):
```
2024 -t spotkanie
2024/1 -t spotkanie
```

### b. Po znaczniku `#`:
```
2024 -t #abc
2024/1 -t #abc
```

### c. Po datach (wymaganie MAX – niski priorytet):
```
2024 16-01-2024 25-03-2024
2024/01 16-01-2024 25-01-2024
```

---

## 4) Projekt minimum

Konsolowa aplikacja, która:
- Po podaniu ścieżki pobiera wszystkie dane z katalogu
- Tworzy raporty w formacie Excel:
    - Raport 1
    - Raport 2

### Obsługa błędów:
- Pomijanie pustych wierszy
- W przypadku brakujących danych:
    - Komunikat: nazwa pliku, ścieżka, projekt, wiersz, brakująca kolumna
- Obsługa tylko plików `.xls`
- Nie przeszukuje całego dysku, tylko wskazany folder
- Konsola podaje zakres dat znalezionych danych (np. od 02.03.2024 do 16.03.2024)

### Raport 1 – Pracownicy:
| Pracownik     | Ilość godzin |
|---------------|--------------|
| Anna Kowalska | 40           |

### Raport 2 – Projekty:
| Projekt    | Ilość godzin |
|------------|--------------|
| Projekt 1  | 120          |

---

## 5) Projekt – wymagania średnie

### Raport 3 – % czasu nad projektami:
**Anna Nowak – 80 h**
| Nazwa projektu | Ilość godzin | Procent [%] |
|----------------|---------------|-------------|
| Projekt 1      | 10            | 12,5%       |
| Projekt 2      | 70            | 87,5%       |

**Kamil Kowalski – 10 h**
| Nazwa projektu | Ilość godzin | Procent [%] |
|----------------|---------------|-------------|
| Projekt 1      | 8             | 80%         |
| Projekt 2      | 2             | 20%         |

---

### Raport 4 – Najczęstsze czynności:
| Czynność                 | Suma godzin |
|--------------------------|-------------|
| Testy prototypu          | 120         |
| Przygotowanie prezentacji| 340         |

---

### Raport 5 – Praca z #tagiem:
`#abc` – praca z klientem
| Czynność                                        | Suma godzin |
|------------------------------------------------|-------------|
| Wizyta u klienta, dopytanie o dane             | 120         |
| Wizyta u klienta, przetworzenie i odebranie danych | 340     |

---

## 6) Projekt – wymagania MAX

- Filtrowanie `od dnia do dnia`
- Interfejs graficzny (opcjonalnie)

---

## TESTY

- **Jednostkowe testy** obowiązkowe dla każdego komponentu

