import java.util.*;

public class SecretNumber {
    private int[] number;

    public SecretNumber() {
        Random random = new Random();
        this.number = getIntArr(random.ints(1000, 9999).findFirst().getAsInt());
    }

    public int[] checkAnswer(int answer) {
        int[] answerInts = getIntArr(answer);
        int b = getBulls(answerInts);
        return new int[]{getCows(answerInts) - b, b};
    }

    private int getBulls(int[] answer) {
        int c = 0;
        int bulls = 0;
        do {
            if (number[c] == answer[c])
                bulls++;
            c++;
        } while (c < number.length);
        return bulls;
    }

    private int getCows(int[] answer) {
        int cows = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : number){
            if (map.containsKey(i)) {
                map.replace(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        for (int i : answer){
            if(map.containsKey(i)){
                cows = cows + 1;
                map.replace(i, map.get(i) - 1);
            }
        }
        return cows;
    }

    private int[] getIntArr(int number){
        return new int[]{
                number / 1000,
                (number % 1000) / 100,
                ((number % 1000) % 100) / 10,
                ((number%1000)%100)%10};
    }

    public int getAnswer() {
        return number[0] * 1000 + number[1] * 100 + number[2] * 10 + number[3];
    }

    public void setNumber(int number) {
        this.number = getIntArr(number);
    }
}
