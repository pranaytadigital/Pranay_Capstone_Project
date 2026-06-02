# Pranay Capstone Project

## Overview

This project is a Selenium Automation Framework developed using Java and the Page Object Model (POM) design pattern.
The framework is designed for automated web application testing with reusable components, better maintainability, and easy test execution.

---

# Project Structure

```text
Pranay_Capstone_Project
│
├── src/main/java
│   ├── base
│       └── Base classes for browser setup and configuration
│   │
│   ├── pages
│   │   └── Contains Page Object classes
│   │
│   ├── utilities
│   │   └── Utility/helper classes
│
├── src/test/java
│    ├── tests
│    │   └── Contains Test Classes
│
├── src/test/resources
│   └── Test data / configuration files
│
├── testng.xml
│   └── TestNG suite execution file
│
├── pom.xml
│   └── Maven dependencies and project configuration
│
└── README.md
```

---

# Tools & Technologies Used

* Java
* Selenium WebDriver
* TestNG
* Maven
* Eclipse IDE
* Git & GitHub
* Page Object Model (POM)

---

# Framework Features

* Page Object Model Design Pattern
* Reusable methods and components
* Maven dependency management
* TestNG test execution
* Browser automation using Selenium WebDriver
* Easy maintenance and scalability

---

# Prerequisites

Before running the project, make sure the following software is installed:

* Java JDK
* Eclipse IDE
* Maven
* Git
* Chrome Browser
* ChromeDriver (compatible with browser version)

---

# How to Run the Tests

## Method 1: Using TestNG

1. Open the project in Eclipse
2. Locate the `testng.xml` file
3. Right click on `testng.xml`
4. Select:

```text
Run As → TestNG Suite
```

---

## Method 2: Using Maven Command

Open terminal/command prompt inside project folder and run:

```bash
mvn clean test
```

---

# Maven Dependencies

Dependencies are managed through the `pom.xml` file.

Example dependencies used:

* Selenium Java
* TestNG
* WebDriverManager (if used)

---

# Version Control

This project is maintained using Git and hosted on GitHub.

GitHub Repository:

https://github.com/pranaytadigital/Pranay_Capstone_Project

---

# Author

Pranay Dhoble
