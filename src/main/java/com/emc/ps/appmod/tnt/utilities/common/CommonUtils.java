package com.emc.ps.appmod.tnt.utilities.common;

import org.springframework.http.HttpStatus;

import com.emc.ps.appmod.tnt.domain.response.ResponseObject;

public class CommonUtils {

	public static ResponseObject buildSuccessResponse(Object data) {
		ResponseObject responseObject = new ResponseObject();
		responseObject.setStatusCode(HttpStatus.OK.value());
		responseObject.setData(data);
		return responseObject;
	}

}
