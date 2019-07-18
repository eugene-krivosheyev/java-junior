package com.acme.edu;

public interface CommandMessage {
    MessageTypeName getTypeName();

    void accumulate(ControllerState state);
    void typeSwitchUpdate(ControllerState state);
}
