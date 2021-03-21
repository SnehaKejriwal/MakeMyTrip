# MakeMyTrip
TTT Automation Bootcamp Final Project

## Quick start
- Clone the repo: https://github.com/SnehaKejriwal/MakeMyTrip.git
- Install and configure Java 
- Install and configure Eclipse
- Install and configure Maven
Read the [Getting started page](https://www.notion.so/Getting-Started-db9caa03dae648f688597a29d73e0866)

## Project Description
Automating a flow of hotel booking from makemytrip website using selenium webdriver. I have used java as a programming language and Maven as project build tool.
Have used TestNG for writing testcases.
##### Link of website
<https://www.makemytrip.com/hotels/>

#### Search Criteria Used for Booking
1. City : default City 
2. Check in : default checkin Date
3. Check out : default checkout Date
4. Room & Guest : (1 room, 4 adults and 3 children) And (1 Room, 4 adults and 2 Children)
5. Age of Three Children : (1, 3 and 5 age respectively) And (1, 3 age respectively)
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
│         ├── FinalProject.MakeMyTrip.pageflow.HotelDetailsPageFlow.java
│         ├── FinalProject.MakeMyTrip.pageflow.ReviewPageFlow.java
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
                   There is an enum class BrowserName.java where different browsers like chrome, firefox safari is defined as enum.
                   There is an abstract class DriverManager.java. Different BrowserManager classes are extending this and providing implementation for the methods.

2. files-- In this package there are two files one for reading property file and other excel reader files.
3. pages-- In this packages all the pages related to test flow are there. There is an abstract BasePage class where all the methods related to browswer interaction are                      defined.This is the parent class for all the pages.
4. pageflow-- In this package, I have defined different pagesFlow where a single method is responsible to perform all the operations related to a page. 
              Like in HomePageFlow I have defined a method performSearch. This is just to reduce line of code in HotelBookingtest.java file.
5. utilities-- In this package all the common files related to project is defined.
6. pojo-- In this package, I have defined all the pojo classes.

###### Source Folder src/test/java
There are four packages
1. dataprovider-- In this package , I have defined a class searchCriteriaDataProvider.java. This class is responsible for reading data from the excel file and provide the data                    to test method.
2. listeners-- In this package, I have defined a customListener class that implements ITESTListener interface.
3. testng-- In this package, I have defined a RunTimeTestNG class. This class is responsible for creating testng.xml at runtime.
4. tests--In this package, I have defined two classes One is the BaseTest where i have used BeforeMethod and AfterMethod testng annotations
          Second is the HotelBookingTest where my actual test method is defined.

5. StartUp.java-- In this class all the prerequitise functionality is defined ie. loading propertyfile, configure log file, calling RunTimeTestNG class reading data before                        actual test begin 

###### Source Folder src/main/resources
I have defined two files 

1. config.properties-- This file is responsible for providing url and browser choice.
2. log.properties-- This file is responsible for defining the formatting and styling of logs.

###### Source Folder src/test/resources
In this, I have defined test data file. I have used excel as external source for defining searchCriteria.

#### Known Bug
1. LoginSignUp pop-up in homePage is not handled properly.If pop-up displayed script will work else script will failed because of     NoSuchElementException.Tried handling those but was not able to handle.
2. Same issue in Review Page when recommendation section is not available.
3. Filter pricePerNight-- sometime its works sometime it doesnot.
4. AddingRoom-- Currently script is only adding one room . Not checking based on the Guest count.
5. In Firefox Browser script works only till searching of the hotel.

## Creators

*Sneha Kejriwal**

- <https://github.com/SnehaKejriwal/>

## Thanks
<a href="https://www.thetesttribe.com/"></a>

Thanks to [TheTestTribeCommunity](https://www.thetesttribe.com/) for providing such a wonderful platform and providing this Bootcamp.

Thanks to my trainer [Kunal Ashar](https://github.com/kunalashar25) & [Amar Singh] for sharing your knowledge and help us learn automation in the most simpler way any beginner can ask for.
