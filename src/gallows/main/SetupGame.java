package gallows.main;

import gallows.model.DotaHeroes;
import gallows.service.Service;
import gallows.service.ServiceImpl;

import java.util.List;

public class SetupGame {
    DotaHeroes dotaHeroes = new DotaHeroes();
    Service serviceManager = new ServiceImpl();

    /*
    1.�������� ��������� �����
    2.�������� ����������� ����
    3. �� ������ ����� ������� ��������� �����
    4. ��� ����� ���� ��� ��������
    5. ������� ����������� ������
    6. ������� ����������� ���������� �������
    7. ������ ��������� ����
     */

     String randomHeroName = serviceManager.getRandomName(dotaHeroes.dotaHeroesNames);
     int randomHeroNameCount = serviceManager.getRandomNameCount(randomHeroName);
     List<String> secretWord = serviceManager.createSecretWord(randomHeroNameCount);
     List<String> checkList = serviceManager.splitName(randomHeroName);

    int countWrong = 0;

     StringBuilder wrongs = new StringBuilder();
}
