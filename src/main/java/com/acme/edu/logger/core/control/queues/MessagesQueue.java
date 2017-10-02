package com.acme.edu.logger.core.control.queues;

import com.acme.edu.logger.core.message.Message;

/** */
public class MessagesQueue {

    /** */
    private Message[] queue;

    /** */
    protected Message prevoiusMessage, currentMessage;

    /** */
    private int capacity;
    private int amount;
    private int tail;
    private int i;
    protected int sum;

    /** Constructor. */
    MessagesQueue() {
        capacity = 10;
        i        = 0;
        tail     = capacity - 1;
        queue    = new Message[capacity];
    }

    /** Constructor with set capacity. */
    MessagesQueue(int capacity) {
        this.capacity = capacity;
        i     = 0;
        tail  = capacity - 1;
        queue = new Message[capacity];
    }

    /**
     * Extend the queue.
     */
    private void extendQueue() {
        capacity *= 2;
        Message[] tmp = new Message[capacity];
        for (int j = 0; j < queue.length; ++j) { tmp[j] = queue[j]; }
        queue = tmp;
    }

    /** Add element to end of queue. */
    public void add(Message message) {

        if ( (capacity - amount) <= 1 ) {
            extendQueue();
            queue[i++] = message;
        } else {
            queue[i++] = message;
        }
    }

    /**
     * Get first element of queue.
     * @return first message.
     */
    public Message get() { return queue[0]; }

    /**
     * Get i element of queue.
     * @return first message.
     */
    public Message get(int index) {
        return queue[index];
    }

    /**
     * Get amount of elements in queue.
     * @return amount.
     */
    public int getAmount() {
        return amount;
    }

}
