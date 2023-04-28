package com.gaguena.sproducts.persistence

import org.slf4j.LoggerFactory
import slick.basic.DatabaseConfig
import slick.jdbc.JdbcProfile
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.Future

trait DataBase {
  private val dbConfig = DatabaseConfig.forConfig[JdbcProfile]("app.db")
  def db = dbConfig.db
  val logger = LoggerFactory.getLogger(getClass)
}

class Repository[T] extends DataBase {

  private def run[T](query: => DBIO[T]): Future[T] = {
    logger.info(s"Repository run $query")
    db.run[T](query)
  }
  def transactionally[T](query: => DBIO[T]): Future[T] = run(query.transactionally)
}
