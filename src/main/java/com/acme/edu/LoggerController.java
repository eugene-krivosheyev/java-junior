package com.acme.edu;

import com.acme.edu.message.Message;

public class LoggerController {
    private Message currentMessage = null;
    private Saver saver = new Saver();

    public void log(Message message) {
        try {
            if (currentMessage == null) {
                Message decoratedMessage = message.decorate();
                this.saver.save(decoratedMessage);
                this.currentMessage = message;
                return;
            }
            if (currentMessage.isInstanceOf(message)) {
                this.currentMessage = currentMessage.accumulate(message);
            } else {
                Message decoratedMessage = currentMessage.decorate();
                saver.save(decoratedMessage);
                this.currentMessage = message;
            }
            saver.save(message.decorate());
        } catch (DecorateException e) {
            System.out.println(e.getMessage());
        } catch (AccumulateException e) {
            System.out.println(e.getMessage());
        } catch (SaveException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void flush() throws FlushException {
        try {
            this.saver.save(currentMessage.decorate());
            currentMessage = null;
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
