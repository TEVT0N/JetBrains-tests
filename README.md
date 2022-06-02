# Autotests for JetBrains website

## :page_with_curl:    Content

➠ [Tests](#globe_with_meridians-tests)

➠ [Technology stack](#computer-Technology-stack)

➠ [Running tests from the terminal](#technologist-Running-tests-from-terminal)

➠ [Run tests on remote selenoid server](#Run-tests-on-remote-selenoid-server)

➠ [The project on Jenkins](#-The-project-on-Jenkins)

➠ [Test results report in Allure Report](#-Test-results-report-in-Allure-Report)

➠ [Integration with Allure TestOps](#-Integration-with-allure-testops)

➠ [Notifications in Telegram using a bot](#-Notifications-in-Telegram-using-a-bot)

➠ [Пример запуска теста в Selenoid](#-пример-запуска-теста-в-selenoid)

## <a name="globe_with_meridians-tests"></a>:globe_with_meridians: Tests

- [x] Checking for errors in the home page console log
- [x] Page title should have header text
- [x] Login with valid credentials
- [x] Verify search is working
- [x] Verify advanced search is opening
- [x] Verify search in plugin marketplace is working
- [x] Verify change language is working

## :computer: Technology stack

<p align="center">
<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="Selenoid" src="images/logo/Selenoid.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="6%" title="Allure TestOps" src="images/logo/Allure_TO.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
</p>

```mermaid        
    stateDiagram-v2
        State1: START
        State2: Java & IntelliJ IDEA
        State3: Selenide & JUnit5
        State4: Gradle
        State5: GitHub
        State6: Jenkins
        State7: Selenoid
        State8: Allure Report
        State9: Telegram
        State10: STOP
        State1 --> State2
        State2 --> State3
        State3 --> State4
        State4 --> State5
        State5 --> State6
        State6 --> State7
        State7 --> State8
        State8 --> State9
        note right of State2 : Coding
        note left of State3 : Frameworks
        note right of State4 : Project building
        note left of State5 : Version control system and project hosting
        note right of State6 : Parameterization and build launch
        note left of State7 : Containerization
        note right of State8 : Reports
        note left of State9 : Notifications
```

## :technologist: Running tests from the terminal

### Local test run

```
gradle clean test
```

### Run tests on remote selenoid server

```
gradle clean test -Dconfig=RemoteConfig
```

### Additional build parameters you could use 

> <code>REMOTE_DRIVER_URL</code> – адрес удаленного сервера, на котором будут запускаться тесты.
>
> <code>-Dbrowser</code> – to change browser, by default it's Chrome. 
>
> <code>-DbrowserVersion</code> – to change browser version, by default it's the last available.
>
> <code>-DbrowserSize</code> – to change browser size, by default it's 1920x1080.
>
> <code>-DbaseUrl</code> – to change base url for the tests, by default it's https://www.jetbrains.com/
>
> <code>-DselenoidUrl</code> – to change selenoid server on which the tests are going to run.

## <img width="4%" title="Jenkins" src="images/logo/Jenkins.svg"> The project on [Jenkins](https://jenkins.autotests.cloud/job/JetBrains-website/)

<p align="center">
  <img src="images/screens/Jenkins.png">
</p>

## <img width="4%" title="Allure Report" src="images/logo/Allure_Report.svg"> Test results report in [Allure Report](https://jenkins.autotests.cloud/job/JetBrains-website/allure/)

### :pushpin: Allure report main page

<p align="center">
<img title="Allure Overview" src="images/screens/allure_overview.png">
</p>

### :pushpin: The test suite

<p align="center">
<img title="Allure Behaviors" src="images/screens/allure_test_suite.png">
</p>

### :pushpin: Dashboard

<p align="center">
<img title="Allure Overview Dashboard" src="images/screens/allure_dashboard.png">
</p>

## <img width="4%" title="Allure TestOPS" src="images/logo/Allure_TO.svg"> Integration with [Allure TestOps](https://allure.autotests.cloud/launch/13201)

<p align="center">
  <img src="images/screens/Allure_TO.png" alt="dashboards">
</p>

## <img width="4%" title="Telegram" src="images/logo/Telegram.svg"> Notifications in Telegram using a bot

> When the build is complete, the bot created in Telegram automatically sends a message with a report (instead of Telegram notifications can be sent to Slack or email).
<p align="center">
<img title="Telegram Notifications" src="images/screens/telegram_notifications.png">
</p>

## <img width="4%" title="Selenoid" src="images/logo/Selenoid.svg"> Пример запуска теста в Selenoid

> Each test in the report is accompanied by a video. One such video is shown below.
<p align="center">
  <img title="Selenoid Video" src="images/gif/selenoid_video.gif">
</p>