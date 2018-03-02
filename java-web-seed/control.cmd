@ECHO OFF

IF "%1%"=="" GOTO FAIL
IF "%1%"=="run" GOTO RUN
IF "%1%"=="build" GOTO BUILD

:BUILD
cd %~dp0
cd %~d0
cd src\backend
call mvn clean
call mvn package
cd ..\..\
rd /s /Q public
cd src\frontend
call npm run build
cd ..\..\
echo "project build success.."
GOTO EXIT

:RUN
cd %~dp0
cd %~d0
java -jar bin\Application.jar
GOTO EXIT

:FAIL
echo "build|run"

:EXIT