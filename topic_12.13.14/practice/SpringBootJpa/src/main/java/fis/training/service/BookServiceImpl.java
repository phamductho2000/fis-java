package fis.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fis.training.entity.Book;
import fis.training.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookRepository bookRepository;

	@Override
	public Book saveBook(Book book) {
		bookRepository.save(book);
		return book;
	}

	@Override
	public Book findByBookId(int bookId) {
		
		return null;
	}

}
