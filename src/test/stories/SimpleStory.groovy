scenario "Simple story", {
	given "A string", {
		s = "Hello"
	}
	when "it is made upper case", {
		S = s.toUpperCase()
	}
	then "it should be in upper case", {
		S.shouldNotBe "HELLO"
	}
}