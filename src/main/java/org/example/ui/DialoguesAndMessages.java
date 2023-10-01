package org.example.ui;

import java.util.ArrayList;
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

}
