package regup

object SvgUtils {
	def wrapSvg(input:String, width:Int, height:Int):String = s"""<svg height="$height" width="$width" xmlns="http://www.w3.org/2000/svg">$input</svg>""";
}