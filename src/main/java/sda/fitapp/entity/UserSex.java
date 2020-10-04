package sda.fitapp.entity;

public enum UserSex {
    FEMALE(-161), MALE(6), NOTSPECIFIED(0);

    private final int numVal;

    UserSex(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
}
