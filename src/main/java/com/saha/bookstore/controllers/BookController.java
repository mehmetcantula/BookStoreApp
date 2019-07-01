package com.saha.bookstore.controllers;

import com.saha.bookstore.model.Book;
import com.saha.bookstore.services.BookService;
import com.saha.bookstore.services.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@Controller
public class BookController {

    private static final String VIEWS_BOOK_CREATE_OR_UPDATE_FORM = "books/createOrUpdateOwnerForm";

    private BookService bookService;
    private StoreService storeService;

    public BookController(BookService bookService, StoreService storeService) {
        this.storeService = storeService;
        this.bookService = bookService;
    }

    //Requestin id propery'i manupule etmemesi icin yazılmıstir.
    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping("book/show/{id}")
    public String showStore(@PathVariable Long id, Model model){
        model.addAttribute("book", bookService.findById(id));
        return "book/show";
    }

    @RequestMapping("book/show/list")
    public String showStore(Model model){
        model.addAttribute("book", bookService.findAll());
        return "book/show";
    }

    @RequestMapping("book/show/list/{storeId}")
    public String showBooksFromStore(@PathVariable Long storeId, Model model){
        model.addAttribute("book", storeService.findById(storeId));
        return "book/show";
    }

    @GetMapping("book/new")
    public String initCreationForm(Model model){
        model.addAttribute("book", Book.builder().build());
        return VIEWS_BOOK_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("book/new")
    public String processCreationForm(@Valid Book book, BindingResult bindingResult){
        Book savedBook = bookService.save(book);
        return "redirect:/book/" + savedBook.getId();
    }

    @GetMapping("book/{id}/delete")
    public String deleteById(@PathVariable Long id){
        bookService.deleteById(id);
        return "redirect:/";
    }
}
