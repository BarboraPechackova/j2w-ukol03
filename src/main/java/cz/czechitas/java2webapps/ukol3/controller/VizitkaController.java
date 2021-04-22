package cz.czechitas.java2webapps.ukol3.controller;

import cz.czechitas.java2webapps.ukol3.entity.Vizitka;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

/**
 * Kontroler obsluhující zobrazování vizitek.
 */
@Controller
public class VizitkaController {
  private final List<Vizitka> vizitky;

  private VizitkaController(){
    vizitky = Arrays.asList(
            new Vizitka("Bára Pecháčková", "Hry s.r.o.", "Na Vítězné pláni 1/1160", "140 00, Praha 4 Nusle", "pechackova@gvp.cz", "604 654 321", "hry.cz"),
            new Vizitka("Matěj Kubita", null, "Mezi lesy", "250 66 Zdiby", "matej@gmail.com", "777687357", null),
            new Vizitka("Andrea Vomáčková", null, "Griffith Observatory", "2800 E Observatory Rd, Los Angeles, CA 90027", "vomackova@gmail.com", null, null),
            new Vizitka("Evžen Mrkviška", "Mrkve s.r.o.", "Baker st", "Marylebone, London, UK", "mrkvicka@gmail.com", "604683245", "mrkvicka.cz"),
            new Vizitka("Fantomas", null, null, null, null, null, null)
    );}


  @GetMapping("/")
  public ModelAndView seznam() {
      ModelAndView modelAndView = new ModelAndView("seznam");
      modelAndView.addObject("vizitky", vizitky);
      return modelAndView;
  }

  @GetMapping("/detail")
  public ModelAndView detail(int id) {
    ModelAndView modelAndView = new ModelAndView("detail");
    modelAndView.addObject("vizitka", vizitky.get(id));
    return modelAndView;
  }
}
