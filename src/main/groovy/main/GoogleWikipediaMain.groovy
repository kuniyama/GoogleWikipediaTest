package main

import geb.Browser
import page.GoogleHomePage
import page.GoogleResultsPage
import page.WikipediaPage

Browser.drive {
	to GoogleHomePage
	assert at(GoogleHomePage)
	search.field.value("wikipedia")
	waitFor { at GoogleResultsPage }
	assert firstResultLink.text() == "Wikipedia"
	firstResultLink.click()
	waitFor { at WikipediaPage }
}