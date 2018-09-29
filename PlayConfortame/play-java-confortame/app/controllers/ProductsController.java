package controllers;

import play.mvc.*;
import java.util.*;
import models.*;
import views.html.*;
import play.data.*;
import javax.inject.*;

public class ProductsController extends Controller {

	private FormFactory formFactory;
	private Product products;

	@Inject
    public ProductsController(FormFactory formFactory) {
        	this.formFactory = formFactory;
		products = new Product();
    }

    /*public Result list() {
		Set<Product> setOfProducts = products.findAll();
		return ok(list.render(setOfProducts));
	}*/

	public Result showBlank() {
		Form<Product> productForm = formFactory.form(Product.class);
		return ok(show.render(productForm));
	}

	public Result show(Integer id) {
		Product product = Product.findById(id);
		if (product == null) {
			return notFound("Product "+id+" does not exist.");
		}
		Form<Product> productForm = formFactory.form(Product.class);
		Form<Product> filledForm = productForm.fill(product);
		return ok(show.render(filledForm));
	}

	public Result save() {
		Product product = formFactory.form(Product.class).bindFromRequest().get();		
		Product.add(product);
		return ok("Saved product: "+product);
	}

}
