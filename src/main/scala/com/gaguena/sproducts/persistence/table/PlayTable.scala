package com.gaguena.sproducts.persistence.table

import com.gaguena.sproducts.model.Play
import slick.jdbc.PostgresProfile.api._

class PlayTable (tag: Tag) extends Table[Play](tag, "play") {
  def id = column[Option[Long]]("id", O.PrimaryKey, O.AutoInc)
  def date = column[java.time.LocalDateTime]("play_date")
  def font = column[String]("play_font")
  def createdAt = column[java.time.LocalDateTime]("created_at")
  def * = (id, date, font, createdAt) <> (Play.tupled, Play.unapply)
}
