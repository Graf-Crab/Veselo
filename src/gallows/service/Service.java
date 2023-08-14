package gallows.service;

import java.util.List;

public interface Service {

     int getWordCount(String word);

     StringBuilder createSample(int count);

     List splitWord(String word);

     boolean checkTry(char userChar, List<Character> list);


}
