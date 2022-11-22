package org.penta.work.jpa.config;

import org.penta.work.boostrap.port.create.AccountWriter;
import org.penta.work.boostrap.port.create.UserSignup;
import org.penta.work.boostrap.port.query.AccountReader;
import org.penta.work.boostrap.port.query.UserLogin;
import org.penta.work.boostrap.port.query.UserProfile;
import org.penta.work.jpa.create.AccountWriteService;
import org.penta.work.jpa.create.UserSignupService;
import org.penta.work.jpa.query.AccountReadService;
import org.penta.work.jpa.query.UserLoginService;
import org.penta.work.jpa.query.UserProfileService;
import org.penta.work.jpa.repository.AccountRepository;
import org.penta.work.jpa.repository.UserRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("org.penta.work.jpa.entity")
@EnableJpaRepositories("org.penta.work.jpa.repository")
public class JpaConfig {
    
	@Bean
    public AccountReader getAccountReadService(AccountRepository repository) {
        return new AccountReadService(repository);
    }
    @Bean
    public AccountWriter getAccountWriteService(AccountRepository repository) {
        return new AccountWriteService(repository);
    }
    
    @Bean
    public UserLogin getUserLoginService(UserRepository repository) {
        return new UserLoginService(repository);
    }
    @Bean
    public UserSignup getUserSignupService(UserRepository repository) {
        return new UserSignupService(repository);
    }
    @Bean
    public UserProfile getUserProfileService(UserRepository repository) {
        return new UserProfileService(repository);
    }

}
