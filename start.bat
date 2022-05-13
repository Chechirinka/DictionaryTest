
xcopy /S /Y /D src\main\resources\ bin\classes\resources

javac -d bin/classes -sourcepath src/main/java src/main/java/*.java

java -classpath bin/classes DictionarTest file

pause