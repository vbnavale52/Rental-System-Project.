package com.rsys.services.interfaces;

import com.rsys.dto.LoginDTO;
import com.rsys.pojos.entity.User;

public interface IAutenticationService {

	User autenticateUser(LoginDTO loginRequest);

}
