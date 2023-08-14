package gallows.main;

import gallows.model.Word;
import gallows.service.Service;
import gallows.service.ServiceImpl;

import java.util.Scanner;

public class Main {

   public static String testWord;
   public  static StringBuilder sample;

    public static void main(String[] args) {
        testWord = "nootebook";

        Service service = new ServiceImpl();

        Word sampleWord = new Word();




        //Set field

        int countWrongs = 0;
       sampleWord.setCount(service.getWordCount(testWord));
       sampleWord.setSample(service.createSample(sampleWord.getCount()));
       sampleWord.setList(service.splitWord(testWord));





        Scanner scanner = new Scanner(System.in);



        //Console

        System.out.println("Hi man\nLets star\nWrite char");

        System.out.println(sampleWord.getCount());
        System.out.println(sampleWord.getSample());
        System.out.println(sampleWord.getList());

        System.out.println(service.checkTry('o',service.splitWord(testWord)));

    }
}
