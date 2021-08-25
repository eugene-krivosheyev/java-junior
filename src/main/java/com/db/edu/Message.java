package com.db.edu;

public class Message {
        private final String body; //state

        /**
         * Public API
         */
        public Message(String body) {
            this.body = body;
        }

        /**
         * Up-front design
         * @return
         */
        public String getBody() {
            return body;
        }

        public void log() {

        }

        @Override
        public String toString() {
            return "{ " + body  + " }";
        }
    }
