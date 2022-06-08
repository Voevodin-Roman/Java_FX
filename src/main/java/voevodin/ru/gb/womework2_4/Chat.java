package voevodin.ru.gb.womework2_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Chat {
    private final int[] quessNum;

    public String getQuessNum() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < quessNum.length; i++) {
            stringBuilder.append(quessNum[i]);

        }

        return stringBuilder.toString();
    }

    public Chat() {
        this.quessNum = generateNumber();
        System.out.println(Arrays.toString(quessNum));
    }
    public  BulsAndCowsCount calculateBullsAndCows(String playerNum){
        int bulls = 0, cows = 0;
        for (int i = 0; i < quessNum.length; i++) {
            if (quessNum[i] == playerNum.charAt(i) - '0'){
                bulls ++;
            }else if(playerNum.contains(String.valueOf(quessNum[i]))){
                cows++;
            }

        }
        return new BulsAndCowsCount(bulls, cows);
    }
    public  static class BulsAndCowsCount{
        private final int bulls;
        private final int cows;

        public BulsAndCowsCount(int bulls, int cows) {
            this.bulls = bulls;
            this.cows = cows;
        }

        public int getBulls() {
            return bulls;
        }

        public int getCows() {
            return cows;
        }
    }
    private int[] generateNumber() {
            final List<Integer> numbers = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
            Collections.shuffle(numbers);

            return new int[]{numbers.get(0), numbers.get(1), numbers.get(2), numbers.get(3)};

    }
}
