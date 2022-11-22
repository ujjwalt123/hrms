package org.penta.work.boostrap.rest.responseModel;

import lombok.Data;

@Data
public class FetchUserResponse extends Response {

	public FetchUserResponse(String status, Object data) {
		super(status, data);
	}
}
