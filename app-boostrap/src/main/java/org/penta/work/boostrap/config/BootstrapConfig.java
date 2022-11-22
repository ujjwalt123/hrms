package org.penta.work.boostrap.config;

import org.penta.work.boostrap.domain.AccountDomain;
import org.penta.work.boostrap.domain.UserDomain;
import org.penta.work.boostrap.port.RequestAccounts;
import org.penta.work.boostrap.port.RequestUser;
import org.penta.work.boostrap.port.create.AccountWriter;
import org.penta.work.boostrap.port.create.UserSignup;
import org.penta.work.boostrap.port.query.AccountReader;
import org.penta.work.boostrap.port.query.UserLogin;
import org.penta.work.boostrap.port.query.UserProfile;
import org.penta.work.jpa.config.JpaConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(JpaConfig.class)
public class BootstrapConfig {
    @Bean
    public RequestAccounts getRequestAccounts( AccountReader accountReader, AccountWriter accountWriter) {
        return new AccountDomain(accountReader, accountWriter);
    }
    
    @Bean
    public RequestUser getUserInterface( UserLogin userLogin, UserSignup userSignup, UserProfile userProfile) {
        return new UserDomain(userLogin, userSignup, userProfile);
    }

}