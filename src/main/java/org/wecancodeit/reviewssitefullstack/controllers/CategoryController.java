package org.wecancodeit.reviewssitefullstack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviewssitefullstack.models.Category;
import org.wecancodeit.reviewssitefullstack.repositories.CategoryRepository;

import javax.annotation.Resource;

@Controller
public class CategoryController {

    @Resource
    private CategoryRepository categoryRepo;

    @RequestMapping({"/categories", "/", ""})  //it does not have the green globe on line 19
    public String displayCategories(Model model) {
        model.addAttribute("categories", categoryRepo.findAll());
        return "categoriesView";
    }

    @GetMapping("/categories/{genre}")
    public String displaySingleCategory(@PathVariable String genre, Model model) {
        Category retrievedCategory = categoryRepo.findCategoryByGenre(genre);
        model.addAttribute("category", retrievedCategory);
        return "categoryView";
    }
}
