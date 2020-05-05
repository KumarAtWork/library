package com.example.Library;

import java.util.List;

import lombok.Data;

@Data
public class LibraryResponse {
	private Long id;
	private String name;
    private List<Book> books;
}
