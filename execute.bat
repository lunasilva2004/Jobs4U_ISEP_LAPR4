@echo off

REM search directory
set "target_dir=./jobs4u.app1/target/"

REM search for the jar file containing "jobs4u.app1"
for /r "%target_dir%" %%a in (*jobs4u.app1*.jar) do (
    set "jar_file=%%a"
    goto :execute
)

echo No JAR files containing 'jobs4u.app1' in the name were found in %target_dir%.
exit /b 1

:execute
REM execute the jar file
java -jar "%jar_file%"
