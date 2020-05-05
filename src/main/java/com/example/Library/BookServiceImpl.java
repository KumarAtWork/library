package com.example.Library;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;


@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepo repo;
	@Autowired
	private LibraryRepo lrepo;

	@Override
	public String createBook(long libId, Book bk) {
		try {
			Library lb = lrepo.findById(libId).orElseThrow(() -> new ResourceNotFoundException(libId));
			bk.setLib(lb);
			repo.save(bk);
			return "Saved book Successfully";
		} catch (Exception e) {
			throw new BadRequestException();
		}
	}

	@Override
	public List<Book> findBooksByLibraryId(long id) {
		List<Book> books = repo.findBookByLibId(id);
		if (books.size() == 0)
			throw new ResourceNotFoundException(id);
		else
			return books;
	}

	@Override
	@Transactional
	public String updateBookNameById(long id, String name) {
		repo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		repo.updateBookById(id, name);
		return "Updated successfully";
	}

	
	@Override
	@Transactional
	public String deleteBookById(long id) {
		repo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		repo.deleteById(id);
		return "Updated successfully";
	}

	@Override
	public Book findBookById(long id) {
		return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
}
