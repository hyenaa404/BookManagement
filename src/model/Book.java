/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 */
public class Book {
    private String id;
    private String name;
    private String author;
    private String issueNumber;

    public Book() {
    }

    public Book(String id, String name, String author, String issueNumber) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.issueNumber = issueNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(String issueNumber) {
        this.issueNumber = issueNumber;
    }
    
    @Override
    public String toString() {
        return id + "," + name + "," + author + "," + issueNumber ;
    }
    
    public String displayBook(){
        System.out.printf("%-15s|%-30s|%-30s|%-15s\n", id, name, author, issueNumber);
        return"";
    }
    
}
