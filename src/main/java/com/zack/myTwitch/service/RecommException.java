package com.zack.myTwitch.service;

public class RecommException extends RuntimeException {
    public RecommException(String errorMessage) {
        super(errorMessage);
    }
}
