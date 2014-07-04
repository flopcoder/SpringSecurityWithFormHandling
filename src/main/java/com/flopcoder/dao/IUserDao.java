package com.flopcoder.dao;

import com.flopcoder.model.User;

/**
 * Created by Flop Coder on 6/2/14.
 */
public interface IUserDao {
    public User getUserById(Integer id);

    public User getUserByUsername(String username);

    public User save(User user);
}
