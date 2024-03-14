/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.File;
import java.util.List;
import model.Book;
import model.BookList;
import util.FormatString;
import util.InputUtils;

/**
 *
 * @author LENOVO
 */
public class Controller {

    File file;
    BookList bookList = new BookList();

    public void importFile() {
        System.out.println("Enter path: ");
        String filePath = InputUtils.inputString();
        file = new File(filePath);
        if (file.exists()) {
            if (file.isFile()) {
                bookList.readFile(filePath);
                System.out.println("Import: Done");
            } else {
                System.out.println("Not a file.");
            }
        } else {
            System.out.println("Invalid file path.");
        }
    }

    public void exportFile() {
        System.out.println("Enter path: ");
        String filePath = InputUtils.inputString();
        if (InputUtils.checkFilePath(filePath)) {
            bookList.writeFile(filePath);
        } else {
            System.out.println("Invalid file path to export. A valid path is end with '.csv'. ");
        }
    }

    public void addBook() {
        System.out.print("Enter Book ID: ");
        String id = InputUtils.inputId();
        System.out.print("Enter Book Name: ");
        String name = InputUtils.inputName();
        name = FormatString.formatName(name);
        System.out.print("Enter Author Name: ");
        String author = InputUtils.inputName();
        author = FormatString.formatName(author);
        System.out.print("Enter Issue Number: ");
        String issueNumber = InputUtils.inputString();
        Book b = new Book(id, name, author, issueNumber);
        if (bookList.addList(b)) {
            System.out.println("Added successfully!");
        } else {
            System.out.println("ID had already existed. Failed to add.");
        }
    }

    public void deleteBook() {
        System.out.print("Enter Book ID: ");
        String id = InputUtils.inputId();
        if (bookList.removeList(id)) {
            System.out.println("Removed successfully!");
        } else {
            System.out.println("ID not found!");
        }
    }

    public void searchBook() {
        System.out.print("Enter Book Name: ");
        String name = InputUtils.inputName();
        List<Book> foundList = bookList.searchList(name);
        if(foundList!= null){
            System.out.println("Result: ");
            System.out.printf("%-15s|%-30s|%-30s|%-15s\n", "ID", "Name", "Author", "Issue Number");
            for(Book b: foundList){
                b.displayBook();
            }
        }else{
            System.out.println("Not found!");
        }
    }

}
