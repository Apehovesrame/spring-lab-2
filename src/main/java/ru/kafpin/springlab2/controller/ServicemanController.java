package ru.kafpin.springlab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kafpin.springlab2.model.Serviceman;
import ru.kafpin.springlab2.repository.ServicemanRepository;

import java.util.Optional;

@Controller
@RequestMapping("/servicemen")
public class ServicemanController {

    private final ServicemanRepository repository;

    public ServicemanController(ServicemanRepository repository) {
        this.repository = repository;
    }

    // Получение списка всех сущностей
    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("servicemen", repository.findAll());
        return "index";
    }

    // Получение одной сущности по id
    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Long id, Model model) {
        Optional<Serviceman> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return "redirect:/servicemen";
        }
        model.addAttribute("serviceman", optional.get());
        return "details";
    }

    // Страница добавления
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("serviceman", new Serviceman());
        return "form";
    }

    // Сохранение
    @PostMapping("/save")
    public String save(@ModelAttribute Serviceman serviceman) {
        repository.save(serviceman);
        return "redirect:/servicemen";
    }

    // Страница изменения
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") Long id, Model model) {
        Optional<Serviceman> optional = repository.findById(id);
        if (optional.isEmpty()) {
            return "redirect:/servicemen";
        }
        model.addAttribute("serviceman", optional.get());
        return "form";
    }

    // Удаление по id
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        return "redirect:/servicemen";
    }
}