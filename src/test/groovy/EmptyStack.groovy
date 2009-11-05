import org.junit.runner.RunWith;
import spock.lang.*;

@Speck(java.util.Stack)
@RunWith(Sputnik)
class EmptyStack {
  def stack = new Stack()

  def "size"() {
    expect: stack.size() == 0
  }

  def "pop"() {
    when: stack.pop()
    then: thrown(EmptyStackException)
  }

  def "peek"() {
    when: stack.peek()
    then: thrown(EmptyStackException)
  }

  def "push"() {
    when:
    stack.push("elem")

    then:
    stack.size() == 1
    stack.peek() == "elem"
  }
}
