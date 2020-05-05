package com.example.Library;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/libraries")
public class LibraryController {
    @Autowired
	private LibraryService lbService;
    @Autowired
	private BookService bkService;
    
    @GetMapping
	public List<Library> getAll() {
		return lbService.findAllLibraries();
	}
    
    @PostMapping("/library")
	public String createLibrary(@RequestBody Library lib) {
		return lbService.createLibrary(lib);
	}
    @GetMapping("/library/{id}")
 	public Library findLibraryById(@PathVariable("id") long id) {
 		return lbService.findLibrary(id);
 	}
    
    @GetMapping("/library/{id}/books")
 	public List<Book> findBooksforLibraryId(@PathVariable("id") long id) {
 		return bkService.findBooksByLibraryId(id);
 	}
    
    @PostMapping("/library/{id}/book")
	public String createBook(@PathVariable("id") long id, @RequestBody Book book) {
		return bkService.createBook(id,book);
	}
    
    @GetMapping("/library/book/{id}")
	public Book getBook(@PathVariable("id") long id) {
		return bkService.findBookById(id);
	}
    
    @PutMapping("/library/book/{id}")
  	public String updateBook(@PathVariable("id") long book_id, @RequestBody Book book) {
  		return bkService.updateBookNameById(book_id,book.getName());
  	}
    
    @DeleteMapping("/library/book/{id}")
  	public String deleteBook(@PathVariable("id") long book_id) {
  		return bkService.deleteBookById(book_id);
  	}

	
}
