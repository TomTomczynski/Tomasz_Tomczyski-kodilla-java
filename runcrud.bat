call gradlew build
if "%ERRORLEVEL%" == "0" goto rename
echo.
echo GRADLE BUILD has errors - breaking work
goto fail

:rename
if exist build\libs\crud.war (
 del build\libs\crud.war
 ren E:\KursyIT\Kodilla\tasks\build\libs\tasks-0.0.1-SNAPSHOT.war crud.war
 ) else (
ren E:\KursyIT\Kodilla\tasks\build\libs\tasks-0.0.1-SNAPSHOT.war crud.war
)
if "%ERRORLEVEL%" == "0" goto stoptomcat
echo Cannot rename file
goto fail

:stoptomcat
call %CATALINA_HOME%\bin\shutdown.bat

:copyfile
copy -build\libs\crud.war %CATALINA_HOME%\webapps
if "%ERRORLEVEL%" == "0" goto runtomcat
echo Cannot copy file
goto fail

:runtomcat
call %CATALINA_HOME%\bin\startup.bat
goto end

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.
