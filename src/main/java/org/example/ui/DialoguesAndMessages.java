package org.example.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DialoguesAndMessages {
    public String orkNames() {
        Random random = new Random();
        int rnd = random.nextInt(40);
        String rasa = "Раса: Орк";
        List<String> listOrkNames = Arrays.asList("Грумгар", "Глозгул", "Дургрим", "Озгрим", "Луграк", "Буздур", "Тхрагор",
                "Шадурук", "Горблок", "Шазгрун", "Глублок", "Бурглур", "Зогрим", "Гламгур", "Друмгар", "Трогрин",
                "Фазгар", "Оглок", "Глазгур", "Глунгур", "Глоргур", "Мурглур", "Тхрадур", "Бузглур", "Глазглур",
                "Глазгрим", "Глоглур", "Гранглур", "Грозгур", "Гроблур", "Гримгур", "Гродгур", "Луглок", "Бузгар",
                "Тхраглур", "Грулгур", "Грунгур", "Хазглур", "Хрумгур", "Грузгур");
        return listOrkNames.get(rnd) + " " + rasa;
    }

    public void hospitalFirst() {
        String one = "Выберите действие:\n";
        String two = "1 - полное лечение (восстановление очков здоровья и маны до максимума).\n";
        String three = "2 - полное восстановление очков здоровья.\n";
        String four = "3 - полное восстановление очков маны.\n";
        String five = "4 - уйти из госпиталя.\n";
        System.out.println(one + two + three + four + five);
    }

    public void storeFirst() {
        String one = "Только взгляните на наш ассортимент!\n";
        String two = "1 - купить зелье восстановления здоровья.\n";
        String three = "2 - купить зелье восстановления маны.\n";
        String four = "4 - выйти из магазина.\n";
        System.out.println(one + two + three + four);
    }

}
