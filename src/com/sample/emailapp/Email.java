package com.sample.emailapp;

import java.util.Scanner;

//This is class to create object
public class Email {

    //Declare variables as private so that other people can not have direct access / encapsulation
    private String firstName;
    private String lastName;
    private String password;
    private int defaultPasswordLength = 9;
    private String department;
    private int mailboxCapacity = 350;
    private String email;
    private String companySuffix = "abc.com";
    private String alternateEmail;

    // use constructor to receive first and last name
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Full Name : " + this.firstName + " "+ this.lastName);

        // Call method for department
        this.department = setDepartment();
        System.out.println("Department " + this.department);

       // Call method for the random password
        this.password = randomPassword(6);
        System.out.println("Random Password " + this.password);

        // Combine all required elements to get the company email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
        System.out.println("Your Company Emial Created " +email);

    }

    // Ask for department
    private String setDepartment(){
        System.out.print("Type of Department\n 1 for Sales\n 2 for Development\n 3 for Accounting\n 0 for None");
        Scanner sc = new Scanner(System.in);
        int departmentChoice = sc.nextInt();
        if(departmentChoice == 1){
            return "sales";
        } else if (departmentChoice == 2) {
            return "dev";
        } else if (departmentChoice == 3) {
            return "acc";
        } else if (departmentChoice == 0) {
            return "none";
        }
        return null;
    }

    // Generate a random password
    private String randomPassword(int length){
        String passwordChange = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@$#%%";
        char[] password = new char[length];
        for (int i = 0; i<length; i++){
            int rand = (int)(Math.random() * passwordChange.length());
            password[i] = passwordChange.charAt((rand));
        }
        return new String(password);
    }

    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    // Set the alternate email
    public void setAlternatemail(String altemail){
        this.alternateEmail = altemail;
    }
    // Change the password
    public void changePassword(String password){
        this.password = password;
    }
    public int getMailboxCapacity(){
        return mailboxCapacity;
    }
    public String getAlternateEmail(){
        return alternateEmail;
    }
    public String getPassword(){
        return password;
    }

    public String displayInfo(){
        return "Display Name : " + firstName + " " + lastName + " Company Email : " + email + " MailBox Capacity : " + mailboxCapacity;
    }
}
