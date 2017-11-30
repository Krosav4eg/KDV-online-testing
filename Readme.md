# Autotests for MAGDV project
Author Sergey Potapov s.potapov@andersenlab.com .
Project contains autotests for verifying base application functional.


### Framework contain:
MORE DETAIL DOCUMENTATION SEE: https://drive.google.com......
============================short description===================================
Selenium WebDriver version 3.4 - http://www.seleniumhq.org/download/
TestNG version 6.8 - http://testng.org/doc/download.html
The Chrome driver (version 2.28) supports Chrome versions 54-59 https://sites.google.com/a/chromium.org/chromedriver/home
Gecko driver (version 0.16.1 / 32 bit.) supports versions from Firefox from 53 and higher
Https://github.com/mozilla/geckodriver/releases/tag/v0.16.1


### Preconditions before installing the project``
OS Windows 7 and higher
JDK 1.8 - http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
Maven (v 3.3 and higher ) https://maven.apache.org/download.cgi


### Install instructions after preconditions
1.Clone project from repository: 
https://gitlab.dev.magdv.com/outsource/online-testing.git
2.If no project is currently open in IntelliJ IDEA, click Import Project on the Welcome screen.
Otherwise, select File→ New →Project from Existing Sources.
3.In the dialog windows that opens, select the desired pom.xml file and click OK.
4.Build a maven project in IntelliJ IDEA  Select Build menu > Rebuild Project Option.
 You can see the output in IntelliJ 
5.If the project is not built then you should run the command reimport for pom.xml:

### Run tests with maven
In maven command line right: 
mvn test 
and execute script button

### Simple running test
In case simple test running chose any needed test case in resource folder  > select required xml file  > press right click  > Run option.

### Report running:
After running tests we can launch reports from directory `./test-output/html/index.html`
Just click on `index.html` file right button and option Run
