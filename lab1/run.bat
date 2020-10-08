echo off
set path=C:\Program Files\Java\jdk-15\bin
set include=C:\Program Files\Java\jdk-15\include
set lib=C:\Program Files\Java\jdk-15\lib
set link=C:\Program Files\Java\jdk-15\bin
javac -version lab1.java
javap -c lab1>1.txt
java lab1
pause