# Klasy drzew

Implementacja abstrakcji drzewa liściastego i iglastego w języku Java.

### Różnice w zachowaniu drzew:
Przyjmuję prostą sytuację, gdzie różnice w rodzajach drzew przejawiają się przede wszystkim w różnych typach liści (liście lub igły) oraz w ich cyklu życia - igły rosną wraz z gałęziami i zostają na swoim miejscu, podczas gdy liście cyklicznie rosną wszystkie naraz, zmieniają kolory, oraz spadają z drzewa. <br>
Drzewa różnią się również rozmiarami do których dorastają.

## Elementy drzewa
Drzewo posiada pień, który wypuszcza gałęzie, z których wyrastają liście oraz kolejne gałęzie. <br>
Pień i gałęzie posiadają swój początkowy oraz końcowy promień, a także długość, są więc prostymi obiektami geometrycznymi będącymi w istocie w reprezentacji podłużnymi stożkami ściętymi. <br>
Pień i gałęzie mają dwie fazy wzrostu - zaczynają rosnąć z pewną prędkością robiąc to coraz wolniej do momentu osiągnięcia ustalonego punktu, od którego rosną ze stałą prędkością do osiągnięcia długości maksymalnej. Maksymalne rozmiary elementu są podawane przy tworzeniu go i powstają częściowo w oparciu o element, z którego wyrastają (jeżeli taki jest), oraz położenie na nim (im wyżej na pniu rośnie gałąź tym cieńszy może być pień, a więc tym mniejsza maksymalna grubość gałęzi).

## Pomocnicze klasy
- GrowingSpot - klasa przedstawiająca miejsce, w którym dany element drzewa rośnie na elemencie z którego wyrasta; przechowuje odległość od początku elementu-rodzica oraz liczbę od 0 do 360 odpowiadającą kierunkowi dookoła elementu, w którym wyrasta
- LeafColor - prosty typ odpowiadający kolorowi liścia (drzewa liściastego) oraz posiadający metodę statyczną zwracającą następny w kolejności kolor, na który powinien zostać zmieniony kolor podany do metody (kolory zmieniają się w kolejności: ZIELONY -> ŻÓŁTY -> CZERWONY -> BRĄZOWY)
- LeafType - prosty typ odpowiadający rodzajowi liścia

## Klasy Liści
- AbstractLeaf - klasa abstrakcyjna, z której dziedziczą klasy właściwych liści
- Needle - klasa igły drzewa iglastego, przechowuje jedynie typ liścia i nie posiada dodatkowych funkcjonalności
- Leaf - klasa liścia drzewa liściastego, poza typem liścia posiada też obecny kolor oraz możliwość jego zmiany na następny w kolejności

## Klasy elementów drewnianych
- AbstractWoodElement - klasa abstrakcyjna uogólniająca gałęzie i pnie jako elementy drewniane, ze względu na ich podobieństwa - kształt oraz pewne elementy zachowania, takie jak tworzenie nowych gałęzi i podobny sposób rośnięcia; przechowuje wartości wyznaczające rozmiary elementu oraz kontrolujące wzrost; podczas wzrostu elementu zostaje zwiększona jego długość oraz początkowy promień

### Pnie
- AbstractTrunk - klasa abstrakcyjna dziedzicząca po AbstractWoodElement; doprecyzowuje funkcjonalność elementu do zachowania pnia, definiuje metodę wzrostu dla pnia, która odpowiada również za dodawanie nowych gałęzi; parametry wzrostu dla gałęzi wytastających z pnia są wyznaczane na podstawie parametrów wzrostu pnia oraz odległości powstających gałęzi od początku pnia
- ConiferTrunk - klasa pnia dla drzewa iglastego, nie wprowadza dodatkowej funkcjonalności do klasy pnia, definiuje jedynie metodę stworzenia odpowiedniego typu gałęzi
- LeafyTreeTrunk - klasa pnia dla drzewa liściastego, podobnie jak pień drzewa iglastego doprecyzowuje jedynie typ dodawanej gałęzi

### Gałęzie
- AbstractBranch - klasa abstrakcyjna dziedzicząca po AbstractWoodElement; dodaje funkcjonalność wzrostu; parametry wzrostu dla gałęzi wytastających z gałęzi są wyznaczane na podstawie parametrów wzrostu gałęzi-rodzica oraz odległości powstających gałęzi od początku rodzica
- ConiferBranch - rozwija klasę abstrakcyjną gałęzi o doprecyzowanie tworzonych elementów dla drzewa iglastego oraz definiuje metodę dodającą elementy wykorzystywaną przy wzroście; gałęzie drzewa iglastego produkują igły podczas wzrostu
- LeafyTreeBranch -  ozwija klasę abstrakcyjną gałęzi o doprecyzowanie tworzonych elementów dla drzewa liściastego oraz definiuje metodę dodającą elementy wykorzystywaną przy wzroście; gałęzie drzewa liściastego nie produkują liści podczas wzrostu, zamiast tego liście rosną jednocześnie na całej długości gałęzi w wyznaczonym momencie, następnie stopniowo zmieniają kolory i spadają z gałęzi

## Klasy drzew
- AbstractTree - klasa abstrakcyjna będąca generalizacją drzewa; przechowuje typ drzewa, jego wiek i pień, oraz deklaruje motodę odpowiadająca za wzrost
- AbstractConifer - klasa abstrakcyjna dla drzewa iglastego
- AbstractLeafyTree - klasa abstrakcyjna dla drzewa liściastego; umożliwia dodatkową funkcjonalność związaną z tworzeniem i zrzucaniem liści oraz zmianą ich koloru
- Conifer oraz LeafyTree - właściwe klasy drzew, dziedziczą po swoich odpowiednich abstrakcjach, odpowiadają za przykłady konkretnych gatunków dla drzew iglastych i liściastych, tworzą drzewo ze zdefiniowanymi parametrami wzrostu, umożliwiając instancjonowanie obiektu drzewa bez konieczności ich podawania; klasa LeafyTree implementuje dodatkowo cykl zachowania drzewa

Klasa **TreeClassesApplication** umożliwia szybkie przetestowanie działania, pozwala na wybór rodzaju drzewa oraz manualnego lub automatycznego wywoływania metody wzrostu. <br>
Zmiany w elementach drzewa można zaobserwować na konsoli.