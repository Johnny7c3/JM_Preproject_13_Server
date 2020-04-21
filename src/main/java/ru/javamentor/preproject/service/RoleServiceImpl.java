package ru.javamentor.preproject.service;

import ru.javamentor.preproject.dao.RoleDao;
import ru.javamentor.preproject.model.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    @Transactional(readOnly = true)
    public Role getRole(String roleName) {
        return roleDao.getRole(roleName);
    }
}
