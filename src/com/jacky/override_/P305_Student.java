package com.jacky.override_;

import javax.security.auth.login.CredentialNotFoundException;

public class P305_Student extends P305_Person {

    private int id;
    private double score;

    public P305_Student(String name, int age, int id, double score) {
        super(name, age);
        this.id = id;
        this.score = score;
    }

    public String say() {
        return super.say() + " ID is " + id + " score is " + score + " i'm student";
    }
}
