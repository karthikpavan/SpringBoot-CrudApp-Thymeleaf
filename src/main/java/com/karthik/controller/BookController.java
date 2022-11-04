package com.karthik.controller;

import com.karthik.entity.Book;
import com.karthik.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {
	@Autowired
  BookService service;

	@GetMapping("/")
	public String findAll(Model model) {
		model.addAttribute("books", service.findallBooks());
		return "all-books";
	}

	@GetMapping("/add")
	public String lunchAddBookPage(Model model) {
		model.addAttribute("book", new Book());
		return "add-book";
	}

	@PostMapping("/addbook")
	public String createBook(Book book) {
		service.addBook(book);
		return "redirect:/";

	}

	@GetMapping("/edit/{id}")
	public String lunchEditPage(Model model, @PathVariable("id") int id) {
		model.addAttribute("book", service.findBookById(id));
		return "edit-book";

	}

	@PostMapping("/updatebook")
	public String upadteBook(Book book) {
		service.updateBook(book);
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/";
	}

	@GetMapping("/testBook")
	public String test() {
		Book st = new Book();
		st.setId(1);
		st.setAuthor("Karthik");
		st.setName("Java 1.8 Edition");
		st.setNoOfPages(301);
		st.setPublication("Sample Publication");
		service.addBook(st);
		return "redirect:/";

	}

}
