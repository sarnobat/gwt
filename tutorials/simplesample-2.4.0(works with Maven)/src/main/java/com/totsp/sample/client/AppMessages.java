package com.totsp.sample.client;

/**
 * Interface to represent the messages contained in resource bundle:
 * 	/Users/sarnobat/Windows/usb/Professional/GWT/workspace/simplesample-2.4.0/src/main/resources/com/totsp/sample/client/AppMessages.properties'.
 */
public interface AppMessages extends com.google.gwt.i18n.client.Messages {
  
  /**
   * Translated "the messages test inject here {0}".
   * 
   * @return translated "the messages test inject here {0}"
   */
  @DefaultMessage("the messages test inject here {0}")
  @Key("message1")
  String message1(String arg0);
}
