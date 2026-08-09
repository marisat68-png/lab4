package com.example.lab4;

public class MemberUser {
    //Attribute
    private String memberId;
    private String expireDate;

    //Method
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public void saveNoteToCloud() {
        System.out.println("Saving note to cloud for member: " + memberId);
    }
}

