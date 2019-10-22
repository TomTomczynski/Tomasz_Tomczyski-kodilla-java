
call runcrud.bat
if "%ERRORLEVEL%" == "0" (
start "C:\Program Files\Mozilla Firefox\firefox.exe" http://localhost:8080/crud/v1/task/getTasks
) else (
echo Compilation error.
)
