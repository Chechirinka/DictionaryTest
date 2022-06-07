xcopy /S /Y /D src\main\resources\ bin\classes\resources

javac -encoding utf8 -d bin/classes  -sourcepath src/main/java src/main/java/dictionary/*.java

java -Dfile.encoding="UTF-8" -classpath bin/classes dictionary.Main file

pause