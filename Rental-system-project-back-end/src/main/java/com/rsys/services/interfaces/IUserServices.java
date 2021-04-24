package com.rsys.services.interfaces;

import com.rsys.dto.UserProfileInDto;
import com.rsys.pojos.entity.User;
import com.rsys.pojos.entity.UserProfile;

public interface IUserServices {

	User registerNew(User newUser);

	User getUserById(int userId);

	UserProfile addUserProfile(UserProfileInDto newUser);

	UserProfile getUserProfile(int userId);

}
