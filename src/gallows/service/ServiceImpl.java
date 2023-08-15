package gallows.service;



import java.util.ArrayList;
import java.util.List;

import static gallows.main.Main.*;

public class ServiceImpl implements Service {

    @Override
    public int getWordCount(String word) {
        return word.length();
    }

    @Override
    public List<String> createSample(int count) {
        List<String> sample = new ArrayList<>();

        for (int i = 0; i < getWordCount(testWord); i++) {
            sample.add("_ ");
        }
        return sample;
    }

    @Override
    public List splitWord(String word) {
        char[] chars = testWord.toCharArray();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            list.add(String.valueOf(chars[i]));
        }
        return list;
    }

    @Override
    public boolean checkTry(String userChar, List<String> list) {

        if (list.contains(userChar)) {
            return true;
        } else {
            //listWithWrongs.add(userChar);
            listWithWrongs.append(userChar);
            listWithWrongs.append(", ");
            return false;
        }
    }

    @Override
    public List<String> rewrite(List<String> list1, List<String> list, String str) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(str)) {
                list1.set(i, str);
                ++countToWin;
            }
        }
        return list1;
    }

    @Override
    public void happyEnd() {
        System.out.println("\n=*=*=*=*=*=*=*=*=*=*=*=*=*=\nCongratulations!!!!\nYou WIN\n=*=*=*=*=*=*=*=*=*=*=*=*=*=");
    }

    @Override
    public void badEnd() {
        System.out.println("\n=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=\nYou LOSEEE\n=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
        System.out.println("ahahaha");
    }

    @Override
    public void drawGallows(int number) {

        //1%
         double progressBar = (double)100 / 9;


        double progressWrong = progressBar * (double) number;

        if (progressWrong <=  13.0){
                System.out.println(" ----------");
                System.out.println(" |        |");
                System.out.println(" |        ");
                System.out.println(" |        ");
                System.out.println(" |        ");
                System.out.println("_|_       ");
        } else if (progressWrong <=  26.0) {
            System.out.println(" ----------");
            System.out.println(" |        |");
            System.out.println(" |        0");
            System.out.println(" |        ");
            System.out.println(" |        ");
            System.out.println("_|_       ");
            
        } else if (progressWrong <=  39.0) {
            System.out.println(" ----------");
            System.out.println(" |        |");
            System.out.println(" |        0");
            System.out.println(" |        |");
            System.out.println(" |        ");
            System.out.println("_|_       ");

        } else if (progressWrong <=  52.0) {
            System.out.println(" ----------");
            System.out.println(" |        |");
            System.out.println(" |        0");
            System.out.println(" |       \\|");
            System.out.println(" |        ");
            System.out.println("_|_       ");
        }else if (progressWrong <=  65.0) {
            System.out.println(" ----------");
            System.out.println(" |        |");
            System.out.println(" |        0");
            System.out.println(" |       \\|/");
            System.out.println(" |        ");
            System.out.println("_|_       ");
        }
        else if (progressWrong <=  78.0) {
            System.out.println(" ----------");
            System.out.println(" |        |");
            System.out.println(" |        0");
            System.out.println(" |       \\|/");
            System.out.println(" |       /");
            System.out.println("_|_       ");
        }
        else if (progressWrong <=  92.0) {
            System.out.println(" ----------");
            System.out.println(" |        |");
            System.out.println(" |      |0_0|.....HeeeeeeT!!");
            System.out.println(" |      \\|/");
            System.out.println(" |      / \\");
            System.out.println("_|_       ");
        }
    }


}
