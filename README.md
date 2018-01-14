# selenium-calculator-tests
Demo purpose. Reuse restricted.

### Deployment Instructions
>1. Go inside the directory **/selenium-calculator-tests/realeyes.aut.test/**
>2. Type `mvn clean package` in terminal or command prompt.
Download Maven (https://maven.apache.org/download.cgi).

### BrowserStack Integration
Tests can be executed in Remotely on BrowserStack. A full fledget test is present inside `TestSet2` class. To Enable the test please find following steps.
1. Set the value of BrowserStack `USERNAME` and `AUTOMATE_KEY`. 
2. set `enabled=true` in `@Test` annotation.

_Currently desktop browsers are supported._

### Modules used
>1. Java 1.8
>2. Selenium 3.4.0
>3. TestNG 6.11
>4. Maven
