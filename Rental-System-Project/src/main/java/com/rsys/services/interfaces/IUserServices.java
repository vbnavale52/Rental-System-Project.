package com.rsys.services.interfaces;

import com.rsys.pojos.entity.User;

public interface IUserServices {

	User registerNew(User newUser);

	User getUserById(int userId);

}
