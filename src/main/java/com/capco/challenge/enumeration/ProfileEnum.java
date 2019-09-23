package com.capco.challenge.enumeration;

public enum ProfileEnum {

    ADMIN(1),USER(2);

    public int profileCode;

    ProfileEnum(int profileCode) {
        profileCode = profileCode;
    }
}