package com.codegym.portfolio.service.user;

import com.codegym.portfolio.model.auth.User;
import com.codegym.portfolio.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
}
