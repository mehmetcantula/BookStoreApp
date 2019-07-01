package com.saha.bookstore.controllers;

import com.saha.bookstore.model.Category;
import com.saha.bookstore.model.Store;
import com.saha.bookstore.services.BookService;
import com.saha.bookstore.services.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class StoreController {

    BookService bookService;
    StoreService storeService;

    private static final String VIEWS_STORE_CREATE_OR_UPDATE_FORM = "store/createOrUpdateOwnerForm";

    public StoreController(BookService bookService, StoreService storeService) {
        this.bookService = bookService;
        this.storeService = storeService;
    }

    @InitBinder
    public void initBookBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping("stores/show/{id}")
    public String showStore(@PathVariable Long id, Model model){
        model.addAttribute("store", storeService.findById(id));
        return "store/show";
    }

    @RequestMapping("stores/show/list")
    public String showStore(Model model){
        model.addAttribute("store", storeService.findAll());
        return "store/show";
    }

    @GetMapping("store/new")
    public String initCreationForm(Model model){
        model.addAttribute("store", Store.builder().build());
        return VIEWS_STORE_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("store/new")
    public String processCreationForm(@Valid Store store, BindingResult bindingResult){
        Store savedStore = storeService.save(store);
        return "redirect:/category/" + savedStore.getId();
    }

    @GetMapping("store/{id}/delete")
    public String deleteById(@PathVariable Long id){
        storeService.deleteById(id);
        return "redirect:/";
    }




}
