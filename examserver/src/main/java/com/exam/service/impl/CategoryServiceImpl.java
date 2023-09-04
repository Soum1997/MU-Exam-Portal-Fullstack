package com.exam.service.impl;

import com.exam.model.exam.Category;
import com.exam.repo.CategoryRepository;
import com.exam.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository CategoryRepository;

    @Override
    public Category addCategory(Category category) {
        return this.CategoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {

        return this.CategoryRepository.save(category);
    }

    @Override
    public Set<Category> getCategories() {
        return new LinkedHashSet<>(this.CategoryRepository.findAll());
    }

    @Override
    public Category getCategory(Long categoryId) {
        return this.CategoryRepository.findById(categoryId).get();
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category category=new Category();
        category.setCid(categoryId);
        this.CategoryRepository.delete(category);
    }
}
