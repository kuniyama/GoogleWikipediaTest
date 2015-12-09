//choose "htmlunit", "firefox", "ie", "chrome"
driver = "firefox"

//reports setting
reportsDir = "target/geb-reports"
reportOnTestFailureOnly = true

//chrome - http://chromedriver.storage.googleapis.com/index.html
System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe")

//ie - http://selenium-release.storage.googleapis.com/index.html
System.setProperty("webdriver.ie.driver", "driver/IEDriverServer.exe")