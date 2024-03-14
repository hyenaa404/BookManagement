/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author nhs
 */
public class BookList {
    List<Book> bookList = new ArrayList<>();

    public List<Book> getDataList() {
        return bookList;
    }

    public void setDataList(List<Book> dataList) {
        this.bookList = dataList;
    }
    
    public void readFile(String filePath) {
        try {
            File file = new File(filePath);
            FileReader fileReader = null;
            BufferedReader bufferedReader = null;
            try {
                fileReader = new FileReader(file);
                bufferedReader = new BufferedReader(fileReader);
                String line = bufferedReader.readLine();
                
                while (line != null) {
                    String[] parts = line.split(",");
                    String id = parts[0];
                    String name = parts[1];
                    String author = parts[2];
                    String issueNumber = parts[3];
                    Book book = new Book(id, name, author, issueNumber);
                    bookList.add(book);
                    line = bufferedReader.readLine();

                }
            } catch (FileNotFoundException ex) {
                System.err.println("File not found.");
            } finally {

                bufferedReader.close();
                fileReader.close();
            }
        } catch (IOException e) {
            System.err.println("Failed when reading file.");
        }
       
    }
    
    public boolean addList(Book b){
        for (Book book : bookList){
            if (book.getId().equalsIgnoreCase(b.getId())){
                return false;
            }
        }
        bookList.add(b);
        return true;
    }
    
    public boolean removeList(String id){
        for (Book book : bookList){
            if (book.getId().equalsIgnoreCase(id)){
                bookList.remove(book);
                return true;
            }
        }
        return false;
    }
    
    
    
    public List<Book> searchList(String name){
        List<Book> foundList = new ArrayList<>();
        for (Book book : bookList){
            if (book.getName().contains(name)){
                foundList.add(book);
            }
        }
           return foundList;
    }
    
     public void writeFile(String filePath) {
        try {
            File file = new File(filePath);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Book book: bookList) {
                
                String line =  book.toString();
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            System.out.println("Error when reading file!");
        }
        System.out.println("Saved successfully!");
    }
}
