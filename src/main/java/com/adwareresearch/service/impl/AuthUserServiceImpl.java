package com.adwareresearch.service.impl;

import com.adwareresearch.dao.AuthUserDao;
import com.adwareresearch.domain.AuthUser;
import com.adwareresearch.service.AuthUserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AuthUserServiceImpl implements AuthUserService {

    @Autowired
    private AuthUserDao dao;
    
    @Override
    public void save(AuthUser user) {
        dao.save(user);
    }

    @Override
    public void delete(AuthUser user) {
        dao.delete(user);
    }

    @Override
    public List<AuthUser> list() {
        return dao.list();
    }

    @Override
    public List<AuthUser> findByUsernameAndPassword(String username, String password) {
        return dao.findByUsernameAndPassword(username, password);
    }

    @Override
    public List<AuthUser> findByUsername(String username) {
        return dao.findByUsername(username);
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<AuthUser> user = findByUsername(username);
		if(!user.isEmpty()) {
			return user.get(0);
		} else {
			throw new UsernameNotFoundException("User not found!");
		}
	} 
}
