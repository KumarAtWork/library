package com.example.Library;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface BookRepo extends CrudRepository<Book, Long>{
	
	@Query(value="select b from Book b where b.lib.id=:id")
	public List<Book> findBookByLibId(@Param("id") long id);
	@Modifying
	@Query(value="update Book b set name=:name where b.id=:id")
	public void updateBookById(@Param("id") long id, @Param("name") String name );

}
