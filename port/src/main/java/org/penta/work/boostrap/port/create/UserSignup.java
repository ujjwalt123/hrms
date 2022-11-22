package org.penta.work.boostrap.port.create;

import java.util.UUID;

import org.penta.work.boostrap.port.model.User;

public interface UserSignup {

	Boolean signup(User user);
}
