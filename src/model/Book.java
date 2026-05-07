package model;

public class Book {

    private int id;
    private String title;
    private String author;
    private boolean isIssued;

    //Constructor
    public Book(String title, String author){
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    //Getters
    public int getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public boolean isIssued(){
        return isIssued;
    }

    //Setter
    public void setIssued(boolean issued){
        isIssued = issued;
    }

    //Display method
    public void displayBook(){
        System.out.println("ID : " + id + ", Title: " + title + ", Author: " + author + ", Issued: " + isIssued);
    }
}
