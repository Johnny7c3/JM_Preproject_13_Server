package ru.javamentor.preproject.dao;

import ru.javamentor.preproject.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role getRole(String roleName) {
        return (Role) entityManager
                .createQuery("FROM Role r WHERE r.name =: roleName")
                .setParameter("roleName", roleName)
                .getSingleResult();
    }
}
