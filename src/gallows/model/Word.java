package gallows.model;

import java.util.List;

public class Word {

    private char userChar;

    private int countWrongs;

    private int count;

    private StringBuilder sample;

    private List<Character> list;

    public List<Character> getList() {
        return list;
    }

    public void setList(List<Character> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public StringBuilder getSample() {
        return sample;
    }

    public void setSample(StringBuilder sample) {
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
}
