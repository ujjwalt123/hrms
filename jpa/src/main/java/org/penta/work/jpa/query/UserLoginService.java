package org.penta.work.jpa.query;

import static org.penta.work.boostrap.port.utils.EncryptionUtil.encrypt;

import org.penta.work.boostrap.port.query.UserLogin;
import org.penta.work.jpa.entity.UserEntity;
import org.penta.work.jpa.repository.UserRepository;

public class UserLoginService implements UserLogin {

	private  UserRepository repository;

    public UserLoginService(UserRepository repository) {
        this.repository = repository;
    }
    
    private final String LOGIN_SALT = "UJJWALTIWARI";

    @Override
    public String login(String email, String password) {
        UserEntity userEntity = repository.findByEmailAndPassword(email, password);
        return userEntity != null ? encrypt(userEntity.getId() + "<>" + LOGIN_SALT) : null;
    }
}
