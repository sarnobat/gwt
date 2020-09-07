package springRest.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MovieController {

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView test(@PathVariable("id") String name, ModelMap model)
			throws IOException {
		model.addAttribute("movie", name);
		return new ModelAndView("list");
	}

      @RequestMapping(value = "/", method = RequestMethod.GET)
        public ModelAndView test(ModelMap model)
                        throws IOException {
                model.addAttribute("movie", "foobar");
                return new ModelAndView("list");
        }

}
