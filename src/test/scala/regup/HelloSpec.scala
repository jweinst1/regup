package regup

import org.scalatest._

class EndSpec extends FlatSpec  {
  "The EndNode class" should "return true" in {
    val f = regup.EndNode();
    assert(f());
  }
}
