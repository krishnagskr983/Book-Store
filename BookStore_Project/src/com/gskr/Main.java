package com.gskr;


// Main class performs User Login and Menu options

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{

   private static final MagicOfBooks magicOfBooks=new MagicOfBooks();
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        Main main=new Main();

        // Initializing book details with bookInitializer() constructor
        magicOfBooks.bookInitializer();

        // Initializing user details with userInitializer() constructor
        magicOfBooks.userInitializer();

        // Initialize thread for userAccount() method
        Thread userAccount=new Thread(Main::userAccount);
        userAccount.start();
        userAccount.join();
    }



// User Login and Menu options
   static void userAccount() throws InputMismatchException {
       try {
           do {
               System.out.println("Please enter userName");
               String userName = sc.nextLine();
               if (!magicOfBooks.isValidUserName(userName))
                   throw new InvalidUserException("Sorry! You are not an authorized user");

               System.out.println("Welcome " + userName + "!");
               System.out.println("************** MENU ***********");
               System.out.println("1.Print your books (new,favourite,completed)");
               System.out.println("2.Find book by bookId");
               System.out.println("3.Print the details of a book");
               System.out.println("Please enter your choice:");
               int option = sc.nextInt();
               sc.nextLine();
               switch (option) {
                   case 1:
                       magicOfBooks.printBooks(userName);
                       break;
                   case 2:
                       try {
                           System.out.println("Please enter book id:");
                           int bookId = sc.nextInt();
                           sc.nextLine();
                           magicOfBooks.searchBookId(userName, bookId);
                           break;
                       }
                       catch(InputMismatchException e){
                           System.out.println("You entered wrong input for bookId");
                       }
                   case 3:
                       System.out.println("Please enter book name");
                       String bookName = sc.nextLine();
                       magicOfBooks.searchBookName(userName, bookName);
                       break;
                   default:
                       System.out.println("Wrong choice");
               }
               System.out.println("Do you want to continue? Press Yes");

           } while (sc.nextLine().equalsIgnoreCase("yes"));
       }
       catch (InvalidUserException e) {
           System.out.println(e.getMessage());
       }
   }


}