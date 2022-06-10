package com.cg.one2one;


	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.Persistence;

	public class Test {

		public static void main(String[] args) {
			
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			Book book = new Book();
			book.setName("EPD");
			Author authorName = new Author();
			book.setPrice("999.00");
			Author authorProps = new Author();
			authorProps.setDateOfBirth("05-05-1989");
			authorProps.setName("MUSK");
			
			
			
			//inject address into student
			book.setAuthor(authorProps);
			
			//persist only student, no need to persist Address explicitly
			em.persist(book);
			em.getTransaction().commit();
			
			System.out.println("Added one book with Author to database.");
			em.close();
			factory.close();
		}
	}