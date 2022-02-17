package com.jbk.springbootCRUDEx;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class BookService {
	//Get a book from database from ID and return to the controller

	@Autowired
	BookRepository bookRepo;


	public Book getBook(int id) {
		Optional<Book> book= bookRepo.findById(id);
		return book.get();

	}
	public String deleteBook(int id) {
		bookRepo.deleteById(id);
		String a="Book with ID = "+id+" is deleted successfully";
		return a;

	}
	public Book saveBook(Book b) {
		Book b1=bookRepo.save(b);
		System.out.println("Printing from service");
		return b1;
	}

	public String updateBook (Book b, int id) {
		Optional <Book>book=bookRepo.findById(id);
		Book b1=book.get();
		String oldAuthor= b1.getAuthor();
		b1.setAuthor(b.getAuthor());
		Book updatedBook=bookRepo.save(b1);
		String a="Author details updated for the book with ID: "+id+
				" and Book Author Name changed from : "+oldAuthor+
				" to "+updatedBook.getAuthor();
		return a;
	}
	public Iterable<Book> getAllBooks() {
		Iterable<Book>itr= bookRepo.findAll();
		return itr;
	}
	
}
