package org.penta.work.jpa.query;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.penta.work.boostrap.port.model.User;
import org.penta.work.boostrap.port.query.UserProfile;
import org.penta.work.jpa.entity.UserEntity;
import org.penta.work.jpa.repository.UserRepository;

public class UserProfileService implements UserProfile {

	private  UserRepository repository;

    public UserProfileService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User getUserByIdentifier(UUID id) {
    	
        UserEntity userEntity = repository.findById(id);
        User user =  new User(userEntity.getId(), userEntity.getEmail(), userEntity.getPassword(), userEntity.getName(), 
        		userEntity.getMobile());
        return user;
    }

	@Override
	public List<User> getAllUsers() {
		
		List<UserEntity> userEntities = repository.findAll();
		List<User> users = userEntities.stream().map(userEntity -> new User(userEntity.getId(), userEntity.getEmail(), 
				userEntity.getPassword(), userEntity.getName(), userEntity.getMobile())).collect(Collectors.toList());
		return users;
	}
}
