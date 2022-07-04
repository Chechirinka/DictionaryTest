set tomcatDir=E:\apache-tomcat-9.0.62
call mvn clean install
cd target/
ren DictionaryTest.war ROOT.war
del %tomcatDir%/webapps ROOT.war
rmdir /s %tomcatDir%/webapps/ROOT
move ROOT.war %tomcatDir%/webapps
cd %tomcatDir%/bin
call shutdown.bat
startup.bat