package regup

import org.scalatest._

class LineTest extends FlatSpec {
  "The lineto class" should "compile to L x y Z" in {
    val f = regup.LineTo(3, 3, regup.ClosePath());
    assert(f.toString == "L 3 3 Z");
  }
}

class WrapTest extends FlatSpec {
  "The wrapSvg method" should "wrap path in <svg>" in {
    val f = "<circle></circle>";
    assert(regup.SvgUtils.wrapSvg(f, 4, 4) == """<svg height="4" width="4" xmlns="http://www.w3.org/2000/svg"><circle></circle></svg>""");
  }
}

class HLineTest extends FlatSpec {
  "The Hlineto class" should "compile to H x" in {
    val f = regup.HLineTo(50, regup.LineTo(3, 3, regup.ClosePath()));
    assert(f.toString == "H 50 L 3 3 Z");
  }
}