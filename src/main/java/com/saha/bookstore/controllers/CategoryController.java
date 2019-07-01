package com.saha.bookstore.controllers;

import com.saha.bookstore.model.Category;
import com.saha.bookstore.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class CategoryController {

    CategoryService categoryService;

    private static final String VIEWS_CATEGORY_CREATE_OR_UPDATE_FORM = "category/createOrUpdateOwnerForm";

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping("category/show/{id}")
    public String showStore(@PathVariable Long id, Model model){
        model.addAttribute("category", categoryService.findById(id));
        return "category/show";
    }

    @RequestMapping("category/show/list")
    public String showStore(Model model){
        model.addAttribute("category", categoryService.findAll());
        return "category/show";
    }

    @GetMapping("category/new")
    public String initCreationForm(Model model){
        model.addAttribute("category", Category.builder().build());
        return VIEWS_CATEGORY_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("category/new")
    public String processCreationForm(@Valid Category category, BindingResult bindingResult){
        Category savedCategory = categoryService.save(category);
        return "redirect:/category/" + savedCategory.getId();
    }

    @GetMapping("category/{id}/delete")
    public String deleteById(@PathVariable Long id){
        categoryService.deleteById(id);
        return "redirect:/";
    }

}
