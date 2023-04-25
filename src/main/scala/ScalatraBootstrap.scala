import com.gaguena.sproducts._
import com.gaguena.sproducts.controller.rest.ProductRest
import org.scalatra._

import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    context.mount(new ProductRest, "/products/*")
  }
}
