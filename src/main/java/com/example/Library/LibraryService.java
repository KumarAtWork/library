package com.example.Library;

import java.util.List;

public interface LibraryService {

	public String createLibrary(Library lib); 
	public Library findLibrary(long id);
	public List<Library> findAllLibraries();

}
