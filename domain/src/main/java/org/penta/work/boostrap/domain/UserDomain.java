package org.penta.work.boostrap.domain;

import static org.penta.work.boostrap.port.utils.EncryptionUtil.decrypt;
import static org.penta.work.boostrap.port.utils.EncryptionUtil.encrypt;

import java.util.List;
import java.util.UUID;

import org.penta.work.boostrap.port.RequestUser;
import org.penta.work.boostrap.port.create.UserSignup;
import org.penta.work.boostrap.port.model.User;
import org.penta.work.boostrap.port.query.UserLogin;
import org.penta.work.boostrap.port.query.UserProfile;

import lombok.Builder;

@Builder
public class UserDomain implements RequestUser {
	
	private UserLogin userLogin;
    private UserSignup userSignup;
    private UserProfile userProfile;

    public UserDomain(UserLogin userLogin, UserSignup userSignup, UserProfile userProfile) {
        this.userLogin = userLogin;
        this.userSignup = userSignup;
        this.userProfile = userProfile;
    }

	@Override
	public String login(String email, String password) {
		String encryptedPassword = encrypt(password);
		return userLogin.login(email, encryptedPassword);
	}

	@Override
	public Boolean signup(User user) {
		// Encrypting the password and setting in the entity
        String encryptedPassword = encrypt(user.getPassword());
        user.setPassword(encryptedPassword);
		return userSignup.signup(user);
	}

	@Override
	public User getUserByIdentifier(String identifier) {
		
		String[] decryptedIdentifierArray = decrypt(identifier).split("<>");
		UUID id = UUID.fromString(decryptedIdentifierArray[0]);
		return userProfile.getUserByIdentifier(id);
	}

	@Override
	public List<User> getAllUsers() {
		return userProfile.getAllUsers();
	}

}
