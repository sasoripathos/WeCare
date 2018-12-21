# WeCare
WeCare is a web application built for immigration agencies that provides services for newcomers. WeCare takes in iCare templates (EXCEL files which contains service information about newcomers), checks errors and migrates data to MongoDB. It can also generate .csv reports based on data in database. 

# Final Product video
https://youtu.be/7MJ6hdX2AXA

# Get Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

## Prerequisites
Software you need to install before building the project

```
Java 8, Maven
```

## Run Unit/Integration/Acceptance Test
Clone this repository to your machine. Open a terminal/command line in the working copy (master branch) and enter following command:
```
1. cd ./code/wecare
2. mvn clean test
```
All 168 unit/integration/acceptance test cases will be run.

## Build and Run
Clone this repository to your machine. Open a terminal/command line in the working copy (master branch) and enter following command:
```
1. cd ./code/wecare
2. mvn clean install
3. java -jar target/weCare.war
```
A copy of weCare will start running on your machine.

For more details about test and build this project, please refer to documents/Test&Build Guideline/Guideline for Test and Run Project.pdf

## Built With

* [Spring](https://spring.io/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management

# How to use weCare
## weCare home page
When a copy of weCare is running on your machine. You can access weCare using your browser at http://localhost:8080
## User login
There are 3 available accounts for 3 different users.

User | Email | Password
--- | --- | --- |
Alice | alice@gmail.com | alice12345
Bob | bob@gmail.com | bob12345
Charlie | charlie@gmail.com | charlie12345

# Recent significant changes
- [11/26/2018] Added a folder for Deliverable 5 in documents/, which contains the sprint backlogs for sprint 5 & 6, guideline for test and build, as well as code review activity. Updated user stories for version 3. Updated the readme to include the link to our final product demo video. Merge newest version of project into master branch.
- [11/12/2018] Merge report generation feature and integration/UAT tests into master branch.  Added sprint3 and sprint4 folders in /documents/sprint backlog, as well as documents for those sprints. Added new folder for Deliverable 4 in /documents/, which contains the Code Review and Sprint 3 & 4 backlogs. Updated user stories to version 2.
- [11/11/2018] Added a folder for Code Review in /documents/, which contains our completed Code Review summary, Code Review guidelines, and video with our code review recommendations.
- [10/31/2018] Updated user stories to version 1.
- [10/28/2018] Added Sprint2 backlog in documents/Deliverable 3 - October 29th/Spring 2 Backlog, and documents/sprint backlog. Merged file upload feature into master branch.
- [10/25/2018] Added Sprint1 backlog in /documents/Deliverable 3 - October 29th/Spring 1 Backlog/. Created a folder for spring backlog in /documents/ that will include backlog for all sprints.
- [10/21/2018] Merged login feature into master branch.
- [10/15/2018] Added project skeleton code in /code.
- [10/10/2018] Added the second deliverable in /documents/Deliverable 2 - October 15th/. Created a folder for product backlog in /documents/ that will include the most up-to-date versions of the User Stories and Personas.
- [9/29/2018] Added the first deliverable report in /documents/
