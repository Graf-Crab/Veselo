package gallows.service;

import java.util.List;

public interface Service {

     int getWordCount(String word);

     List<String> createSample(int count);

     List splitWord(String word);

     boolean checkTry(String userChar, List<String> list);

     List<String> rewrite(List<String> list1, List<String> list, String str);

     void happyEnd();
     void badEnd();



}
