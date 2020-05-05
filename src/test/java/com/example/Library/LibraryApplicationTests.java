package com.example.Library;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class LibraryApplicationTests {
	@MockBean
	private BookRepo repo;

	@MockBean
	private LibraryRepo lrepo;
	
	@Autowired
	private LibraryService ls;
	
	@Autowired
	private BookService bs;
   
   @Test
   public void getLibrary() {
	   Library lib1 = new Library();
	   lib1.setId(1l);
	   lib1.setName("lb-a");
	    Mockito.when(lrepo.findById(1l)).thenReturn(Optional.of(lib1));
	    assertEquals(1l,  ls.findLibrary(1).getId());
   }
   
   @Test
   public void getAllLibraries() {
	   Library lib1 = new Library();
	   lib1.setId(1l);
	   lib1.setName("lb-a");
	   List<Library> its = new ArrayList<>();
	   its.add(lib1);
	    Mockito.when(lrepo.findAll()).thenReturn(its);
	    assertEquals(1,  ls.findAllLibraries().size());
   }
   
   @Test
   public void createLibrary() {
	   Library lib1 = new Library();
	   lib1.setId(1l);
	   lib1.setName("lb-a");
	   List<Library> its = new ArrayList<>();
	   its.add(lib1);
	    Mockito.when(lrepo.save(lib1)).thenReturn(lib1);
	    assertEquals(1,  ls.createLibrary(lib1));
   }
   
}
