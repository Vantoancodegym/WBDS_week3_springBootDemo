package com.vantoan.demo.repo;

import com.vantoan.demo.model.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepo extends CrudRepository<AppUser,Long> {
    AppUser findAppUserByUsername(String username);
}
