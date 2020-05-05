package com.example.Library;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryServiceImpl implements LibraryService {

	@Autowired
	private LibraryRepo repo;

	@Override
	public String createLibrary(Library lib) {
		try {
			Library lb = repo.save(lib);
			return "Saved Successfully";
		} catch (Exception e) {
			throw new BadRequestException();
		}
	}

	@Override
	public Library findLibrary(long id) {
		Library lb = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		return lb;
	}

	@Override
	public List<Library> findAllLibraries() {
		List<Library> lbs = new ArrayList<>();
		repo.findAll().forEach(l -> lbs.add(l));
		return lbs;
	}

}
