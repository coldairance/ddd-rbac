package com.coldairance.rbac.infracore.common;

public enum ManagerState {

    READY(0),
    EXECUTING(1);


    private final int code;

    ManagerState(int code) {
        this.code = code;
    }


    public ManagerState of(int code) {
        for(ManagerState state: values()) {
            if(code == state.code) return state;
        }
        return null;
    }
}
