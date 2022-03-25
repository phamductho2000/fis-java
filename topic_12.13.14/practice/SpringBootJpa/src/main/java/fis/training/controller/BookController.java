package fis.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fis.training.entity.Book;
import fis.training.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookService bookService;

	@GetMapping("/save")
	public String saveBook() {
		Book b = new Book();
		b.setBookName("Rich dad poor dad");
		bookService.saveBook(b);
		return "Success";
	}
}
