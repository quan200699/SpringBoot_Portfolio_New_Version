package com.codegym.portfolio.service.outcome;

import com.codegym.portfolio.model.entity.Outcome;
import com.codegym.portfolio.service.IGeneralService;

public interface IOutcomeService extends IGeneralService<Outcome> {
    Outcome findByTitle(String title);
}
