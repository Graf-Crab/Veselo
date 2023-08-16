package gallows.main;

import gallows.model.DotaHeroes;
import gallows.service.Service;
import gallows.service.ServiceImpl;

import java.util.List;

public class SetupGame {
    DotaHeroes dotaHeroes = new DotaHeroes();
    Service serviceManager = new ServiceImpl();

    /*
    1.Получаем рандомное слово
    2.Получаем колличество букв
    3. На основе этого создаем секретное слово
    4. Нам нужен лист для проверки
    5. Счетчик колличества ошибок
    6. Счетчик колличества правильных ответов
    7. Список ошибочных букв
     */

     String randomHeroName = serviceManager.getRandomName(dotaHeroes.manyNames);
     int randomHeroNameCount = serviceManager.getRandomNameCount(randomHeroName);
     List<String> secretWord = serviceManager.createSecretWord(randomHeroNameCount);
     List<String> checkList = serviceManager.splitName(randomHeroName);

    int countWrong = 0;

     StringBuilder wrongs = new StringBuilder();
}
