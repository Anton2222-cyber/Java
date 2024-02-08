package edu.itstep.mvc.repository;

import edu.itstep.mvc.entity.User;

import java.util.List;

public interface UserRepository {
    List<User> getAll();

    void saveOrUpdate(User contact);

    void deleteById(int id);

    User getById(int id);
}
