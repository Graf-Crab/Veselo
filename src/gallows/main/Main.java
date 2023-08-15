package gallows.main;

import gallows.model.Word;
import gallows.service.Service;
import gallows.service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

   public static String testWord;
   public static  int countToWin = 0;

   public static StringBuilder listWithWrongs = new StringBuilder();
    //public static List<String> listWithWrongs = new ArrayList<>();

    public static void main(String[] args) {
        testWord = "nootebook";

        Service service = new ServiceImpl();

        Word sampleWord = new Word();

        //Set field

        int countWrongs = 0;

        int result = 0;

       sampleWord.setCount(service.getWordCount(testWord));
       sampleWord.setSample(service.createSample(sampleWord.getCount()));
       sampleWord.setList(service.splitWord(testWord));
       List<String> stringBuilder = sampleWord.getSample();


        Scanner scanner = new Scanner(System.in);

        //Console
        System.out.println("Hi man\nLets star");

        //Отгадывание
        while(countWrongs != sampleWord.getCount()){

            //загаданное слово в виде _ _ _ _ _
            System.out.println(stringBuilder);

            String a = scanner.next();

            if (service.checkTry(a,sampleWord.getList())) {

                service.rewrite(stringBuilder,sampleWord.getList(),a);
                System.out.println(" Wrong (" +countWrongs+"):" + listWithWrongs);

                if((countToWin == sampleWord.getCount())){
                    ++result;
                    System.out.println(stringBuilder);
                  break;
                }
            } else {
                ++countWrongs;
                System.out.println(" Wrong (" +countWrongs+"):" + listWithWrongs);
            }
        }

        //Красивая победная надпись
       if (result == 0){
           service.badEnd();
       }else {
           service.happyEnd();
       }
    }
}
