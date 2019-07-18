package com.acme.edu;

public interface CommandMessage {
    public MessageTypeName getTypeName();

    public void accumulate(ControllerState state);
    public void typeSwitchUpdate(ControllerState state);
}
