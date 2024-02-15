>  Firstly Create a database named Library_management.
then,
>change the hibernate-configuration file to match your mysql user name and password.

> In this project you can find two entitys with one to many relationship the @GeneratedValue(strategy = GenerationType.IDENTITY) it will automatically generate a uniqe id the use of mappedBy in the @OneToMany annotation helps to establish a bidirectional relationship and specifies that the author field in the Book entity manages the relationship. 
The @JoinColumn annotation is used in Java Persistence API to specify the mapping of a foreign key column. 
So it is used in associations between entities to define the column in the database table that shows foreign key relationship.

7. Define bidirectional one-to-many relationship between Author and Book entities using @JoinColumn annotation

   public class Author {
 	    @Id
 	    @GeneratedValue(strategy = GenerationType.IDENTITY)
 	    private int id;
 	    private String name;
 				
 	    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL,orphanRemoval = true)
 	    private List<Book> books;
 	}


 	public class Book {
 	    @Id
 	    @GeneratedValue(strategy = GenerationType.IDENTITY)
 	    private int id;
      private String title;
 	    private LocalDate publicationYear;
 	    private double price;
 			
 	    @ManyToOne
 	    @JoinColumn(name = "author_id")
 	    private Author author;
 	} 


@OneToMany(mappedBy = "author",cascade = CascadeType.ALL,orphanRemoval = true) by cascde = CascadeType.ALL,orphanRemoval = true
when an author deleted the relavent all associated books will be deleted automatically.
orphanRemoval = true: This attribute specifies that if a child entity (e.g., Book) is removed from the collection in the parent entity (e.g., Author),
it is deleted from the database. it means, if you remove a Book from the collection of an Author, Hibernate automatically delete the corresponding row from the database.
