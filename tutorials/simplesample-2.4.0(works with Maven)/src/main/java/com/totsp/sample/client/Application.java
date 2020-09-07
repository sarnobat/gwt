package com.totsp.sample.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Application implements EntryPoint {
	public void onModuleLoad() {
		ScrollPanel aScrollPanel = new ScrollPanel();
		aScrollPanel.setSize("400px", "400px");

		Frame aFrame = new Frame(
				"https://docs.google.com/document/d/13Ka0yMaknQaVTvqphlEK7IrALbqlPfJ9qJLnKJH7pfw/edit") { //$NON-NLS-1$
			@Override
			protected void onLoad() {
				super.onLoad();
				// Window.alert(getParent().getElement().getClass().getName());
				Timer theTimer = new Timer() {
					public void run() {
						((ScrollPanel) getParent())
								.setVerticalScrollPosition(297);
						((ScrollPanel) getParent())
								.setHorizontalScrollPosition(120);
					}
				};
				theTimer.schedule(3000);
			}
		};

		aScrollPanel.add(aFrame);
		aFrame.setHeight("80000px");
		aFrame.setWidth("800px");
		RootPanel.get().add(aScrollPanel);
	}
}
