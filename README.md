# MakeMyTrip
TTT Automation Bootcamp Final Project

## Quick start
- Clone the repo: https://github.com/SnehaKejriwal/MakeMyTrip.git
- Install and configure Java 
- Install and configure Eclipse
- Install and configure Maven
Read the [Getting started page](https://www.notion.so/Getting-Started-db9caa03dae648f688597a29d73e0866)

## Project Description
Automating a flow of hotel booking from makemytrip website using selenium. I have used java as a programming language and Maven as project build tool.
Have used TestNG for writing testcases.
##### Link of website
<https://www.makemytrip.com/hotels/>

#### Search Criteria Used for Booking
1. City : default City 
2. Check in : default checkin Date
3. Check out : default checkout Date
4. Room & Guest : 1 room, 4 adults and 3 children
5. Age of Three Children : 1, 3 and 5 age
5. Travelling Reason : Work

##### Filter Criteria Used
1. Minimum PricePerNight --- Rs 2000
2. User Rating -- 4 and above (Very Good)

## Project Sturcture
Within the download you'll find the following directories and files.

```text
MakeMyTrip/
├── src/main/java
│   ├── FinalProject.MakeMy Trip
│      ├── driverManager
│         ├── browserTypes
│            ├── FinalProject.MakeMyTrip.driverManager.browserTypes.ChromeManager.java
│            ├── FinalProject.MakeMyTrip.driverManager.browserTypes.FireFoxManager.java
│      ├── FinalProject.MakeMyTrip.driverManager.BrowserName.java
│      ├── FinalProject.MakeMyTrip.driverManager.DriverFactory.java
│      ├── FinalProject.MakeMyTrip.driverManager.DriverManager.java
│      ├── files
│         ├── FinalProject.MakeMyTrip.files.PropertyReader.java
│         ├── FinalProject.MakeMyTrip.files.SearchCriteriaExcelReader.java
│      ├── pageflow 
│         ├── FinalProject.MakeMyTrip.pageflow.HomePageFlow.java
│         ├── FinalProject.MakeMyTrip.pageflow.SearchListingPageFlow.java
│      ├── pages
│         ├── FinalProject.MakeMyTrip.pages.BasePage.java
│         ├── FinalProject.MakeMyTrip.pages.HomePage.java
│         ├── FinalProject.MakeMyTrip.pages.HotelDetail.java
│         ├── FinalProject.MakeMyTrip.pages.ReviewPage.java
│         ├── FinalProject.MakeMyTrip.pages.SearchListingPage.java
│      ├── pojo
│          ├── FinalProject.MakeMyTrip.pojo.GuestInformationBO.java
│          ├── FinalProject.MakeMyTrip.pojo.HotelBO.java
│          ├── FinalProject.MakeMyTrip.pojo.SearchBO.java
│      ├── utilities
│          ├── FinalProject.MakeMyTrip.utilities.Screenshot.java
├── src/test/java
│   ├── FinalProject.MakeMy Trip
│      ├── dataprovider
│          ├── FinalProject.MakeMyTrip.dataprovider.SearchCriteriaDataProvider.java
│      ├── listeners
│          ├── FinalProject.MakeMyTrip.listeners.CustomListener.java
│      ├── testng
│        ├── FinalProject.MakeMyTrip.testng.RunTimeTestNG.java
│      ├── tests
│          ├── FinalProject.MakeMyTrip.tests.BaseTest.java
│          ├── FinalProject.MakeMyTrip.tests.HotelBookingTest.java
│      ├── StartUp. java
├── src/main/resources
   ├── config.properties
   ├── log.properties
├── src/test/resources
   ├── SearchCriteria.xlsx
├── pom.xml 
```

## Project Documentation
###### pom.xml -- It is the execution entry point for the project.Here all the maven Dependencies has been added which is required for building the project.
                  I have used maven-surefire-plugin, with the help of that we will generate TestNG.xml at the runtime.
###### Source Folder src/main/ java
There are six packages
1. driverManager-- This package handles all the codes related launching of the browser and if any capabilites required for the browser.
                   There is an enum class     : BrowserName. java
                   There is an abstract class : DriverManager.java

2.files-- In this package there are two files one for reading property file and other excel reader files.
