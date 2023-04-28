package com.gaguena.sproducts.model

import com.gaguena.sproducts.persistence.Repository
import com.gaguena.sproducts.persistence.table.PlayTable
import slick.lifted.TableQuery

import java.time.LocalDateTime
import scala.concurrent.Future

case class Play(id: Option[Long], date: LocalDateTime, font: String, createdAt: LocalDateTime)


import scala.concurrent.ExecutionContext.Implicits.global
import slick.jdbc.PostgresProfile.api._
object Plays extends Repository[Play] {
  lazy val all = TableQuery[PlayTable]
  def salvar(play: Play) =
    transactionally((all returning all.map(_.id)) insertOrUpdate play map (_.map(id => play.copy(id = id)).getOrElse(play)))

  def findAll: Future[List[Play]] = db.run(all.result.map(_.toList))

  def create = db.run((all.schema).create)
}