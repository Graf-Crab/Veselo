package gallows.main;

import gallows.model.DotaHeroes;
import gallows.service.Service;
import gallows.service.ServiceImpl;

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
        String playAgain;

        //Console
        System.out.println("Hi man\nLets try");


        ///////Game start

        while (true) {

            while (countUserWrongs != maxCountErros) {

                //загаданное слово в виде _ _ _ _ _
                System.out.println(secretWord);

                String a = scanner.next();


                //Проверка, есть в слове буква, которую ввел пользователь
                if (service.checkTry(a, checkList)) {

                    //меня в скрытном слове "_" на букву пользователя
                    if (service.checkTry(a, secretWord)) {
                        System.out.println("You already entered it");

                    } else {
                        service.rewrite(secretWord, checkList, a);
                    }

                    System.out.println(" Wrong (" + countUserWrongs + "):" + userWrongs);

                    //Отрисовка висилицы
                    service.drawGallows(countUserWrongs);

                    if (countToWin == countRandomWord) {
                        ++result;
                        System.out.println(secretWord);
                        break;
                    }
                } else {
                    //проверка на запрещенные символы
                    if (service.checkTry(a, dotaHeroes.forbiddenSymbols)) {
                        System.err.println("\n\tITS Forbidden Symbols!!");
                         continue;
                    } else if(userWrongs.indexOf(a) != -1) {
                        System.err.println("\n\tYou already entered it!!");
                        continue;
                    }else {
                        ++countUserWrongs;
                    }

                    //запись ошибочной буквы
                    service.addWrong(a, userWrongs);
                    System.out.println(" Wrong (" + countUserWrongs + "):" + userWrongs);
                    service.drawGallows(countUserWrongs);
                }
            }

            //Красивая победная надпись
            if (result == 0) {
                service.badEnd();
                System.err.println("It was: " + randomWord);
            } else {
                service.happyEnd();
            }

            System.out.println("Do you want to play again? (Again / N)");
            playAgain = scanner.next();

            if (playAgain.equals("Again") || playAgain.equals("again")) {
                countUserWrongs = 0;
                countToWin = 0;
                result = 0;
                randomWord = service.getRandomName(dotaHeroes.dotaHeroesNames);
                countRandomWord = service.getRandomNameCount(randomWord);
                countUserWrongs = 0;
                userWrongs = new StringBuilder();
                secretWord = service.createSecretWord(countRandomWord);
                checkList = service.splitName(randomWord);
            } else {
                System.out.println("Goodbye Friend");
                break;
            }
        }
    }
    ///////Game END
}







