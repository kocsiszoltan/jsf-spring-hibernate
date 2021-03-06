package com.adwareresearch.dao.impl;

import com.adwareresearch.dao.AuthRolesDao;
import com.adwareresearch.dao.common.GenericDaoImpl;
import com.adwareresearch.domain.AuthRoles;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class AuthRolesDaoImpl extends GenericDaoImpl<AuthRoles, String> implements AuthRolesDao {

    public AuthRolesDaoImpl() {
        super(AuthRoles.class);
    }

    @Override
    public void save(AuthRoles role) {
        saveOrUpdate(role);
    }

    @Override
    public void delete(AuthRoles role) {
        remove(role);
    }

    @Override
    public List<AuthRoles> list() {
        return findAll();
    }

	@Override
	public List<AuthRoles> findByRoleName(String roleName) {
		HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("roleName", roleName);
        return findByNamedQueryWithParameters("findByRoleName", parameters);
	}
    
}
