package com.jacky.exception_;

public class CustomException {
    public static void main(String[] args) throws AgeException{

        int age = 180;
        if (!(age >= 18 && age <=120)) {
            throw new AgeException("age should be between 18-120");
        }
        System.out.println("age is correct");
    }
}


//自定义异常
class AgeException extends RuntimeException{
    public AgeException(String message) {
        super(message);
    }
}