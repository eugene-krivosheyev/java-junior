package com.acme.edu.logger.core.output.formatter;

/**
 * Main console output formatter for log.
 *
 * @author Timur Kashapov.
 * @author Donation Nikolashin.
 * @since 0.0.1
 * */
public class ConsoleOutputFormatter implements IOutputFormatter {

    /** Active console output formatter. */
    private ConsoleOutputFormatter formatter;

    /** Formatter specs. */
    private boolean
            typesWillChanged,
            typesWillArrays,
            prefixesAndPostfixes,
            accumulateSums,
            countStringDuplicates;

    /**
     * Private constructor.
     */
    private ConsoleOutputFormatter() {
    }

    /**
     * Is message types changes ?
     * @return confirmation.
     */
    public boolean isTypesWillChanged() {
        return typesWillChanged;
    }

    /**
     * Is message types an arrays ?
     * @return confirmation.
     */
    public boolean isTypesWillArrays() {
        return typesWillArrays;
    }

    /**
     * Is message with prefixes and postfixes ?
     * @return confirmation.
     */
    public boolean isPrefixesAndPostfixes() {
        return prefixesAndPostfixes;
    }

    /**
     * Is message an accumulate the values of content ?
     * @return confirmation.
     */
    public boolean isAccumulateSums() {
        return accumulateSums;
    }

    /**
     * Is count a duplicates of string messages ?
     * @return confirmation.
     */
    public boolean isCountStringDuplicates() {
        return countStringDuplicates;
    }

    @Override
    public void typesWillChanged(boolean confirmation) {
        typesWillChanged = confirmation;
    }

    @Override
    public void typesWillArrays(boolean confirmation) {
        typesWillArrays = confirmation;
    }

    /**
     * Add necessity prefixes and postfixes.
     * @return active formatter.
     */
    public ConsoleOutputFormatter addPrefixesAndPostfixes(){
        prefixesAndPostfixes = true;
        return formatter; }

    /**
     * Accumulate the total sum of content values.
     * @return active formatter.
     */
    public ConsoleOutputFormatter accumulateSumOfContentValues(){
        accumulateSums = true;
        return formatter; }

    /**
     * Count the number of duplicate string.
     * @return active formatter.
     */
    public ConsoleOutputFormatter countStringRepeats() {
        countStringDuplicates = true;
        return formatter;
    }

    @Override
    public ConsoleOutputFormatter build() {
        return new ConsoleOutputFormatter();
    }
}
