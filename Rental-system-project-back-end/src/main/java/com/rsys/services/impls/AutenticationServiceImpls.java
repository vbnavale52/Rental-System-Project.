package com.rsys.services.impls;

import static com.rsys.utils.UserValidation.passwordValidation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rsys.dao.IUserRepository;
import com.rsys.dto.ForgotPasswordDto;
import com.rsys.dto.LoginDTO;
import com.rsys.exception.UserException;
import com.rsys.pojos.entity.User;
import com.rsys.services.interfaces.IAutenticationService;

@Service
@Transactional
public class AutenticationServiceImpls implements IAutenticationService {
	
	@Autowired
	private IUserRepository userRepository;

	public AutenticationServiceImpls() {
		
	}

	@Override
	public User autenticateUser(LoginDTO loginRequest) {
		Optional<User> optionalUser = userRepository.autenticateUser(loginRequest.getUserName(),loginRequest.getPassword());
		User user=optionalUser.orElseThrow(()-> new  UserException("Please enter valid user name and password........."));
		//return user.getUserProfile();
		return user ;
	}

	@Override
	public User forgotPassword(ForgotPasswordDto forgotPasswordDto) {
		Optional<User> optionalUser = userRepository.findByUserName(forgotPasswordDto.getUserName());
		User user=optionalUser.orElseThrow(()-> new  UserException("Please enter valid user name ........."));
		passwordValidation(forgotPasswordDto.getPassword(), forgotPasswordDto.getConfirmPassword());
		user.setPassword(forgotPasswordDto.getPassword());
		return userRepository.save(user);
	
	}
	
	
}
