package com.codegym.portfolio.service.module;

import com.codegym.portfolio.model.entity.Module;
import com.codegym.portfolio.model.entity.Program;
import com.codegym.portfolio.service.IGeneralService;

public interface IModuleService extends IGeneralService<Module> {
    Iterable<Module> findAllByProgram(Program program);
}
