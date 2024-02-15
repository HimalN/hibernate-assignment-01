package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.Author;
import lk.ijse.entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        /*Save books*/
        Book book_01 = new Book();
        book_01.setTitle("Peter and Wendy");
        book_01.setPublicationYear(LocalDate.of(2000,7,8));
        book_01.setPrice(2500);

        Book book_02 = new Book();
        book_02.setTitle("The House on Mango Street");
        book_02.setPublicationYear(LocalDate.of(2010,8,24));
        book_02.setPrice(3500);

        Book book_03 = new Book();
        book_03.setTitle("The Outsiders");
        book_03.setPublicationYear(LocalDate.of(2008,9,14));
        book_03.setPrice(3700);

        /*Crate a list to add the books to  each relevant author*/
        ArrayList<Book> list = new ArrayList<>();
        list.add(book_01);
        list.add(book_02);
        list.add(book_03);

        /*Save authors*/
        Author author_01 = new Author();
        author_01.setName("J. M. Barrie");
        author_01.setCountry("America");
        author_01.setBooks(list);

        Author author_02 = new Author();
        author_02.setName("Sandra Cisneros");
        author_02.setCountry("America");
        author_02.setBooks(list);

        Author author_03 = new Author();
        author_03.setName("S.E. Hinton");
        author_03.setCountry("England");
        author_03.setBooks(list);

        /*Set each relevant author to books*/
        book_01.setAuthor(author_01);
        book_02.setAuthor(author_02);
        book_03.setAuthor(author_03);


        /*1. Write an HQL query to retrieve all books published after the year 2010*/

        /*Query query = session.createQuery("from Book where year(publicationYear) = :year");

        query.setParameter("year", 2010);
        List<Book> bookList = query.list();

        for (Book book : bookList) {
            System.out.println("Book ID : " + book.getId());
            System.out.println("Price : " + book.getPrice());
            System.out.println("Publication Year : " + book.getPublicationYear());
            System.out.println("Name : " + book.getTitle() + "\n");
        }*/

        /*2. Write an HQL update query to increase the price of all books published by a specific author by 10%.*/

        /*Query query = session.createQuery("update Book set price = price * 1.1 where author.id IN (:authorIds)");
        query.setParameter("authorID", 3);
        int result = query.executeUpdate();
        System.out.println("Books price updated by 10% : " + result);*/


        /*3. Implement a method to delete an author and cascade the deletion to all associated books
        using appropriate cascade options.*/

        /*Create a query to delete books associated with a specific author*/
        /*Query deleteBooksQuery = session.createQuery("delete from Book b where b.author.id = :id");
        deleteBooksQuery.setParameter("id", 1); // Set the author ID here
        int deletedBooksCount = deleteBooksQuery.executeUpdate();
        System.out.println("Number of books deleted: " + deletedBooksCount);*/

        /*Create a query to delete the author*/
        /*Query deleteAuthorQuery = session.createQuery("delete from Author where id = :id");
        deleteAuthorQuery.setParameter("id", 1); // Set the author ID here
        int deletedAuthorCount = deleteAuthorQuery.executeUpdate();
        System.out.println("Number of authors deleted: " + deletedAuthorCount);*/


        /*4. Write an HQL query to find the average price of all books.*/

        /*Query query = session.createQuery("select avg(price) from Book");
        Double avg = (Double) query.uniqueResult();
        System.out.println("Average Price of a Book :" + avg);*/


        /*5. Write an HQL query to retrieve all authors along with the count of books they have written.*/

        /*Query query = session.createQuery("select a.name,count (b.id) from Author a " +
                "inner join a.books b group by a.id");
        List<Object []> list = query.list();

        for (Object [] objects : list) {
            String name = (String) objects[0];
            Long bookCount = (Long) objects[1];

            System.out.println("Author : " + name + "\tTotal Books : " +  bookCount);

        }*/

        /*6. Write an HQL query using named parameters to retrieve books written by authors from a
        specific country.*/

        /*Query query = session.createQuery("SELECT book FROM Book AS book WHERE book.author.country = :country");
        query.setParameter("country", "England");
        List<Book> results = query.list();

        for (Book book : results) {
            System.out.println("The books from England : " + book.getTitle());
        }*/

        /*session.save(author_01);
        session.save(book_01);
        session.save(author_02);
        session.save(book_02);
        session.save(author_03);
        session.save(book_03);*/

        transaction.commit();
        session.close();
    }
}