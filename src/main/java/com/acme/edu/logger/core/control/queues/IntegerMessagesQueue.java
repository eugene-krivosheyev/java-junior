package com.acme.edu.logger.core.control.queues;

import com.acme.edu.logger.core.message.IntegerMessage;

/**
 * Queue of integer primitive type messages.
 */
public class IntegerMessagesQueue extends MessagesQueue {

    /**
     *
     */
    private IntegerMessage[] queue;

    /**
     * Total sum of element values.
     */
    private int totalSum;

    /**
     * Is overflow of total sum of elements values.
     */
    private boolean isOverflow;

    /**
     * Get total sum of element values.
     * @return sum.
     */
    public int getSumOfElementsContent() {
        return totalSum;
    }

    /**
     * Check the overflow of total sum of elements values.
     */
    public boolean checkOverflowOfTotalSum() {



        return isOverflow;
    }
}
