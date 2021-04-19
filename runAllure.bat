set ProjectPath=%~dp0
cd %ProjectPath%
echo %ProjectPath% 
set p=%PATH%
java -javaagent:"%ProjectPath%libraries\allure\aspectjweaver-1.8.10.jar" -classpath "%ProjectPath%bin;%ProjectPath%libraries\allure\*;%ProjectPath%libraries\selenium\*;%ProjectPath%libraries\extentReportV4\*;%ProjectPath%libraries\log4J\*;%ProjectPath%libraries\*;%ProjectPath%libraries\reportNG\*;%ProjectPath%libraries\webDriverManager\*" org.testng.TestNG "%ProjectPath%bin\runNopCommerce.xml"
allure serve .\test-output\allure-results\
pause