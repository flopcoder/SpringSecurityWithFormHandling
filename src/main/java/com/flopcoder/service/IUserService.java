package com.flopcoder.service;

import com.flopcoder.model.User;

/**
 * Created by Flop Coder on 6/2/14.
 */
public interface IUserService {

    public User getUserById(Integer id);

    public User save(User user);

    public User getUserByUsername(String username);
}
