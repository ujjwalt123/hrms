package org.penta.work.jpa.create;

import static org.penta.work.jpa.utils.CommonUtil.validateUUID;

import org.penta.work.boostrap.port.create.UserSignup;
import org.penta.work.boostrap.port.model.User;
import org.penta.work.jpa.entity.UserEntity;
import org.penta.work.jpa.repository.UserRepository;
import org.springframework.beans.BeanUtils;

public class UserSignupService implements UserSignup {

	private  UserRepository repository;

    public UserSignupService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Boolean signup(User user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        return validateUUID(repository.save(userEntity).getId());
    }
}
