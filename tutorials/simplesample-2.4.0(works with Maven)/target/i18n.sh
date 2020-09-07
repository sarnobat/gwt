#!/bin/bash

CP="/Users/sarnobat/.m2/repository/com/google/gwt/gwt-user/1.5.3/gwt-user-1.5.3.jar":"/Users/sarnobat/.m2/repository/com/google/gwt/gwt-dev/1.5.3/gwt-dev-1.5.3-mac.jar":"/Users/sarnobat/Desktop/mac-sync/src/java/tutorials/simplesample-2.4.0(works with Maven)/src/main/java":"/Users/sarnobat/Desktop/mac-sync/src/java/tutorials/simplesample-2.4.0(works with Maven)/src/main/resources":"/Users/sarnobat/Desktop/mac-sync/src/java/tutorials/simplesample-2.4.0(works with Maven)/target/classes"

"/System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/bin/java" -XstartOnFirstThread -Xmx512m -cp "$CP"  com.google.gwt.i18n.tools.I18NSync -out /Users/sarnobat/Desktop/mac-sync/src/java/tutorials/simplesample-2.4.0(works with Maven)/src/main/java com.totsp.sample.client.AppConstants
"/System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/bin/java" -XstartOnFirstThread -Xmx512m -cp "$CP"  com.google.gwt.i18n.tools.I18NSync -createMessages  -out /Users/sarnobat/Desktop/mac-sync/src/java/tutorials/simplesample-2.4.0(works with Maven)/src/main/java com.totsp.sample.client.AppMessages
