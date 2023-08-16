package gallows.main;

import gallows.model.DotaHeroes;
import gallows.service.Service;
import gallows.service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartGame {

    public static int countToWin = 0;

    public static void main(String[] args) {


        Service service = new ServiceImpl();
        SetupGame setupGame = new SetupGame();
        DotaHeroes dotaHeroes = new DotaHeroes();
        Scanner scanner = new Scanner(System.in);

        /*
        1. Случайное слово
        2. Колличество символов
        3 Колличество ошибок (будет увеличивается)
        4. Стрингбилдер для ошибок (отображает неудачные попытки)
        5. secretWord скрытое слово "_ _ _ _ _ _"
        6.Лист, в котром буквы через запятую. Для проверки

         */

        String randomWord = setupGame.randomHeroName;
        int countRandomWord = setupGame.randomHeroNameCount;
        int countUserWrongs = setupGame.countWrong;
        StringBuilder userWrongs = setupGame.wrongs;
        List<String> secretWord = setupGame.secretWord;
        List<String> checkList = setupGame.checkList;


        //Basic field for StartGame

        int maxCountErros = 6;
        int result = 0;
        int playAgain = 0;


        //Console
        System.out.println("Hi man\nLets try");

        while (true) {


            while (countUserWrongs != maxCountErros) {

                //загаданное слово в виде _ _ _ _ _
                System.out.println(secretWord);

                String a = scanner.next();

                //Проверка, есть в слове буква, которрую ввел пользователь
                if (service.checkTry(a, checkList)) {

                    //меня в скрытном слове "_" на букву пользователя
                    service.rewrite(secretWord, checkList, a);

                    System.out.println(" Wrong (" + countUserWrongs + "):" + userWrongs);

                    //Отрисовка висилицы
                    service.drawGallows(countUserWrongs);


                    if (countToWin == countRandomWord) {
                        ++result;
                        System.out.println(secretWord);
                        break;
                    }
                } else {
                    ++countUserWrongs;

                    //запись ошибочной буквы
                    service.addWrong(a, userWrongs);
                    System.out.println(" Wrong (" + countUserWrongs + "):" + userWrongs);
                    service.drawGallows(countUserWrongs);
                }
            }

            //Красивая победная надпись
            if (result == 0) {
                service.badEnd();
                System.out.println("It was: " + randomWord);
            } else {
                service.happyEnd();
            }


            System.out.println("Do you want to play again? (1/2)");
            playAgain = scanner.nextInt();

            if (playAgain == 2) {
                System.out.println("Goodbye!");
                break; // Выход из бесконечного цикла
            } else {
                countUserWrongs = 0;
                result = 0;
                randomWord = service.getRandomName(dotaHeroes.manyNames);
                countRandomWord = service.getRandomNameCount(randomWord);
                countUserWrongs = 0;
                userWrongs = new StringBuilder();
                secretWord = service.createSecretWord(countRandomWord);
                checkList = service.splitName(randomWord);

            }

        }
    }
}






