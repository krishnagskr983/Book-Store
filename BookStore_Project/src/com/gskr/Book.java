package com.gskr;


// Book class performs initializing Book details

public class Book {
    private final String bookName;
    private final String authorName;
    private final String description;
    private final int bookId;


    // Book Constructor
   public Book(String bookName, String authorName, String description, int bookId){
        this.bookName=bookName;
        this.authorName=authorName;
        this.description=description;
        this.bookId=bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getDescription() {
        return description;
    }

    public int getBookId() {
        return bookId;
    }


}
