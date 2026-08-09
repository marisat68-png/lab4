package com.example.lab4;

public class GuestUser {
    //Attribute
    private String sessionToken;
    private int maxNotesLimit;

    //Method
    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public int getMaxNotesLimit() {
        return maxNotesLimit;
    }

    public void setMaxNotesLimit(int maxNotesLimit) {
        this.maxNotesLimit = maxNotesLimit;
    }

    public void clearCacheData() {
        System.out.println("Clearing cache data for session: " + sessionToken);
    }
}

