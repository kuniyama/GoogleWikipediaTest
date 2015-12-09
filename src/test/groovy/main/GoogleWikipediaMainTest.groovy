package main

import geb.spock.GebSpec

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.ie.InternetExplorerDriver

import page.GoogleHomePage
import page.GoogleResultsPage
import page.WikipediaPage
import spock.lang.Unroll

class GoogleWikipediaMainTest extends GebSpec {
	@Unroll
	def "first result for wikipedia search should be wikipedia"() {

		setup:
		switch(driverName){
			case "firefox" :
				driver = new FirefoxDriver()
			//browser.config.setDriverConf()
				break
			case "chrome":
				driver = new ChromeDriver()
			//browser.config.setDriverConf("org.openqa.selenium.firefox.FirefoxDriver")
				break
			case "ie":
				driver = new InternetExplorerDriver()
			//browser.config.setDriverConf("org.openqa.selenium.firefox.FirefoxDriver")
				break
		}

		when:
		to GoogleHomePage

		then:
		at GoogleHomePage

		when:
		search("test")

		then:
		waitFor { at GoogleResultsPage }

		when:
		search("wikipedia")

		then:
		waitFor { at GoogleResultsPage }

		and:
		waitFor { firstResultLink.text() == "Wikipedia"}

		when:
		firstResultLinkClick()

		then:
		waitFor { at WikipediaPage }

		where:
		driverName << ["firefox", "chrome", "ie"]
	}

	def cleanup(){
		driver.quit()
	}
}