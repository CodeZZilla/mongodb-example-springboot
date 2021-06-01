package com.example.mongo;


import com.example.mongo.models.Address;
import com.example.mongo.models.Hotel;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.stereotype.Controller
public class Controller {

    private final HotelService service;

    public Controller(HotelService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("hotels", service.findAll());

        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {

        model.addAttribute("hotel", new Hotel());
        return "create";
    }

    @PostMapping("/save")
    public String save(Hotel hotel, BindingResult result) {

        if (result.hasErrors())
            return "redirect:/";

        service.save(hotel);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        service.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable String id,Model model) {

        model.addAttribute("hotel", service.findById(id).get());
        return "edit";
    }
}
