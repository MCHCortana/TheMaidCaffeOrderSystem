package k2w.thePub.controller;

import k2w.thePub.dto.DrinkDTO;
import k2w.thePub.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DrinkController {
    @Autowired
    private DrinkService drinkService;

    @GetMapping("/drink-menu")
    public ModelAndView drinkMenu() {
        return new ModelAndView("/drink-menu").addObject("listOfDrinks", drinkService.getAll());
    }

    @GetMapping("/drinks")
    public @ResponseBody List<DrinkDTO> getAll() {
        return drinkService.getAll();
    }

    @PostMapping("/drinks-create")
    public @ResponseBody DrinkDTO create(@RequestBody DrinkDTO data){
        return drinkService.create(data);
    }


}
