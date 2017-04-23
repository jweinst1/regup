package regup

/*
* Base class for grouping together different match nodes.
*/
abstract class RegNode;

/*
* Class that represents the final matching state, reached when a
* string is fully matched.
*/
case class EndNode() extends RegNode {
	def apply():Boolean = true;
}




