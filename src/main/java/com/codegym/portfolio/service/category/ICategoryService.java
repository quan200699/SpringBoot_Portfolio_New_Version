package com.codegym.portfolio.service.category;

import com.codegym.portfolio.model.entity.Category;
import com.codegym.portfolio.model.entity.Outcome;
import com.codegym.portfolio.service.IGeneralService;

public interface ICategoryService extends IGeneralService<Category> {
    Category findByName(String name);

    Iterable<Category> findAllByOutcome(Outcome outcome);
}
