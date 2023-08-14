package gallows.service;



import java.util.ArrayList;
import java.util.List;

import static gallows.main.Main.testWord;

public class ServiceImpl implements Service {

    @Override
    public int getWordCount(String word) {
        return word.length();
    }

    @Override
    public StringBuilder createSample(int count) {
        StringBuilder sample = new StringBuilder();

        for (int i = 0; i<getWordCount(testWord);i++){
            sample.append("_ ");
        }
        return sample;
    }

    @Override
    public List splitWord(String word) {
        char[] chars = testWord.toCharArray();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i<chars.length;i++){
            list.add(chars[i]);
        }
        return list;
    }

    @Override
    public boolean checkTry(char userChar, List<Character> list) {

        if(list.contains(userChar)){
            return true;
        }
        return false;
    }



}
