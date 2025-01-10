# Selenium Test Suite for Cinel Website

This project contains an automated test suite using **Selenium WebDriver**, **TestNG** to perform tests on a web application and **Allure Reports** for report generation. The tests involve login, interactions with the user interface, capturing screenshots at various stages of the test, and performing specific actions on the user profile.

## Prerequisites

Before running the project, make sure you have the following prerequisites installed:

- **Java 8 or higher**: Ensure that Java is properly installed on your system.
- **Maven**: The project uses Maven to manage dependencies.
- **ChromeDriver**: The Chrome WebDriver is automatically managed via [WebDriverManager](https://github.com/bonigarcia/webdrivermanager).
- **Selenium WebDriver**: The library required for interacting with the browser.
- **TestNG**: The framework used for running the tests.
- **Allure Report (optional)**: If you want to integrate Allure for beautiful report generation.

## Project Structure

- `AllureReports` – Contains the `OpenUser` class with the automated tests.
  - **Tests**:
    - `loginTest()`: Performs login into the application.
    - `openMessage()`: Interacts with a message in the UI.
    - `openUser()`: Accesses the user profile and performs some actions.
    - `refreshPage()`: Refreshes the page.
  - **Screenshot Capture**: Screenshots are taken during the tests to help with debugging and generating reports.
  - **Reports**: The project can be configured to generate execution reports.

## Installation

### Step 1: Download and Install Dependencies

If you don't have Maven set up yet, follow the instructions in the [official Maven documentation](https://maven.apache.org/install.html).

Download the project and install the dependencies using the following command:

```bash
mvn clean install
```

### Step 2: Environment Setup

1. WebDriver: The Chrome WebDriver will be automatically managed by WebDriverManager. However, you need to ensure that the Chrome browser is installed on your machine.

2. Screenshot Path: The takeScreenshot method saves the screenshots in the directory C:\\Screenshots\\ (modify the path as needed).

3. Base URL: In the setup() method, set the URL of the application to be tested by replacing the value of "base.url" with the actual URL.

```java 
driver.get("base.url");
```

### Step 3: Run the Tests
To run the tests, use the following command:

```bash
mvn test 
```
The test results will be displayed in the terminal, and the screenshots will be saved in the configured folder.

### Code Structure
- WebDriver Setup: The WebDriver is initialized in the setup() method, where the Chrome browser is configured to be controlled by the tests.

- Tests:
    Login test
    Opening messages and actions on the user profile
    Page refresh

- Screenshot Capture: During the tests, the takeScreenshot() method captures an image of the screen and saves it to a specific directory.

- Logout: After the tests, the logout is performed, and the browser is closed.

### Allure Reports (optional)
If you want to integrate Allure for generating visual reports, follow the steps below:

1. Add the Allure dependency to pom.xml:

```xml 
<dependency>
    <groupId>io.qameta.allure</groupId>
    <artifactId>allure-java-commons</artifactId>
    <version>2.13.9</version>
    <scope>test</scope>
</dependency>
```

2. Generate Allure Report 
After running the tests, generate the report with the command:

``` bash
mvn allure:serve
```

### Contributing

Contributions are welcome! To contribute, follow these steps:
1. Fork the project.
2. Create a branch for your modifications (git checkout -b my-feature).
3. Commit your changes (git commit -am 'Add new feature').
4. Push to the remote repository (git push origin my-feature).
5. Open a Pull Request.

### License
This project is licensed under the MIT License - see the LICENSE file for details.

```css
This translation ensures the `README.md` is fully in English, maintaining all the details for setup, running the tests, and contributing to the project.
```
