package com.info.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.info.model.Book;
import com.info.model.IssueBook;
import com.info.service.BookService;

@RestController
@RequestMapping("api")
public class BookRESTController {

	@Autowired
	private BookService bookService;


	@ModelAttribute("book")
	public Book formBackingObject() {
		return new Book();
	}

	@PostMapping("/book")
	public String addBook(@RequestBody Book book) {
		book.setIssued(0);
		bookService.save(book);
		return "Book added successfully";
	}

	@GetMapping("/book/{bookId}")
	public Book viewAllBooks(@PathVariable Integer bookId) {
		return bookService.getBookById(bookId);
	}
	
	@GetMapping("/books")
	public List<Book> viewAllBooks(Locale locale, Model model) {
		return bookService.bookList();
	}

	@DeleteMapping("/book/{bookId}")
	public String deleteBook(@PathVariable("bookId") Integer bookId) {
		bookService.delete(bookId);
		return "Book with id=\" + bookId + \" deleted successfully.";
	}

	@RequestMapping(value = "/deleteBook", method = RequestMethod.POST)
	public String deleteBook(@ModelAttribute("book") @Valid Book book, BindingResult result, Model model) {
		if (bookService.getBookById(book.getId()) != null) {
			System.out.println("book ");
			bookService.delete(book.getId());
		}
		model.addAttribute("successMessage", "Book with id=" + book.getId() + " deleted successfully.");
		return "success";

	}

	
	
	@PutMapping(value = "/book")
	public Book updateBookByPut(@ModelAttribute("book") @Valid Book book) {
		bookService.update(book);
		return book;

	}
	
	@PatchMapping(value = "/book")
	public Book updateBookByPatch(@ModelAttribute("book") @Valid Book book, BindingResult result, Model model) {
		bookService.update(book);
		return book;

	}
	
	@GetMapping("/issueBook")
	public ModelAndView issueBook(Locale locale) {
		ModelAndView mav = new ModelAndView("issueBook");
		  IssueBook issueBook = new IssueBook();
		  mav.getModelMap().put("issueBook", issueBook);
		mav.getModelMap().put("myMessage", "Issue Book Form");
		mav.getModelMap().put("bookList", bookService.bookList());
		mav.setViewName("issueBook");
		return mav;
	}

	@PostMapping("/issueBook")
	public String saveIssueBook(@ModelAttribute("issueBook") @Valid IssueBook issueBook, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("myMessage", "Issue Book Form");
			model.addAttribute("bookList", bookService.bookList());
			return "issueBook";
		}
		// initially book is not issued
		bookService.issueBook(issueBook);
		model.addAttribute("successMessage", "Book added successfully");
		// return "redirect:/success";
		return "success";
	}

	@GetMapping("/viewAllIssuedBooks")
	public String viewAllIssuedBooks(Locale locale, Model model) {
		model.addAttribute("issueBookList", bookService.issueBookList());
		return "viewAllIssuedBooks";
	}
	
	@GetMapping("/returnBook")
	public ModelAndView returnBook(Locale locale) {
		ModelAndView mav = new ModelAndView("issueBook");
		  IssueBook issueBook = new IssueBook();
		  mav.getModelMap().put("issueBook", issueBook);
		mav.getModelMap().put("myMessage", "Return Book Form");
		mav.getModelMap().put("bookList", bookService.bookList());
		mav.setViewName("returnBook");
		return mav;
	}
	
	@PostMapping("/returnBook")
	public String savereturnBook(@ModelAttribute("issueBook") @Valid IssueBook issueBook, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("myMessage", "Return Book Form");
//			model.addAttribute("errorMessage", result.getAllErrors());
			model.addAttribute("bookList", bookService.bookList());
			return "returnBook";
		}
		// initially book is not issued
		bookService.returnBook(issueBook);
		model.addAttribute("successMessage", "Book returned successfully");
		// return "redirect:/success";
		return "success";
	}

}