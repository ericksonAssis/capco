package com.capco.challenge.enumeration;

public enum ProfileEnum {

    ADMIN(0),USER(1);

    public int profileCode;

    ProfileEnum(int profileCode) {
        profileCode = profileCode;
    }
}