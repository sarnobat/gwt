package com.rohidekar.uibinder.client;

import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(String input, AsyncCallback<String> callback) throws IllegalArgumentException;

	void getNames(AsyncCallback<Map<String, String>> callback);

	void createNewUser(AsyncCallback<String> callback);
}
