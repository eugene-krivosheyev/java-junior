package buffer;

import message.Message;

public class NumberBuffer extends Buffer {

    public NumberBuffer() {
        prefix = "primitive: ";
    }

    public long checkOverflow(long result, int max, int min) {
        if (result > max) {
            return result - max;
        }
        if (result < min) {
            return result + min;
        }
        return result;
    }

    public int countSum(int externalSum, int income, Integer max, Integer min) {
        long sum = (long)externalSum + (long)income;
        long result = checkOverflow(sum, max, min);

        if (result > sum) {
            extraOrdinary.add(min.toString());
        } else if (result < sum) {
            extraOrdinary.add(max.toString());
        }
        return (int)result;
    }
}
