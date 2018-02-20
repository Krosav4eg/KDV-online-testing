# Autotests for MAGDV project
Author Sergey Potapov s.potapov@andersenlab.com .
Project contains autotests for verifying base application functional.


### Framework contain:
============================**short description**===================================

Selenium WebDriver version 3.0.1 - http://www.seleniumhq.org/download/
TestNG version 6.8 - http://testng.org/doc/download.html
The Chrome driver (version 2.34) supports Chrome versions 62-64 https://sites.google.com/a/chromium.org/chromedriver/home
Gecko driver (version 0.18.0 / 32 bit.) supports versions from Firefox from 53 and higher
Https://github.com/mozilla/geckodriver/releases/tag/v0.18.0


### Preconditions before installing the project
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
Just click on `index.html` file right button and option Run.

### Logger running:
After running tests we can launch logger from directory `./test-output/Logging.html`
Just click on `Logging.html` file right button and option Run.

============================**framework structure**===================================

### package main.java.Core
This package contain base framework logic as: 
basePage(include custom commons methods)
driverFactory(helps select needed browser and provide driver capabilities)
logger(logging mechanism and html structure)
readDocs(contain xml parser for test data)
utils(contain assert collector, constants, test reporter steps and waiting methods)

### package main.java.KDV_business_logic.
The package contain main application pages and realizes page object pattern.

### package main.java.resources.
The package contain browser drivers and log4j properties

### package main.test.KDV_testcases.
The package contain test cases for KDV project

### package main.test.KDV_resources.
For running KDV xml tests 

### All tests data
The file constantsData.xml contain all test data






