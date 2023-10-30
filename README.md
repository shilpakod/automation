## Objective ##
This repository contains the solution for a UI automation testing challenge using Java, Selenium, and TestNG. The purpose is to implement a specific test case and demonstrate proficiency in the page object model, test setup, and configuration management.

### Test Case: Sign Up on ABCMouse.com ###

*  Go to https://www.abcmouse.com
*  Click the “Sign Up” button
*  Verify that the URL is https://www.abcmouse.com/abt/register
*  Enter an Email address
*  Click the “Submit” button
*  Verify that the URL is https://www.abcmouse.com/abt/subscription
*  Verify the presence of the text “Become a Member!” on the subscription page

## Getting Started ##

#### Prerequisites ####
Make sure you have the following installed:

* Java Development Kit (JDK)
* Maven for dependency management
* Selenium WebDriver
* Web browser and corresponding WebDriver (e.g., ChromeDriver for Google Chrome)

## Installation ##

1. Clone the repository to your local machine:

`git clone https://github.com/shilpakod/automation.git`

2. Navigate to the project directory:
`cd <project-directory>`

3. Install the required dependencies using Maven:

`mvn install`

4. Running the Tests

Execute the tests on Chrome driver using command line:

`mvn clean test -Dbrowser=chrome`

Execute the tests on Chrome driver using command line:

`mvn clean test -Dbrowser=firefox`







