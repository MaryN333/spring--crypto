# spring--crypto
Engeto, second project

Projekt : Správa kryptoměnového portfolia
Motivace
﻿

Ve světě moderních financí a technologií jsou kryptoměny stále populárnějším nástrojem investic. Pro mnohé investory se z nich stala součást jejich každodenního života a jejich správa, sledování cen a spravování portfolia je stále důležitější. V této závěrečné úloze budete mít možnost vytvořit základní aplikaci pro správu kryptoměnového portfolia, která vám ukáže, jak mohou být finanční technologie realizovány pomocí jazyka Java a Spring Boot frameworku.

﻿

Vaším úkolem bude implementovat aplikaci, která umožní přidávat a zobrazovat kryptoměny v portfoliu, třídit je podle různých kritérií, a tím efektivně spravovat kryptoměnové investice. Během této práce si procvičíte práci s kolekcemi, naučíte se řadit data a budete pracovat s různými způsoby, jak předávat data mezi klientem a serverem.



Kromě technických znalostí, které si rozšíříte, získáte také lepší představu o tom, jak lze technologie využít v praxi pro reálné aplikace. Tato úloha vám pomůže připravit se na řešení složitějších problémů v budoucích projektech.

Zadání

- Vytvořte nový projekt ve Spring Boot, který bude obsahovat následující komponenty:

  - Controller pro zpracování požadavků od klienta. CryptoController
  - Service pro logiku aplikace CryptoService
  - Model pro objekt Crypto, který bude reprezentovat kryptoměnu.


Model Crypto

- Třída Crypto by měla obsahovat následující atributy:
  - id (Integer) - unikátní identifikátor kryptoměny.
  - name (String) - název kryptoměny (např. Bitcoin, Ethereum).
  - symbol (String) - zkratka kryptoměny (např. BTC, ETH).
  - price (Double) - aktuální cena kryptoměny v dolarech.
  - quantity (Double) - počet jednotek kryptoměny v portfoliu.

Service pro správu kryptoměn
- Vytvořte ArrayList typuCrypto, který bude uchovávat seznam kryptoměn v portfoliu.

- Implementujte metody pro:
  - Přidání nové kryptoměny do portfolia.
  - Výpis všech kryptoměn v portfoliu.
  - Seřazení kryptoměn podle názvu, ceny nebo počtu jednotek.

API Endpointy

Vytvořte následující endpointy:

- Přidání nové kryptoměny do portfolia (POST /cryptos):
  - Přijímejte data kryptoměny v RequestBody a přidejte ji do seznamu.
- Získání všech kryptoměn (GET /cryptos):
  - Vraťte seznam všech kryptoměn v portfoliu.
  - Přidejte možnost řazení podle názvu, ceny nebo počtu jednotek pomocí parametru sort v Query podle následující pravidel:
    - pro řazení podle ceny : /cryptos?sort=price
    - pro řazení pode názvu : /cryptos?sort=name
    - pro řazení podle počtu jednotek : /cryptos?sort=quantity
- Získání detailu konkrétní kryptoměny (GET /cryptos/{id}):
  - Přijímejte id kryptoměny v cestě a vraťte detaily dané kryptoměny.

Bonusový úkol

- Přidejte endpoint pro aktualizaci kryptoměny (PUT /cryptos/{id}), kde přijmete aktualizovaná data kryptoměny přes RequestBody a identifikátor kryptoměny přes Path.
- Přidejte endpoint pro výpočet celkové hodnoty portfolia (GET /portfolio-value), který spočítá a vrátí celkovou hodnotu portfolia (součet price * quantity všech kryptoměn).

Pravidla pro hodnocení

- Správné implementace modelu Crypto a využití ArrayList.
- Úspěšného vytvoření a konfigurace Spring Boot projektu.
- Správného fungování jednotlivých endpointů a možnosti řazení kryptoměn.
- Dodržení všech požadovaných způsobů přenosu hodnot (Body, Query, Path).
- Kvality kódu a logické struktury projektu.