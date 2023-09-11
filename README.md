# UI Test automation project for [ASOS](https://www.asos.com/)

![asos-logo.jpg](images/asos-logo.jpg)

> ASOS is a British online fashion and cosmetic retailer. The company was founded in 2000 in London, primarily aimed at young adults.
> The website sells over 850 brands as well as its own range of clothing and accessories,
> and ships to all 196 countries from fulfilment centres in the United Kingdom, the United States, and Europe.

# <a name="Technology">Tools and a technologies</a>
<p  align="center">
  <code><img width="5%" title="IntelliJ IDEA" src="./images/icons/IDEA-logo.svg"></code>
  <code><img width="5%" title="Java" src="./images/icons/java-logo.svg"></code>
  <code><img width="5%" title="Selenide" src="./images/icons/selenide-logo.svg"></code>
  <code><img width="5%" title="Selenoid" src="./images/icons/selenoid-logo.svg"></code>
  <code><img width="5%" title="Gradle" src="./images/icons/gradle-logo.svg"></code>
  <code><img width="5%" title="JUnit5" src="./images/icons/junit5-logo.svg"></code>
  <code><img width="5%" title="Allure Report" src="./images/icons/allure-Report-logo.svg"></code>
  <code><img width="5%" title="Allure TestOps" src="./images/icons/allure-ee-logo.svg"></code>
  <code><img width="5%" title="Github" src="./images/icons/git-logo.svg"></code>
  <code><img width="5%" title="Jenkins" src="./images/icons/jenkins-logo.svg"></code>
  <code><img width="5%" title="Telegram" src="./images/icons/Telegram.svg"></code>
</p>

The autotests in this project are written in `Java` using `Selenide` framework.\
`Gradle` - is used as a build automation tool.  \
`JUnit5` - to execute tests.\
`Jenkins` - CI/CD for running tests remotely.\
`Selenoid` - to remote launching browsers in `Docker` containers.\
`Allure Report` - for test results visualisation.\
`Telegram Bot` - for test results notifications.

# <a name="HowToRun">Autotest scenarios (UI)</a>

- [x] Switch website language to  another language (German)
- [x] Add new item to Saved Items
- [x] Check that Returns & Refunds page has all Topics in FAQ section
- [x] Check that Fit Assistant recommends the proper size
- [x] Check that Women's products has all sections on menu bar

# <a name="HowToRun">How to run</a>

## <a name="GradleCommand">Gradle command</a>
To run locally and in Jenkins the following command is used:
```bash
gradle clean test
```

To run with parameters:
```bash
clean
test
"-DselenoidUrl=${SELENOID_URL}"
"-DbrowserSize=${BROWSER_SIZE}"
"-Dbrowser=${BROWSER}"
"-DbrowserVersion=${BROWSER_VERSION}"
```

## <a name="RunInJenkins">Run in [Jenkins](https://jenkins.autotests.cloud/job/s.savich_asos_tests/)</a>
Main page of the build:
<p  align="center">
<img src="images/asos-jenkins-mainPage.png" alt="asos-jenkins-mainPage" width="950">
</p>

A parametrized Jenkins job:
<p  align="center">
<img src="images/jenkins-parameters.png" alt="jenkins-parameters" width="950">
</p>

# <a name="AllureReport">Test results report in [Allure Report](https://jenkins.autotests.cloud/job/s.savich_asos_tests/allure/)</a>

## Main page
Main page of Allure report contains the following blocks:

>- <code><strong>*ALLURE REPORT*</strong></code> - displays date and time of the test, overall number of launched tests, а также диаграмму с указанием процента и количества успешных, упавших и сломавшихся в процессе выполнения тестов
>- <code><strong>*TREND*</strong></code> - displays trend of running tests for all runs
>- <code><strong>*SUITES*</strong></code> - displays distribution of tests by suites
>- <code><strong>*CATEGORIES*</strong></code> - displays distribution of unsuccessful tests by defect types
<p align="center">
  <img src="images/Allure-mainPage.png" alt="AllureReportMain" width="950">
</p>

## List of tests with steps and test artefacts
On the page the list of the tests grouped by suites with status shown for each test.\
Full info about each test can be shown: tags, severity, duration, detailed steps.

<p align="center">
  <img src="images/Allure-suits.png" alt="Allure-suits" width="1150">
</p>

# <a name="TelegramNotifications">Telegram Notifications</a>
Telegram bot sends a brief report to a specified telegram chat by results of each build.
<p  align="center">
<img src="images/telegram-bot.png" alt="TelegramNotification" width="550">
</p>