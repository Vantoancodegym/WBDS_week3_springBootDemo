package com.vantoan.demo.service;

import com.vantoan.demo.model.AppUser;

public interface IAppUserService {
    AppUser findByUsername(String username);
}
