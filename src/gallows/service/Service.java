package gallows.service;

import java.util.List;

public interface Service {

     int getRandomNameCount(String word);

     List<String> createSecretWord(int count);

     List splitName(String word);

     boolean checkTry(String userChar, List<String> list);

     List<String> rewrite(List<String> list1, List<String> list, String str);

     void happyEnd();
     void badEnd();

     void drawGallows(int number);

     String getRandomName(List<String> list);

     StringBuilder addWrong(String userChar, StringBuilder list);
}
