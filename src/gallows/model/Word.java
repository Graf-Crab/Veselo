package gallows.model;

import java.util.List;

public class Word {

    private char userChar;

    private int countWrongs;

    private int count;

    private List<String> sample;

    private List<String> list;

    private StringBuilder listWithWrongs;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<String> getSample() {
        return sample;
    }

    public void setSample(List<String> sample) {
        this.sample = sample;
    }

    public char getUserChar() {
        return userChar;
    }

    public void setUserChar(char userChar) {
        this.userChar = userChar;
    }

    public int getCountWrongs() {
        return countWrongs;
    }

    public void setCountWrongs(int countWrongs) {
        this.countWrongs = countWrongs;
    }

    public StringBuilder getListWithWrongs() {
        return listWithWrongs;
    }

    public void setListWithWrongs(StringBuilder listWithWrongs) {
        this.listWithWrongs = listWithWrongs;
    }
}
