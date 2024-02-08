package edu.itstep.mvc.repository;

import edu.itstep.mvc.entity.User;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserRepositoryImpl implements  UserRepository{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    @Transactional
    public List<User> getAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from User", User.class)
                .getResultList();
    }

    @Override
    @Transactional
    public void saveOrUpdate(User contact) {
        sessionFactory
                .getCurrentSession()
                .saveOrUpdate(contact);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        sessionFactory
                .getCurrentSession()
                .createQuery("delete from User where id = " + id)
                .executeUpdate();
    }

    @Override
    @Transactional
    public User getById(int id) {
        return sessionFactory
                .getCurrentSession()
                .get(User.class, id);
    }
}
