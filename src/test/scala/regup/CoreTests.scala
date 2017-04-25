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

class BezierTest extends FlatSpec {
  "The BezierTo class" should "compile to C x1 y1, x2 y2, x y" in {
    val f = regup.BezierTo(2,2,3,4,8,8, regup.ClosePath());
    assert(f.toString == "C 2 2 3 4 8 8 Z");
  }
}

class SVGTest extends FlatSpec {
  "The SvgSynthesizer" should "produce SVG strings" in {
    val f = new regup.SvgSynthesizer();
    f.addPathNode('L', Array(1, 2));
    f.addPathNode('M', Array(33, 44));
    assert(f.makeSVGPath(50, 50) == """<svg height="50" width="50" xmlns="http://www.w3.org/2000/svg"><path d="M 33 44 L 1 2 Z" fill="" stroke=""/></svg>""");
  }
}