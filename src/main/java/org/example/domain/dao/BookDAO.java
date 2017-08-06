package org.example.domain.dao;


import org.example.domain.Book;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Book book) {
        entityManager.persist(book);
    }

    public List<Book> findAll() {
        return entityManager.createQuery("select b from Book b join fetch b.studentList", Book.class).getResultList();
    }


}
