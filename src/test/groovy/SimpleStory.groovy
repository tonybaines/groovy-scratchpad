scenario "Simple story", {
	given "A string", {
		s = "Hello"
	}
	when "it is made upper case", {
		S = s.toUpperCase()
	}
	then "it should be in upper case", {
		throw new RuntimeException()
		S.shouldBe "HELLO"
	}
}