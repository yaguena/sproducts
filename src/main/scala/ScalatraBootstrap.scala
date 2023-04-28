import com.gaguena.sproducts._
import com.gaguena.sproducts.controller.rest.ProductRest
import com.gaguena.sproducts.model.Plays
import org.scalatra._

import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    context.mount(new ProductRest, "/products/*")
    Plays.create
  }

  override def destroy(context: ServletContext) = {
    super.destroy(context)
  }
}
