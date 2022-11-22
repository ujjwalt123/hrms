package org.penta.work.boostrap.port.query;

import java.util.List;
import java.util.UUID;

import org.penta.work.boostrap.port.model.User;

public interface UserProfile {

	User getUserByIdentifier(UUID id);
	List<User> getAllUsers();
}
