package org.penta.work.boostrap.rest.api;

import java.util.List;
import java.util.UUID;

import org.penta.work.boostrap.port.RequestUser;
import org.penta.work.boostrap.port.model.User;
import static org.penta.work.boostrap.port.utils.EncryptionUtil.encrypt;

import org.penta.work.boostrap.rest.exception.InvalidUserException;
import org.penta.work.boostrap.rest.responseModel.LoginResponse;
import org.penta.work.boostrap.rest.responseModel.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	
	private RequestUser userInterface;

    public UserController(RequestUser userInterface) {
        this.userInterface = userInterface;
    }

	@PostMapping("/signup")
    ResponseEntity<Response<Void>> signup(@RequestBody User user ) {
        Boolean isSuccess = userInterface.signup(user);
        Response<Void> response = new LoginResponse<>(isSuccess ? "OK": "NOK", null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
	
	@PostMapping("/login")
    ResponseEntity<Response<Void>> login(@RequestBody User user ) {
		//Interceptor, controller advice
        String loginToken = userInterface.login(user.getEmail(), user.getPassword());
        LoginResponse<Void> response = new LoginResponse<>(loginToken != null ? "OK": "NOK", null);
        response.setLoginToken(loginToken);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
	
	@GetMapping("/")
    ResponseEntity<LoginResponse<User>> getUser(@RequestHeader(value="identifier") String identifier) {
        User user = userInterface.getUserByIdentifier(identifier);
        LoginResponse<User> response = new LoginResponse<>(user != null ? "OK": "NOK", user);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
	
	@GetMapping()
    ResponseEntity<LoginResponse<List<User>>> getAllUsers() {
        List<User> users = userInterface.getAllUsers();
        LoginResponse<List<User>> response = new LoginResponse<>(users != null ? "OK": "NOK", users);
        
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
