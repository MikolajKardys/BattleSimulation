package agents

import agents.Teams.Teams

class Infantry(position: Vector2D, direction: Vector2D, team: Teams) extends Agent(position, direction, team){
  def matesCount(pos: Vector2D):  Int = {
    val mates = Engine.getSurrounding(pos, radius = 1.5)
    mates.count(_.team == team)
  }

  //Stay in formation
  override def move(moveType: ActionType.ActionType, preMoveTab: Seq[Vector2D] = null): Boolean = {
    val moves = Engine.getMoves(position)

    super.move(moveType)
  }

}
object Infantry{
  def apply(position: Vector2D, direction: Vector2D, team: Teams) = new Infantry(position, direction, team)
}

object Cavalry{
  def apply(position: Vector2D, direction: Vector2D, team: Teams): Agent = {
    val cavalry = new Agent(position, direction, team)
    cavalry.statistics = Map(
      "range" -> 1.5, "strength" -> 5, "maxHealth" -> 20, "attackCost" -> 5, "moveCost" -> 2, "maxMorale" -> 15,
      "value" -> 2
    )
    cavalry.health = cavalry.statistics("maxHealth")
    cavalry.morale = cavalry.statistics("maxMorale")
    cavalry
  }
}


object Bowman{
  def apply(position: Vector2D, direction: Vector2D, team: Teams): Agent = {
    val bowman = new Agent(position, direction, team)
    bowman.statistics = Map(
      "range" -> 10, "strength" -> 5, "maxHealth" -> 10, "attackCost" -> 5, "moveCost" -> 4, "maxMorale" -> 4
    )
    bowman.health = bowman.statistics("maxHealth")
    bowman
  }
}/*
object Bowman{
  def apply(position: Vector2D, direction: Vector2D, team: Teams) = new Infantry(position, direction, team)
}*/

