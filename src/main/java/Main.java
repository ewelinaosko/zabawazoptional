import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Main {

    private Map<String, Integer> klienci = new HashMap<>();

    public Optional<Boolean> sprawdzPotencjalZakupowy(String imieOsoby, int cenaProduktu) {
        int zawartoscPortfela;
        int maxNumberOfProducts;
        Optional<Boolean> potencjalIstnieje = Optional.empty();

        for (Map.Entry<String, Integer> element : klienci.entrySet()) {
            //System.out.printf("%s - %s%n",element.getKey(), element.getValue());
            if (element.getKey() == imieOsoby && element.getValue() >= cenaProduktu) {
                zawartoscPortfela = element.getValue();
                maxNumberOfProducts = zawartoscPortfela / cenaProduktu;
                //System.out.printf("!!%s - %s max: %s%n",element.getKey(), zawartoscPortfela, maxNumberOfProducts);
                if (maxNumberOfProducts >= 10) {
                    potencjalIstnieje = Optional.of(true);
                }
            }
        }
        return Optional.of(potencjalIstnieje.orElseThrow(()-> new RuntimeException("Osoba nie istnieje lub jest zbyt biedna")));
    }

    public static void main(String[] args) {

        Main map = new Main();
        map.klienci.put("Ania", 100);
        map.klienci.put("Basia", 200);
        map.klienci.put("Wacek", 300);
        map.klienci.put("Kasia", 400);
        map.klienci.put("Zenek", 500);
        map.klienci.put("Piotr", 5000);
        map.klienci.put("Ala", 0);

        //System.out.println(map.sprawdzPotencjalZakupowy("Wacek", 250));

        System.out.println(map.sprawdzPotencjalZakupowy("Piotr", 250));
    }


}

/*
Zadanie3. Zabawa  z Optional

Stwórz mapę zawierającą jako klucze imiona a jako wartości ilość pieniędzy.
Korzystając z Optional, stwórz metodę przyjmującą jako argumenty imię osoby oraz koszt produktu.
Metoda powinna:
1.wyciągnąć z mapy ilość pieniędzy dla podanej osoby
2.odrzucić wartości poniżej kosztu produktu
3.przekształcić wartość na maksymalną ilość produktów, którą osoba może zakupić
4.przekształcić na wartość prawda/fałsz
–prawda jeśli osoba jest w stanie kupić minimum 10 produktów,inaczej fałsz
5.zwrócić wartość prawda/fałsz
-jeśli Optional jest pusty, rzucić wyjątek zawierający wiadomość
„Osoba nie istnieje lub jest zbyt biedna”
Wszystkie operacje po pierwszej powinny być wykonane tylko i wyłącznie za pomocą metod na obiekcie typu Optional
 */