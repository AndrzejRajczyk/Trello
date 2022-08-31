
echo "Start, running runcrud.bat"
call c:\task\runcrud.bat
if "%ERRORLEVEL%" == "1" goto runcrudfails
goto fire



:fire
echo starting Firefox
start "" "http://localhost:8080/crud/v1/tasks"
:: start C:\"Program Files"\"Mozilla Firefox"\firefox.exe  -- new window  "http://localhost:8080/crud/v1/tasks"
if "%ERRORLEVEL%" == "0" goto firefoxfails

:runcrudfails
echo "runcrud.bat error"
goto end

:firefoxfails
echo "firefox error"
goto end


end
echo.
echo Work is finished.