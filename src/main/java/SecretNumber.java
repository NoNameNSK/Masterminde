import java.util.Random;

public class SecretNumber {
    private int[] number;

    public SecretNumber() {
        Random random = new Random();
        this.number = getIntArr(random.ints(1000, 9999).findFirst().getAsInt());
    }

    public int[] checkAnswer(int answer) {
        int[] numberInts = number.clone();
        int[] answerInts = getIntArr(answer);
        int cows = 0;
        int bulls = 0;

        for (int i = 0; i < numberInts.length; i++) {
            if (numberInts[i] == answerInts[i]) {
                bulls++;
                numberInts[i] = -1;
                answerInts[i] = -2;
            }
        }

        for (int i = 0; i < numberInts.length; i++) {
            for (int j = 0; j < answerInts.length; j++) {
                if (numberInts[i] == answerInts[j]) {
                    cows++;
                    numberInts[i] = -1;
                    answerInts[j] = -2;
                    break;
                }
            }
        }

        return new int[]{cows, bulls};
    }

    private int[] getIntArr(int number) {
        return new int[]{
                number / 1000,
                (number % 1000) / 100,
                ((number % 1000) % 100) / 10,
                ((number % 1000) % 100) % 10};
    }

    public int getAnswer() {
        return number[0] * 1000 + number[1] * 100 + number[2] * 10 + number[3];
    }

    public void setNumber(int number) {
        this.number = getIntArr(number);
    }
}
