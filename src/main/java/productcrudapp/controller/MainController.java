package productcrudapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import productcrudapp.dao.ProductDao;
import productcrudapp.model.Product;

@Controller
public class MainController {

	@Autowired
	private ProductDao dao;
	
	@RequestMapping(value="index1.html" , method = RequestMethod.GET)
	public ModelAndView load()
	{
		return new ModelAndView("add_product_form", "key1" , new Product());
	}
	
	
	@RequestMapping(value="handle-product.html" , method = RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute Product product )
	{
		dao.insert(product);
		return new ModelAndView("redirect:/search.html");
	}
	
	@RequestMapping(value = "search.html", method = RequestMethod.GET)
	public ModelAndView Search() {

		List searchList = dao.search();
		return new ModelAndView("search", "SearchList", searchList);

	}
	
	
	@RequestMapping(value = "delete.html", method = RequestMethod.GET)
	public ModelAndView Delete(@ModelAttribute Product product, @RequestParam int id) {

		product.setId(id);
		dao.delete(product);
        
		return new ModelAndView("redirect:/search.html");

	}

	@RequestMapping(value = "edit.html", method = RequestMethod.GET)
	public ModelAndView Edit(@ModelAttribute Product product, @RequestParam int id) {

		product.setId(id);
		List editList = dao.edit(product);

		return new ModelAndView("update_form", "key2", editList.get(0));

	}
}
