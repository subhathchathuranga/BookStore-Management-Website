package com.example.BookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.BookStore.entity.Book;
import com.example.BookStore.service.BookService;



@Controller
public class BookController {
	
	@Autowired
	BookService BookService;
	
	@GetMapping("/add") //page view
	public String form(Model model) { 
		model.addAttribute("book",new Book());
		return "add";
	}

	@PostMapping("/add")  //when we add the data by using this site
	public String createCrud(@ModelAttribute Book book) {
		BookService.SaveBook(book);
		return "redirect:manage";
	}
	
	//read/view the data from the databases
	
	@GetMapping("/manage")
	public String getInfo(Model model) {
		model.addAttribute("entities",BookService.getInfo());
		return "manage";
	}

	@RequestMapping("/edit/{id}")
	public String showEdit(@PathVariable Long id, Model model) {
		Book book = BookService.showEdit(id);
        if (book != null) {
            model.addAttribute("book", book);
            return "edit";
        }
        return "redirect:/manage";
	}
		
    // Delete an entity
    @RequestMapping("/delete/{id}")
    public String deleteInfo(@PathVariable Long id) {
    	BookService.deleteInfo(id);
        return "redirect:/manage";
    }

	

}
