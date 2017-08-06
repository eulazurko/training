package org.example;


import org.example.domain.Book;
import org.example.domain.Student;
import org.example.domain.dao.BookDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Starter {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationConfig.xml");
        BookDAO bookDAO = (BookDAO) ctx.getBean("bookDAO");

        List<Book> books = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        Book book = new Book();
        book.setName("BOOKY");
        book.setStudentList(students);
        books.add(book);

        Student student= new Student();
        student.setName("STUDY");
        student.setBookList(books);
        students.add(student);

        bookDAO.save(book);
        bookDAO.findAll();

    }
}
