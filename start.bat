set DIR_PROJECT=OOP
del /s %DIR_BIN%\*.class >NUL
javac DictionarTest.java
java DictionarTest file
pause