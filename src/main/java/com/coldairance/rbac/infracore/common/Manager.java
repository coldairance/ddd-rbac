package com.coldairance.rbac.infracore.common;



public abstract class Manager {

    private ManagerState state;

    public ManagerState getState() {
        return state;
    }

    public void updateState(ManagerState state) {
        this.state = state;
    }
}
