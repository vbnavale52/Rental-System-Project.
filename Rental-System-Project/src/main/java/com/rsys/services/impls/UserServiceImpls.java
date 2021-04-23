package com.rsys.services.impls;

import static com.rsys.utils.UserValidation.passwordValidation;
import static com.rsys.utils.UserValidation.userNameDuplication;
import static com.rsys.utils.UserValidation.userNameValidation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rsys.dao.IUserProfileRepository;
import com.rsys.dao.IUserRepository;
import com.rsys.dto.UserProfileInDto;
import com.rsys.exception.UserException;
import com.rsys.pojos.entity.User;
import com.rsys.pojos.entity.UserProfile;
import com.rsys.services.interfaces.ICloudinaryService;
import com.rsys.services.interfaces.IUserServices;

@Service
@Transactional
public class UserServiceImpls implements IUserServices {
	@Autowired
	private IUserRepository userRepository;
	
	private IUserProfileRepository userProfileRepository;
	@Autowired
	private ICloudinaryService cloudinaryService;

	public UserServiceImpls() {

	}

	@Override
	public User registerNew(User newUser) {
		userNameValidation(newUser.getUserName());
		userNameDuplication(userRepository.findAll(), newUser.getUserName());
		passwordValidation(newUser.getPassword(), newUser.getConfirmPassword());

		return userRepository.save(newUser);
	}

	@Override
	public User getUserById(int userId) {
		Optional<User> optionalUser = userRepository.findById(userId);
		User user = optionalUser.orElseThrow(() -> new UserException("user is no found with id " + userId));
		return user;
	}

	@Override
	public UserProfile addUserProfile(UserProfileInDto newUser) {
		Optional<User> optionalUser=userRepository.findById(newUser.getUserId());
		User user = optionalUser.orElseThrow(()-> new UserException("User is not registered please register...... "));
		UserProfile validatedUser = new UserProfile();
		validatedUser.setFirstName(newUser.getFirstName());
		validatedUser.setLastName(newUser.getLastName());
		validatedUser.setDateOfBirth(newUser.getDateOfBirth());
		validatedUser.setEmail(newUser.getEmail());
		validatedUser.setPhoneNumber(newUser.getPhoneNumber());
		validatedUser.setUser(user);
		validatedUser.setProfileImage(cloudinaryService.uploadFile(newUser.getProfileImage()));
		return userProfileRepository.save(validatedUser);
	}

	@Override
	public UserProfile getUserProfile(int userId) {
		Optional<User> optionalUser = userRepository.findById(userId);
		User user = optionalUser.orElseThrow(() -> new UserException("user is no found ......."));
		Optional<UserProfile> optionalUserProfile =userProfileRepository.getUserProfile(user);
		UserProfile userProfile = optionalUserProfile.orElseThrow(() -> new UserException("user profile  no found .... " + userId));
		return null;
	}
}
