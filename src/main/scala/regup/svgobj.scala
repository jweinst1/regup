package regup

/** Basic Svg Object signifier
  * Has type method
  */
trait SvgObj {
	def name():String
}

/** Specifies SVG Path structure
  * 
  */
trait SvgPath {
	def values():Array[Int]
	def command():Char
}