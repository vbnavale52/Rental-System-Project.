package com.rsys.services.impls;

import static com.rsys.utils.UserValidation.passwordValidation;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rsys.dao.IPasswordResetTokenRepository;
import com.rsys.dao.IUserRepository;
import com.rsys.dto.ForgotPasswordDto;
import com.rsys.dto.LoginDTO;
import com.rsys.dto.ResetPasswordDTO;
import com.rsys.exception.UserException;
import com.rsys.pojos.entity.PasswordResetToken;
import com.rsys.pojos.entity.User;
import com.rsys.services.interfaces.IAutenticationService;

@Service
@Transactional
public class AutenticationServiceImpls implements IAutenticationService {

	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private IPasswordResetTokenRepository resetTokenRepository;
    @Value("${email.from.address}")
    private String fromAddress;

	public AutenticationServiceImpls() {

	}

	@Override
	public User autenticateUser(LoginDTO loginRequest) {
		Optional<User> optionalUser = userRepository.autenticateUser(loginRequest.getUserName(),
				loginRequest.getPassword());
		User user = optionalUser
				.orElseThrow(() -> new UserException("Please enter valid user name and password........."));
		// return user.getUserProfile();
		return user;
	}

	@Override
	public User forgotPassword(ForgotPasswordDto forgotPasswordDto) {
		Optional<User> optionalUser = userRepository.findByUserName(forgotPasswordDto.getUserName());
		User user = optionalUser.orElseThrow(() -> new UserException("Please enter valid user name ........."));
		passwordValidation(forgotPasswordDto.getPassword(), forgotPasswordDto.getConfirmPassword());
		user.setPassword(forgotPasswordDto.getPassword());
		return userRepository.save(user);

	}

	@Override
	@Async
	public User resetPassword(ResetPasswordDTO resetPasswordDTO) {
		Optional<User> optionalUser = userRepository.findByUserName(resetPasswordDTO.getUserName());
		User user = optionalUser.orElseThrow(() -> new UserException("Please enter valid user name ........."));

		String token = UUID.randomUUID().toString();
		PasswordResetToken myToken = new PasswordResetToken();
		myToken.setToken(token);
		myToken.setTokenCreationDate(LocalDateTime.now());
		myToken.setUser(user);
		PasswordResetToken savedToken = resetTokenRepository.save(myToken);

		user.setPasswordResetToken(savedToken);
		userRepository.save(user);

		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setSubject("Rentel System Reset password link....");
		simpleMailMessage.setText("To complete the password reset process, please click here: /"
				+ "http://localhost:8080/forgot-password");
		simpleMailMessage.setTo(user.getUserProfile().getEmail());
		simpleMailMessage.setFrom(fromAddress);
		javaMailSender.send(simpleMailMessage);
		return user;

		// +
		// "http://localhost:8080/confirm-reset?token="+confirmationToken.getConfirmationToken());

		// https://www.baeldung.com/spring-security-registration-i-forgot-my-password
		// String token = UUID.randomUUID().toString();
		// PasswordResetToken myToken = new PasswordResetToken();
		// myToken.setToken(token);
		// myToken.setTokenCreationDate(LocalDateTime.now());
		// myToken.setUser(user);
		// resetTokenRepository.save(myToken);
		// mailMessage.setText("To complete the password reset process, please click
		// here: "
		// +
		// "http://localhost:8080/confirm-reset?token="+confirmationToken.getConfirmationToken());

	}

	private SimpleMailMessage constructEmail(String subject, String body, User user) {
		SimpleMailMessage email = new SimpleMailMessage();
		email.setSubject(subject);
		email.setText(body);
		email.setTo(user.getUserProfile().getEmail());
		email.setFrom("samadhan563@gmail.com");
		return email;
	}

}
