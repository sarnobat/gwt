== Sridhar instructions ==

This project was obtained from: 
http://code.google.com/p/gwt-maven/source/browse/trunk/maven-googlewebtoolkit2-plugin/simplesample/

There are others that work. This one works but is too complicated (I want something that works with your eyes closed):
* https://github.com/tbroyer/gwt-maven-archetypes (modular-webapp, jetty instructions)
=== Jetty ===
The usual command won't work. You have to do this:

 mvn jetty:run-war

http://stackoverflow.com/questions/7260459/how-can-i-run-a-gwt-app-from-gwt-maven-plugin-without-any-browser-plugins

=== Tomcat ===
mvn clean && \
 mvn compile &&  \
 mvn install -Dmaven.test.failure.ignore=true -Dmaven.test.skip=true && \
 cp target/maven-gwt-sample-1.0-SNAPSHOT.war /opt/local/share/java/tomcat6/webapps/app.war
 
 sh /opt/local/share/java/tomcat6/bin/startup.sh
 http://localhost:5050/app

== GWT-Maven simplesample ==

Simple sample that demonstrates what a recommended POM looks like for GWT-Maven usage. 

Run with: 
"mvn gwt-maven:gwt" (run the shell) 

or 
"mvn install" (build a war)

or (subsequent runs, skip compiling again and skip tests)
"mvn -Dgoogle.webtoolkit-compileSkip=true -Dgoogle.webtoolkit.testSkip=true gwt-maven:gwt"

or 
"mvn gwt-maven:debug" (run with debugger hook, connect IDE to debug)


Note that the default POM uses the recommended "automatic" setup. This means GWT dependencies are declared in the
POM and GWT is downloaded and extracted from Maven repositories (the Maven way).  There is also an alternative
POM provided that demonstrates the "manual" way - pom-with-gwthome.xml.  This POM expects you to have 
GWT already installed on the local machine, and requires google.webtoolkit.home (gwtHome) to be specified, and GWT 
dependencies still must be present with system scope and correct systemPath.  You can run this alternative POM with 
"mvn -f pom-with-gwthome.xml gwt-maven:gwt" (assuming you edit the gwtHome and systemPath for your environment).

 
