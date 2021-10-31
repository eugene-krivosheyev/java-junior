package accumulator;

abstract class NumberAccumulator implements Accumulator {

    protected final String prefix = "primitive: ";
    protected UnpromptLineKeeper unpromtLineKeeper = new UnpromptLineKeeper(prefix);

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
            unpromtLineKeeper.add(min.toString());
        } else if (result < sum) {
            unpromtLineKeeper.add(max.toString());
        }
        return (int)result;
    }
}
