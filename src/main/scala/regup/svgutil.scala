package regup
/** Houses methods to wrap Path objects in xml tags for SVG formatting
  * 
  */
object SvgUtils {
	/** Wraps string in specified SVG sized wrapper
	  *
	  */
	def wrapSvg(input:String, width:Int, height:Int):String = s"""<svg height="$height" width="$width" xmlns="http://www.w3.org/2000/svg">$input</svg>""";
	/** Wraps Path object in wrapper
	  *
	  */
	def wrapPath(input:Path, fill:String, stroke:String):String = s"""<path d="${input.toString()}" fill="$fill" stroke="$stroke"/>""";
}