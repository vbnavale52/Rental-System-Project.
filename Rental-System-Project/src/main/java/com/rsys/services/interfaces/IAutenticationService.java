package com.rsys.services.interfaces;

import com.rsys.dto.LoginDTO;
import com.rsys.pojos.entity.User;
import com.rsys.pojos.entity.UserProfile;

public interface IAutenticationService {

	User autenticateUser(LoginDTO loginRequest);

}