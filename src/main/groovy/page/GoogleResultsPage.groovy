package page

import geb.Page
import module.GoogleSearchModule

class GoogleResultsPage extends Page {
	static at = { title.endsWith "Google Search" }
	static content = {
		// reuse our previously defined module
		search { module GoogleSearchModule}

		// content definitions can compose and build from other definitions
		results { $("div.g") }
		result { i -> results[i] }
		resultLink { i -> result(i).find("a") }
		firstResultLink { resultLink(0) }
	}
}