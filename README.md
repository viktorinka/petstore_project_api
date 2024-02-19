<h1 align="center"> Demo project to automate API testing for service <a href="https://petstore.swagger.io/">Petstore swagger</h1>
<div align="center">
  <a href="https://petstore.swagger.io/"><img alt="Petstore swagger" src="media/logo/swagger-logo.png"></a>
</div>

> Swagger is a toolkit for API developers from SmartBear Software and the former specification on which the OpenAPI specification is based.

# :open_file_folder: <a name="TableOfContents">Table of contents</a>

* <a href="#Description">Description</a>
* <a href="#Technology">Tools and technologies</a>
* <a href="#HowToRun">How to run</a>
* <a href="#AllureReport">Test results report in Allure Report</a>
* <a href="#AllureTestOps">Allure TestOps integration</a>
* <a href="#Jira">Jira integration</a>
* <a href="#Telegram">Telegram Notifications</a>

<a id="Description"></a>
# :bulb: Description
The test project consists of API tests.\
A brief list of interesting facts about the project:
- [x] Fake data generating with `Faker` library
- [x] Using `Lombok` for models for API tests
- [x] Objects serialization/deserialization for API requests/responses using `Jackson`
- [x] Using request/response specifications for API tests
- [x] Custom Allure listener for beautiful API requests/responses logging
- [x] `Allure TestOps` integration
- [x] Autotests as test documentation
- [x] `Jira` integration

<a id="Technology"></a>
# :technologist: Tools and a technologies
<p  align="center">
  <code><img width="5%" title="IntelliJ IDEA" src="media/logo/IDEA-logo.svg"></code>
  <code><img width="5%" title="Java" src="media/logo/java-logo.svg"></code>
  <code><img width="5%" title="REST-Assured" src="media/logo/rest-assured-logo.svg"></code>
  <code><img width="5%" title="Gradle" src="media/logo/gradle-logo.svg"></code>
  <code><img width="5%" title="JUnit5" src="media/logo/junit5-logo.svg"></code>
  <code><img width="5%" title="Allure Report" src="media/logo/allure-Report-logo.svg"></code>
  <code><img width="5%" title="Allure TestOps" src="media/logo/allure-ee-logo.svg"></code>
  <code><img width="5%" title="Github" src="media/logo/git-logo.svg"></code>
  <code><img width="5%" title="Jenkins" src="media/logo/jenkins-logo.svg"></code>
  <code><img width="5%" title="Jira" src="media/logo/jira-logo.svg"></code>
  <code><img width="5%" title="Telegram" src="media/logo/telegram_logo.svg"></code>
</p>

The autotests in this project are written in `Java`.\
`Gradle` - is used as a build automation tool.  \
`JUnit5` - to execute tests.\
`REST Assured` - for easy API testing of REST services.\
`Jenkins` - CI/CD for running tests remotely.\
`Allure Report` - for test results visualisation.\
`Telegram Bot` - for test results notifications.\
`Allure TestOps` - as Test Management System.

<a id="HowToRun"></a>
# :computer: How to run

### Local running tests

```bash
gradle clean test
```

### Remote running tests

### <img width="5%" src="media/logo/jenkins-logo.svg"> Running tests in [Jenkins](https://jenkins.autotests.cloud/job/pinterest_project_ui/)

Main page of the build:
<p align="center">
  <img src="media/jenkins_page.png" alt="Jenkins" width="800">
</p>
<p align="center">
  <img src="media/jenkins_config.gif" alt="Jenkins" width="800">
</p>

After build is completed, in the <code><strong>*Builds history*</strong></code> opposite the build number will appear
the *Allure Report* icon, clicking on which will open the page with the generated html-report.

<a id="AllureReport">

## <img width="5%" src="media/logo/allure-Report-logo.svg"> Test results report in [Allure Report](https://jenkins.autotests.cloud/job/petstore_project_api/10/allure/)

<p align="center">
  <img src="media/allure-report_1.png" alt="allure-report1" width="900">
</p>
<p align="center">
  <img src="media/allure-report_2.png" alt="allure-report1" width="900">
</p>

<a id="AllureTestOPS">

## <img width="5%" src="media/logo/allure-ee-logo.svg"> Integration with [Allure TestOps](https://allure.autotests.cloud/launch/35710)

### Main dashboard

<p align="center">
  <img src="media/allure-tops_1.png" alt="dashboard" width="900">
</p>

### Test results

<p align="center">
  <img src="media/allure-tops_2.png" alt="testresults" width="900">
</p>

<a id="Jira">

## <img width="5%" src="media/logo/jira-logo.svg"> Integration with [Jira](https://jira.autotests.cloud/browse/HOMEWORK-1108)

<p align="center">
  <img src="media/logo/jira_task.png" alt="jira" width="900">
</p>

<a id="Telegram">

## <img width="5%" src="media/logo/telegram_logo.svg"> Telegram notifications using a bot
After the build is completed, a special bot created in <code>Telegram</code>, automatically processes and sends a test run report message.

<p align="center">
<img src="media/telegram_report.png">
</p>


