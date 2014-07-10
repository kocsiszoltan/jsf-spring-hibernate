package com.adwareresearch.service;

import com.adwareresearch.domain.AuthUser;
import java.util.List;

public interface AuthUserService {
    public void save(AuthUser user);
    public void delete(AuthUser user);
    public List<AuthUser> list();
    public List<AuthUser> findByUsernameAndPassword(String username, String password);
    public List<AuthUser> findByUsername(String username);
}
