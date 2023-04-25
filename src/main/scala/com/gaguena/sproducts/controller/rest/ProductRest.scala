package com.gaguena.sproducts.controller.rest

import com.gaguena.sproducts.controller.support.RestJsonSupport
import com.gaguena.sproducts.model.product.ProductData

class ProductRest extends RestJsonSupport {

  get("/:code") {
    ProductData(None, "Arroz")
  }
}
