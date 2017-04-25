package regup

/** A layer of abstraction over the individual path classes.
  * Allows mutable and growable SVG paths.
  */
class SvgSynthesizer() {
	/** Keeps the current path
	  *
	  */
	var path:Path = ClosePath();
	/** Adds a pathnode via a char and array of integers which represent x y coordinates
	  *
	  */
	def addPathNode(kind:Char, points:Array[Int]):Unit = kind match {
		case 'M' => path = MoveTo(points(0), points(1), path);
		case 'L' => path = LineTo(points(0), points(1), path);
		case 'H' => path = HLineTo(points(0), path);
		case 'V' => path = VLineTo(points(0), path);
		case 'h' => path = RHLineTo(points(0), path);
		case 'v' => path = RVLineTo(points(0), path);
		case 'C' => path = BezierTo(points(0), points(1), points(2), points(3), points(4), points(5), path);
		case 'Q' => path = QuadraticTo(points(0), points(1), points(2), points(3), path);
		case default => println(s"Invalid kind: $default");
	}
	/** Makes an SVG String with specified width height fill and stroke
	  *
	  */
	def makeSVGPath(width:Int, height:Int, fill:String = "", stroke:String = ""):String = SvgUtils.wrapSvg(SvgUtils.wrapPath(path, fill, stroke),width, height);

	def resetPath():Unit = {
		path = ClosePath();
	}
}