#Author: Suvidya Pawaskar
#Feature:Login feature
#Date:30-06-2019

@SmokeTest
Feature: Login feature
  User wants to verify login feature of Mercury Tours Application

Background: User access login page of Mercury Tours Application
            When user opens "chrome" browser
            And user enters application url as "http://www.newtours.demoaut.com/mercurywelcome.php"
            And user waits "15" seconds to Login page to be loaded
            And user maximizes browser
            Then user is on Login page of Mercury Tours application

  @SmokeTest
  Scenario: Verify that valid user able to login into Mercury Tours application
            Given user is on login page of Mercury Tours application
            When user enters "Suvidyap1" as username
            And user enters "P@ssword1" as password
            And user clicks on Sign In button
            Then user is on Flight Finder page
            When user clicks on Sign off link
            Then User access Sign on page
            
  
  
  
  
  
  
  
  
  
   

  