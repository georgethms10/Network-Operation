package com.innowaves.networktest.asychttpclientcall;


public interface Response {
	
	
	  void onSuccess(String response, int code);
	  
	  void onFail(String response, int code);

}
