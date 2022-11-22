package org.penta.work.boostrap.rest.responseModel;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class LoginResponse<T> extends Response<T> {
	
	private String loginToken;
	
	public LoginResponse(String status, T data) {
		super(status, data);
	}
	
}
