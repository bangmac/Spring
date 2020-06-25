package com.codegym.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User{
    @NotEmpty
    @Size(min = 2,max = 45)
    private String firstName;
    @NotEmpty
    @Size(min = 2,max = 45)
    private String lastName;

    private String phoneNum;
    @Min(18)
    private int age;
    @Email
    private String email;

    public User() {
    }

    public User(String firstName, String lastName, String phoneNum, int age, String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.age = age;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


//    @Override
//    public boolean supports(Class<?> clazz) {
//        return User.class.isAssignableFrom(clazz);
//    }

//    @Override
//    public void validate(Object target, Errors errors) {
//        User user = (User) target;
//        String number = user.getPhoneNum();
//        ValidationUtils.rejectIfEmpty(errors, "number", "number.empty");
//        if (number.length()>11 || number.length()<10){
//            errors.rejectValue("number", "number.length");
//        }
//        if (!number.startsWith("0")){
//            errors.rejectValue("number", "number.startsWith");
//        }
//        if (!number.matches("(^$|[0-9]*$)")){
//            errors.rejectValue("number", "number.matches");
//        }
//    }
}
