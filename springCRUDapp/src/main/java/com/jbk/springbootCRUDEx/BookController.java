package com.jbk.springbootCRUDEx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class BookController {

	@Value("${jbk.name}")
	String akki;
	
	@Autowired
	@Qualifier("book1Bean")
	Book book1;
	
	@Autowired
	BookService bookService;
	
	// http://localhost:8080/app/book
	@PostMapping ("/book")
	public Book saveBook(@RequestBody Book book2) {
		//Book b2= new Book();
		//b2.setAuthor("LMN");
		//b2.setBookname("PQR");
		Book book=bookService.saveBook(book2);
		System.out.println("From book save book");
		return book;
	}
	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable ("id")int  id) {
		Book book = bookService.getBook(id);
		System.out.println(akki);
		System.out.println("From book get book");
		return book;
		
	}
	@PutMapping("/book/{id}")
	public String updateBook(@RequestBody Book book, @PathVariable ("id") int id) {
		System.out.println("From book update book");
		String string=bookService.updateBook(book,id);
		return string;
		
	}
	@DeleteMapping("/book/{id}")
	public String deleteBook(@PathVariable ("id")int id) {
		System.out.println("From book delete book");
		String string =bookService.deleteBook(id);
		return string;
	}
	@GetMapping("/books")
	public Iterable<Book> getBooks() {
		Iterable <Book> books=bookService.getAllBooks();
		System.out.println("From book get all books");
		return books;
		
	}
	@GetMapping("/book")
	public Book getByParam(@RequestParam int bookId) {
		Book book=bookService.getBook(bookId);
		return book;
	}
}
