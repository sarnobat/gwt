package com.rohidekar.uibinder.client;

import java.security.DomainCombiner;
import java.util.Map;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class GwtUiBinder4 implements EntryPoint {

	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	public void onModuleLoad() {
		System.out.println("Hello");
		greetingService.createNewUser(new AsyncCallback<String>() {
			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
			}

			@Override
			public void onSuccess(String result) {
				String userID = result;
				System.out.println(userID);
				final TextBox usernameTextBox = new TextBox();
				usernameTextBox.setValue(userID);
				RootPanel.get().add(usernameTextBox);
				greetingService.getNames(new AsyncCallback<Map<String, String>>() {
					@Override
					public void onFailure(Throwable caught) {
					}

					@Override
					public void onSuccess(Map<String, String> users) {

						RootPanel.get().add(new HelloWidgetWorld(users.values()));
					}
				});
			}
		});
	}
}
