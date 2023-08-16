package gallows.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static gallows.main.StartGame.*;

public class ServiceImpl implements Service {

    Random random = new Random();

    @Override
    public int getRandomNameCount(String word) {
        return word.length();
    }

    @Override
    public List<String> createSecretWord(int count) {
        List<String> sample = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            sample.add("_ ");
        }
        return sample;
    }

    @Override
    public List splitName(String word) {
        char[] chars = word.toCharArray();
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
            return false;
        }
    }

    public StringBuilder addWrong(String userChar, StringBuilder list){
        list.append(userChar);
        list.append(", ");
        return list;
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

        if (number <=  1) {
            System.out.println(" ----------");
            System.out.println(" |        |");
            System.out.println(" |        0");
            System.out.println(" |        ");
            System.out.println(" |        ");
            System.out.println("_|_       ");
            
        } else if (number <=  2) {
            System.out.println(" ----------");
            System.out.println(" |        |");
            System.out.println(" |        0");
            System.out.println(" |        |");
            System.out.println(" |        ");
            System.out.println("_|_       ");

        } else if (number <=  3) {
            System.out.println(" ----------");
            System.out.println(" |        |");
            System.out.println(" |        0");
            System.out.println(" |       \\|");
            System.out.println(" |        ");
            System.out.println("_|_       ");
        }else if (number <=  4) {
            System.out.println(" ----------");
            System.out.println(" |        |");
            System.out.println(" |        0");
            System.out.println(" |       \\|/");
            System.out.println(" |        ");
            System.out.println("_|_       ");
        }
        else if (number <=  5) {
            System.out.println(" ----------");
            System.out.println(" |        |");
            System.out.println(" |        0");
            System.out.println(" |       \\|/");
            System.out.println(" |       /");
            System.out.println("_|_       ");
        }
        else if (number ==  6) {
            System.out.println(" ----------");
            System.out.println(" |        |");
            System.out.println(" |      |0_0|.....HeeeeeeT!!");
            System.out.println(" |      \\|/");
            System.out.println(" |      / \\");
            System.out.println("_|_       ");
        }
    }

    @Override
    public String getRandomName(List<String> list) {
        int randomIndex = random.nextInt(list.size());
        String randomWord = list.get(randomIndex);
        return randomWord;
    }


}
