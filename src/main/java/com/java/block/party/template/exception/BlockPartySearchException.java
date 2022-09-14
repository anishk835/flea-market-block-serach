package com.java.block.party.template.exception;

public class BlockPartySearchException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BlockPartySearchException() {
        super();
    }

    public BlockPartySearchException(String msg) {
        super(msg);
    }

    public BlockPartySearchException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
}
