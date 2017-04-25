/** SVG Path API
  * Scala API to synthesize SVG paths.
  */

package regup

/** Path Parent Class
  * Uses case classes to act as an immutable stream of an SVG path
  */
abstract class Path;

/** Acts as a terminating path
  * Compiles to Z
  */
case class ClosePath() extends Path {
	override def toString(): String =  "Z"; 
}

/** Acts as a moveto
  * Compiles to M (x) (y)
  */
case class MoveTo(x:Int, y:Int, next:Path = ClosePath()) extends Path {
	override def toString(): String =  s"M $x $y ${next}" 
}

/** Acts as a lineto,
  * Compiles to L (x) (y)
  */
case class LineTo(x:Int, y:Int, next:Path = ClosePath()) extends Path {
	override def toString(): String =  s"L $x $y ${next}"; 
}

/** Acts as a vertical lineto,
  * Compiles to V (y),
  * Always travels along y-axis
  */
case class VLineTo(y:Int, next:Path = ClosePath()) extends Path {
	override def toString(): String =  s"V $y ${next}"; 
}

/** Acts as a Horizontal lineto,
  * Compiles to H (x),
  * Always travels along x-axis
  */
case class HLineTo(x:Int, next:Path = ClosePath()) extends Path {
	override def toString(): String =  s"H $x ${next}"; 
}

/** Acts as a relative vertical lineto,
  * Compiles to v (y),
  * Always travels along y-axis
  * Can accept negative values
  */
case class RVLineTo(y:Int, next:Path = ClosePath()) extends Path {
	override def toString(): String =  s"v $y ${next}"; 
}

/** Acts as a relative Horizontal lineto,
  * Compiles to h (x),
  * Always travels along x-axis,
  * can accept negative values
  * @return A path component for horizontal relative
  */
case class RHLineTo(x:Int, next:Path = ClosePath()) extends Path {
	override def toString(): String =  s"h $x ${next}"; 
}

/** Acts as a Bezier Curve,
  * Compiles to C x1 y1, x2 y2, x y,
  * @return A path component for Bezier curves
  */
case class BezierTo(x1:Int, y1:Int, x2:Int, y2:Int, x:Int, y:Int, next:Path = ClosePath()) extends Path {
	override def toString(): String =  s"C $x1 $y1 $x2 $y2 $x $y ${next}"; 
}