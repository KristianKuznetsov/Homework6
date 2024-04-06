package star;

import java.sql.Array;
import java.util.Arrays;
import java.util.Random;

public class ATMValueGenerator {
    public static ATM generateATM(double[] weights, int lowBound, int upBound) {
        Random random = new Random();

        long count20 = random.nextInt(upBound - lowBound) + lowBound;
        long count50 = (long) (weights[1] * count20 / weights[0]);
        long count100 = (long) (weights[2] * count20 / weights[0]);

        if (count50 > Integer.MAX_VALUE) {
            count50 = Integer.MAX_VALUE;
        }

        if (count100 > Integer.MAX_VALUE) {
            count100 = Integer.MAX_VALUE;
        }

        return new ATM((int) count20, (int) count50, (int) count100);
    }

    public static int[] generateMoney(double[] weights, int lowBound, int upBound) {
        Random random = new Random();

        long count20 = random.nextInt(upBound - lowBound) + lowBound;
        long count50 = (long) (weights[1] * count20 / weights[0]);
        long count100 = (long) (weights[2] * count20 / weights[0]);

        if (count50 > Integer.MAX_VALUE) {
            count50 = Integer.MAX_VALUE;
        }

        if (count100 > Integer.MAX_VALUE) {
            count100 = Integer.MAX_VALUE;
        }

        return new int[]{(int) count20, (int) count50, (int) count100};
    }

    public static int getSum(int lowBound, int upBound) {
        Random random = new Random();
        int indicator = random.nextInt(101);

        int element;
        if (indicator > 90) {
            element = random.nextInt(upBound - lowBound) + lowBound;
            return element;
        } else {
            element = random.nextInt((upBound - lowBound) / 10) + lowBound / 10;
            return element * 10;
        }
    }
}
