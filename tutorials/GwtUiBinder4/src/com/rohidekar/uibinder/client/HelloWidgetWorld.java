package com.rohidekar.uibinder.client;

import java.util.Collection;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

public class HelloWidgetWorld extends Composite {

	interface MyUiBinder extends UiBinder<Widget, HelloWidgetWorld> {
	}

	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

	@UiField
	ListBox listBox;

	public HelloWidgetWorld(Collection<String> collection) {
		// sets listBox
		initWidget(uiBinder.createAndBindUi(this));
		for (String name : collection) {
			listBox.addItem(name);
		}
	}
}