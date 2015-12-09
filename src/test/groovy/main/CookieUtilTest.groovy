package main

import geb.spock.GebSpec
import spock.lang.Shared
import util.GebCookieUtil

class CookieUtilTest extends GebSpec {

	@Shared GebCookieUtil cookieUtil = new GebCookieUtil(driver)

	def "output cookie"() {
		when:
		go "http://www.yahoo.co.jp"

		then:
		waitFor{ title == "Yahoo! JAPAN"}
		cookieUtil.printCookies()
		assert cookieUtil.getCookieVal("JV") == null

		when:
		$("form").p = "sample"
		$("input",value:"検索").click()

		then:
		waitFor{ title == "「sample」の検索結果 - Yahoo!検索"}
		cookieUtil.printCookies()
		assert cookieUtil.getCookieVal("JV") != null
	}
}