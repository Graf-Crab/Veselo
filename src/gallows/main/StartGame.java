package gallows.main;

import gallows.model.DotaHeroes;
import gallows.service.Service;
import gallows.service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartGame {


    //public static StringBuilder listWithWrongs = new StringBuilder();
   public static int countToWin = 0;

    public static void main(String[] args) {


        Service service = new ServiceImpl();
        SetupGame setupGame = new SetupGame();

        /*
        ..1 вариант разворачиваю поля
        1. Случайное слово
        2. Колличество символов
        3 Колличество ошибок
        4. Стрингбилдер для ошибок

         */

        String randomWord = setupGame.randomHeroName;
        int countRandomWord = setupGame.randomHeroNameCount;
        int countUserWrongs = setupGame.countWrong;
        StringBuilder userWrongs = setupGame.wrongs;
        List<String> secretWord = setupGame.secretWord;
        List<String> checkList = setupGame.checkList;



        int result = 0;

        //Set field

        Scanner scanner = new Scanner(System.in);

        //Console
        System.out.println("Hi man\nLets star");
       /* char playAgain = 'y';

        //Start game
        while (playAgain == 'y' || playAgain == 'Y') {

            System.out.print("Play again? (y/n): ");

            playAgain = scanner.next().charAt(0);

            if (playAgain == 'y' || playAgain == 'Y') {
                //reload  field
                countUserWrongs = 0;
                listWithWrongs = new StringBuilder("");
                randomWord = service.getRandomName(dotaHeroes.manyNames);
                countRandomWord = wordManager.getCount();
                secretWord = wordManager.getSample();
                userListWord = new ArrayList<>(); */


        while (countUserWrongs != 6) {

            //загаданное слово в виде _ _ _ _ _
            System.out.println(secretWord);

            String a = scanner.next();

            if (service.checkTry(a, checkList)) {
                service.rewrite(secretWord, checkList, a);
                System.out.println(" Wrong (" + countUserWrongs + "):" + userWrongs);
                //service.drawGallows(countUserWrongs);


                if (countToWin == countRandomWord) {
                    ++result;
                    System.out.println(secretWord);
                    break;
                }
            } else {
                ++countUserWrongs;
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


    }
}





