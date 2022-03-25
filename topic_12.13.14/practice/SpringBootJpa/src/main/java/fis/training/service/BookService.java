package fis.training.service;

import fis.training.entity.Book;

public interface BookService {
	public Book saveBook(Book book);

	public Book findByBookId(int bookId);

}
