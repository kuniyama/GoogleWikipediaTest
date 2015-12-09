import geb.Browser
import page.GoogleHomePage
import page.GoogleResultsPage

Browser.drive {
	to GoogleHomePage
	search.field.value("wikipedia")
	waitFor { at GoogleResultsPage }
	firstResultLink.click()
}