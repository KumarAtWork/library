package com.example.Library;

import java.util.List;

public interface BookService {

	public String createBook(long libId, Book bk);
	
	public List<Book> findBooksByLibraryId(long id);
	
	public Book findBookById(long id);
	
	public String updateBookNameById(long id,String name);
	
	public String deleteBookById(long id);
}
