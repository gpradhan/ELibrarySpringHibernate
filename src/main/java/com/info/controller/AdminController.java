package com.info.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.info.model.Admin;
import com.info.model.MyUser;
import com.info.service.UserService;

@Controller
@RequestMapping("/")
@SessionAttributes("admin")
public class AdminController {

	@Autowired
	private UserService userService;

	@ModelAttribute("admin")
	public Admin formBackingObject() {
		return new Admin();
	}
	

	@GetMapping("/")
	public String index(Locale locale, Model model) {
		return "index";
	}
	
	@GetMapping("/index")
	public String index1(Locale locale, Model model) {
		return "index";
	}

	@GetMapping("/login")
	public String home(Locale locale, Model model) {
		return "index";
	}

	@PostMapping("/login")
	public String home(@ModelAttribute("admin") Admin admin, Locale locale, Model model) {
		if (admin.getEmail().equals("gouri@gmail.com") && admin.getPassword().equals("1111")) {
			model.addAttribute("admin", admin);
		} else {
			model.addAttribute("error", "<h3>Username or password error</h3>");
			return "adminloginform";
		}

		return "adminHome";
	}

	@GetMapping("/addLibrarianForm")
	public String addLibrarianForm(Locale locale, Model model) {
		model.addAttribute("myUser", new MyUser());
		return "addLibrarianForm";
	}

	@GetMapping("/viewLibrarian")
	public String viewLibrarian(Locale locale, Model model) {
		model.addAttribute("myUser", new MyUser());
		model.addAttribute("librarianList", userService.userList());
		return "viewLibrarian";
	}

	@PostMapping("/editLibrarianForm")
	public String editLibrarianForm(@ModelAttribute("myUser") MyUser myUser,Locale locale,Model model) {
		model.addAttribute("myUser",userService.findById(myUser.getId()));
		return "editLibrarianForm";
	}

	@PostMapping("/deleteLibrarianForm")
	public String deleteLibrarianForm(@ModelAttribute("myUser") MyUser myUser, Locale locale, Model model) {
		userService.delete(myUser.getId());
		model.addAttribute("librarianList", userService.userList());
		return "viewLibrarian";
	}

	@PostMapping("/updateLibrarian")
	public String updateLibrarian(@ModelAttribute("myUser") @Valid MyUser myUser, Locale locale, Model model) {
		userService.update(myUser);
		model.addAttribute("librarianList", userService.userList());
		return "viewLibrarian";
	}

	@GetMapping("/logoutAdmin")
	public String logoutAdmin(Locale locale, Model model, HttpSession session) {
		session.removeAttribute("admin");
		return "index";
	}

	@PostMapping("/addLibrarian")
	public String addLibrarian(@ModelAttribute("myUser") @Valid MyUser myUser, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("error", "Add Librarian Form");
			return "addLibrarianForm";
		}
		// initially book is not issued
		userService.save(myUser);
		// model.addAttribute("successMessage", "User registered successfully");
		model.addAttribute("error", "Librarian registered successfully");
		// return "redirect:/success";
		return "index";
	}
	
	@GetMapping("/librarianloginform")
	public String logoutAdmin(Locale locale, Model model) {
		model.addAttribute("myUser", new MyUser());
		return "librarianloginform";
	}
	@GetMapping("/adminloginform")
	public String adminloginform(Locale locale, Model model) {
		return "adminloginform";
	}

}
