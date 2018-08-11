package com.gy.findcase.findcaseapi.jwt.response;

public class SuccessResponse implements Response {

	@Override
	public String getResponseCode() {
		return Response.CODE_SUCCESS;
	}

	@Override
	public String getResponseMsg() {
		return Response.MSG_SUCCESS;
	}

}
