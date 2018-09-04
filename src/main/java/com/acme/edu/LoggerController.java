package com.acme.edu;

import com.acme.edu.exception.AccumulateException;
import com.acme.edu.exception.DecorateException;
import com.acme.edu.exception.FlushException;
import com.acme.edu.exception.SaveException;
import com.acme.edu.message.Message;
import com.acme.edu.saver.ConsoleSaver;
import com.acme.edu.saver.FileSaver;
import com.acme.edu.saver.Saver;

import java.util.Collection;
import java.util.LinkedList;

public class LoggerController {
    private Message currentMessage = null;
    private Saver saver = new FileSaver();
    private Collection<Message> collectedMessages = new LinkedList<>();

    public void log(Message message) {
        try {
            if (currentMessage == null) {
                Message decoratedMessage = message.decorate();
                this.saver.save(decoratedMessage);
                this.currentMessage = message;
                this.collectedMessages.add(message);
                return;
            }
            if (currentMessage.isInstanceOf(message)) {
                this.collectedMessages.add(message);
            } else {
                this.currentMessage = collectedMessages.stream()
                    .reduce((message1, message2) -> {
                        Message result = null;
                        try {
                            result = message1.accumulate(message2);
                        } catch (AccumulateException e) {
                            e.printStackTrace();
                        }
                        return result;
                    }).get();

                Message decoratedMessage = currentMessage.decorate();
                saver.save(decoratedMessage);
                this.currentMessage = message;
                this.collectedMessages.add(message);
            }
            saver.save(message.decorate());
        } catch (DecorateException | SaveException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void flush() throws FlushException {
        try {
            this.saver.save(currentMessage.decorate());
            currentMessage = null;
            this.collectedMessages.clear();
        } catch (NullPointerException e) {
            throw new FlushException(e);
        } catch (Exception e) {
            throw new FlushException(e);
        }
    }

    public void setSaver(Saver saver) {
        this.saver = saver;
    }
}
