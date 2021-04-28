package cz.czechitas.java2webapps.ukol3.controller;

import cz.czechitas.java2webapps.ukol3.entity.Vizitka;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Kontroler obsluhující zobrazování vizitek.
 */
@Controller
public class VizitkaController {
  private final List<Vizitka> seznamVizitek;

  private VizitkaController() {
    seznamVizitek = new ArrayList<>();
    seznamVizitek.add(new Vizitka("Bára Pecháčková", "Hry s.r.o.", "Na Vítězné pláni 1/1160", "140 00, Praha 4 Nusle", "pechackova@gvp.cz", "604 654 321", "hry.cz"));
    seznamVizitek.add(new Vizitka("Matěj Kubita", null, "Mezi lesy", "250 66 Zdiby", "matej@gmail.com", "777687357", null));
    seznamVizitek.add(new Vizitka("Andrea Vomáčková", null, "Griffith Observatory", "2800 E Observatory Rd, Los Angeles, CA 90027", "vomackova@gmail.com", null, null));
    seznamVizitek.add(new Vizitka("Evžen Mrkvička", "Mrkve s.r.o.", "Baker st", "Marylebone, London, UK", "mrkvicka@gmail.com", "604683245", "mrkvicka.cz"));
    seznamVizitek.add(new Vizitka("Fantomas", null, null, null, null, null, null));
  }

  @GetMapping("/")
  public ModelAndView seznam() {
      ModelAndView modelAndView = new ModelAndView("seznam");
      modelAndView.addObject("vizitky", seznamVizitek);
      return modelAndView;
  }

  @GetMapping(value = "/detail", params = "id")
  public ModelAndView detail(int id) {
    ModelAndView modelAndView = new ModelAndView("detail");
    modelAndView.addObject("vizitka", seznamVizitek.get(id));
    return modelAndView;
  }

  @GetMapping("/nova")
  public ModelAndView nova() {
      ModelAndView result = new ModelAndView("nova");
      result.addObject("vizitky", seznamVizitek);
      return result;

  }

  @PostMapping(value = "/detail", params = "id")
  public String delete(int id) {
    seznamVizitek.remove(id);
    return "redirect:/";
  }

  @PostMapping (value = "/nova", params = {"jmeno", "firma", "ulice", "obecPsc", "email", "telefon", "web"})
  public String append(Vizitka vizitka) {
    seznamVizitek.add(vizitka);
    return "redirect:/";
  }
}
