package com.rsys.services.impls;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rsys.dao.IUserRepository;
import com.rsys.exception.UserException;
import com.rsys.pojos.entity.User;
import static com.rsys.utils.UserValidation.*;
import com.rsys.services.interfaces.IUserServices;

@Service
@Transactional
public class UserServiceImpls implements IUserServices {
	@Autowired
	private IUserRepository userRepository;

	public UserServiceImpls() {

	}

	@Override
	public User registerNew(User newUser) {
		userNameValidation(newUser.getUserName());
		userNameDuplication(userRepository.findAll(),newUser.getUserName());
		passwordValidation(newUser.getPassword(),newUser.getConfirmPassword());
		User registeredUser = userRepository.save(newUser);
		return registeredUser;
	}

	@Override
	public User getUserById(int userId) {
		Optional<User> optionalUser = userRepository.findById(userId);
		User user=optionalUser.orElseThrow(()-> new  UserException("user is no found with id "+ userId));
		return user ;
	}
}
