(is jetty, but not 8080)
http://mojo.codehaus.org/gwt-maven-plugin/user-guide/archetype.html

mvn archetype:generate \
   -DarchetypeGroupId=org.codehaus.mojo \
   -DarchetypeArtifactId=gwt-maven-plugin \
   -DarchetypeVersion=2.5.0

groupID: GwtMavenGroup
artifactID: GwtMaven
module: GwtMavenModule

mvn gwt:run
