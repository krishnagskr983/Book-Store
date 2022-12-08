package com.gskr;


// MagicOfBooks class performs storing Book and User Details, implementing functionality methods.

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


public class MagicOfBooks{

    ArrayList<User> users=new ArrayList<>();
    ArrayList<Book> books=new ArrayList<>();

    // Verifying Valid username or not
    public boolean isValidUserName(String userName){
        for(User user: users){
            if(user.getUserName().equalsIgnoreCase(userName))
                return true;
        }
        return false;
    }


    // Initializing User details
    public void userInitializer(){
        Map<String,ArrayList<Book>> adam=new LinkedHashMap<>();
        ArrayList<Book> adamNewBook=new ArrayList<>();
        adamNewBook.add(books.get(0));
        adam.put("New Books",adamNewBook);
        ArrayList<Book> adamFavourite=new ArrayList<>();
        adamFavourite.add(books.get(1));
        adamFavourite.add(books.get(2));
        adam.put("Favourite Books",adamFavourite);
        ArrayList<Book> adamCompleted=new ArrayList<>();
        adamCompleted.add(books.get(3));
        adam.put("Completed Books",adamCompleted);
        User adamSandler=new User("Adam Sandler",1,"Adam Sandler123@gmail.com","Adam Sandler123",adam);
        users.add(adamSandler);


        Map<String,ArrayList<Book>> tom=new LinkedHashMap<>();
        ArrayList<Book> tomNewBook=new ArrayList<>();
        tomNewBook.add(books.get(2));
        tom.put("New Books",tomNewBook);
        ArrayList<Book> tomFavourite=new ArrayList<>();
        tomFavourite.add(books.get(1));
        tomFavourite.add(books.get(3));
        tom.put("Favourite Books",tomFavourite);
        ArrayList<Book> tomCompleted=new ArrayList<>();
        tomCompleted.add(books.get(4));
        tom.put("Completed Books",tomCompleted);
        User tomHanks=new User("Tom Hanks",2,"Tom Hanks123@gmail.com","Tom Hanks123",tom);
        users.add(tomHanks);


        Map<String,ArrayList<Book>> cruise=new LinkedHashMap<>();
        ArrayList<Book> cruiseNewBook=new ArrayList<>();
        cruiseNewBook.add(books.get(1));
        cruise.put("New Books",cruiseNewBook);
        ArrayList<Book> cruiseFavourite=new ArrayList<>();
        cruiseFavourite.add(books.get(2));
        cruise.put("Favourite Books",cruiseFavourite);
        ArrayList<Book> cruiseCompleted=new ArrayList<>();
        cruiseCompleted.add(books.get(3));
        cruiseCompleted.add(books.get(4));
        cruise.put("Completed Books",cruiseCompleted);
        User tomCruise=new User("Tom Cruise",3,"Tom Cruise123@gmail.com","Tom Cruise123",cruise);
        users.add(tomCruise);


        Map<String,ArrayList<Book>> angelina=new LinkedHashMap<>();
        ArrayList<Book> angelinaNewBook=new ArrayList<>();
        angelinaNewBook.add(books.get(0));
        angelinaNewBook.add(books.get(4));
        angelina.put("New Books",angelinaNewBook);
        ArrayList<Book> angelinaFavourite=new ArrayList<>();
        angelinaFavourite.add(books.get(1));
        angelina.put("Favourite Books",angelinaFavourite);
        ArrayList<Book> angelinaCompleted=new ArrayList<>();
        angelinaCompleted.add(books.get(1));
        angelinaCompleted.add(books.get(3));
        angelina.put("Completed Books",angelinaCompleted);
        User angelinaJolie=new User("Angelina Jolie",4,"Angelina Jolie123@gmail.com","Angelina Jolie123",angelina);
        users.add(angelinaJolie);


        Map<String,ArrayList<Book>> scarlett=new LinkedHashMap<>();
        ArrayList<Book> scarlettNewBook=new ArrayList<>();
        scarlettNewBook.add(books.get(4));
        scarlett.put("New Books",scarlettNewBook);
        ArrayList<Book> scarlettFavourite=new ArrayList<>();
        scarlettFavourite.add(books.get(0));
        scarlett.put("Favourite Books",scarlettFavourite);
        ArrayList<Book> scarlettCompleted=new ArrayList<>();
        scarlettCompleted.add(books.get(3));
        scarlett.put("Completed Books",scarlettCompleted);
        User scarlettJohansson=new User("Scarlett Johansson",5,"Scarlett Johansson123@gmail.com","Scarlett Johansson123"
                , scarlett);
        users.add(scarlettJohansson);

    }


    // Initializing Book details
    public void bookInitializer(){
        Book ulysses=new Book("Ulysses","James Joyce","Ulysses by James Joyce",0);
        books.add(ulysses);

        Book donQuixote=new Book("Don Quixote","Miguel de Cervantes","Don Quixote by Miguel de Cervantes",1);
        books.add(donQuixote);

        Book solitude=new Book("One Hundred Years of Solitude","Gabriel Garcia Marquez","One Hundred Years of " +
                "Solitude by Gabriel Garcia Marquez",2);
        books.add(solitude);

        Book hamlet=new Book("Hamlet","William Shakespeare","Hamlet by William Shakespeare", 3);
        books.add(hamlet);

        Book search=new Book("In Search of Lost Time","Marcel Proust","In Search of Lost Time by Marcel Proust",4);
        books.add(search);
    }


    // Printing User books
    public void printBooks(String userName){
        for(User user: users){
            if(user.getUserName().equalsIgnoreCase(userName)){
                Map<String,ArrayList<Book>> map=user.getMap();
                for(Map.Entry<String,ArrayList<Book>> entry: map.entrySet()){
                    String key=entry.getKey();
                    ArrayList<Book> value=entry.getValue();
                    System.out.println(key+": ");
                    for(Book book: value)
                        System.out.println(book.getBookName());
                }
                break;
            }
        }

    }


    // Searching book is available or not by bookId
    public void searchBookId(String userName, int bookId) {
        boolean found = false;
        fn:for (User user : users) {
            if (user.getUserName().equalsIgnoreCase(userName)) {
                Map<String, ArrayList<Book>> map = user.getMap();
                for (Map.Entry<String, ArrayList<Book>> entry : map.entrySet()) {
                    String key = entry.getKey();
                    ArrayList<Book> value = entry.getValue();
                    for (Book book : value) {
                        if (book.getBookId() == bookId) {
                            found = true;
                            break fn;
                        }
                    }
                }
            }
        }
        if(found)
            System.out.println("Available");
        else
            System.out.println("Unavailable");
    }


    // Searching Book details by using book name
    public void searchBookName(String userName, String bookName) {
        boolean found = true;
        fn:for (User user : users) {
            if (user.getUserName().equalsIgnoreCase(userName)) {
                Map<String, ArrayList<Book>> map = user.getMap();
                for (Map.Entry<String, ArrayList<Book>> entry : map.entrySet()) {
                    String key = entry.getKey();
                    ArrayList<Book> value = entry.getValue();
                    for (Book book : value) {
                        if (book.getBookName().equalsIgnoreCase(bookName)) {
                            System.out.println("Author: "+book.getAuthorName());
                            System.out.println("Description: "+book.getDescription());
                            found = false;
                            break fn;
                        }
                    }
                }
            }
        }
        if(found)
            System.out.println("Book not found!");
    }


}
