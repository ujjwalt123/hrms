package org.penta.work.boostrap.port;

import java.util.List;
import java.util.UUID;

import org.penta.work.boostrap.port.model.User;

public interface RequestUser {

	String login(String email, String password);
	Boolean signup(User user);
	User getUserByIdentifier(String identifier);
	List<User> getAllUsers();
	
}
