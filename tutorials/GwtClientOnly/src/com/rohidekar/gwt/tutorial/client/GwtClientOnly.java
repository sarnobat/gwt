package com.rohidekar.gwt.tutorial.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class GwtClientOnly implements EntryPoint {

	public void onModuleLoad() {
		final Button sendButton = new Button("Call Server 5");
		final TextBox nameField = new TextBox();
		nameField.setText("GWT User");

		// We can add style names to widgets
		sendButton.addStyleName("sendButton");

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("nameFieldContainer").add(nameField);
		RootPanel.get("sendButtonContainer").add(sendButton);

		// Focus the cursor on the name field when the app loads
		nameField.setFocus(true);
		nameField.selectAll();

		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler {
			public void onClick(ClickEvent event) {
				doGet("http://localhost:4444");
			}

			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					doGet("http://localhost:4444");
				}
			}
		}

		// Add a handler to send the name to the server
		MyHandler handler = new MyHandler();
		sendButton.addClickHandler(handler);
		nameField.addKeyUpHandler(handler);
	}

	public static void doGet(String url) {
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);

		try {
			Request response = builder.sendRequest(null, new RequestCallback() {

				@Override
				public void onResponseReceived(Request request, Response r) {
					Window.alert("response received: " + r.getText() + "\n"
							+ r.getHeadersAsString());
				}

				@Override
				public void onError(Request request, Throwable e) {
					Window.alert("Response error: " + e);

				}
			});
		} catch (RequestException e) {
			e.printStackTrace();
			Window.alert("Failed to send the request: " + e.getStackTrace());
		}
	}
}
