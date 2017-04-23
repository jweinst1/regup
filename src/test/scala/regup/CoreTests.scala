package regup

import org.scalatest._

class EndSpec extends FlatSpec {
  "The EndNode class" should "return true" in {
    val f = regup.EndNode();
    assert(f());
  }
}

class IterTest extends FlatSpec {
	"The CharIter class" should "iterate each character" in {
		val g = new regup.CharIter("red");
		assert(g() == 'r');
		assert(g() == 'e');
		assert(g() == 'd');
		assert(g.done);
	}
}
