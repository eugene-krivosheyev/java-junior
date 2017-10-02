package com.acme.edu.logger.core.output.formatter;

/**
 * Main output formatter for output data.
 *
 * @author Timur Kashapov.
 * @author Donatio Nikolashin.
 * @since 0.0.1
 */
public interface IOutputFormatter {

    /** Prefix for each message content type. */
    String  /*: */
            PREFIX_COLON     = ": ",
            POSTFIX_NEWLINE  = "\n";

    String  /*primitive: */
            PREFIX_PRIMITIVE = "primitive" + PREFIX_COLON,
            PREFIX_CHAR      = "char"      + PREFIX_COLON,
            PREFIX_STRING    = "string"    + PREFIX_COLON,
            PREFIX_REFERENCE = "reference" + PREFIX_COLON;

    String  /*primitive array: */
            PREFIX_ARRAY           = " array",
            PREFIX_PRIMITIVE_ARRAY = PREFIX_PRIMITIVE + PREFIX_ARRAY + PREFIX_COLON,
            PREFIX_CHAR_ARRAY      = PREFIX_CHAR      + PREFIX_ARRAY + PREFIX_COLON,
            PREFIX_STRING_ARRAY    = PREFIX_STRING    + PREFIX_ARRAY + PREFIX_COLON,
            PREFIX_REFERENCE_ARRAY = PREFIX_REFERENCE + PREFIX_ARRAY + PREFIX_COLON;

    String  /* matrix*/
            PREFIX_MATRIX = " matrix";

    /**
     * Will message types is changes in log ?
     * @param confirmation confirmation.
     */
    void typesWillChanged(boolean confirmation);

    /**
     * Will message types is arrays ?
     * @param confirmation confirmation.
     */
    void typesWillArrays(boolean confirmation);

    /**
     * Build the specs output formatter.
     * @return complete formatter.
     */
    IOutputFormatter build();
}
