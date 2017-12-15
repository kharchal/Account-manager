package ua.com.hav.boot.bootjsp.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.com.hav.boot.bootjsp.model.Man;
import ua.com.hav.boot.bootjsp.model.Pet;
import ua.com.hav.boot.bootjsp.model.Role;
import ua.com.hav.boot.bootjsp.repositories.PetRepo;
import ua.com.hav.boot.bootjsp.repositories.RoleRepo;
import ua.com.hav.boot.bootjsp.serv.ManService;

import javax.validation.Valid;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by sunny on 12.12.17
 */
@Controller
@RequestMapping("/men")
public class ManController {

    private static final Logger logger = Logger.getLogger(ManController.class);

    @Autowired
    private ManService manService;
    @Autowired
    private PetRepo petDao;
    @Autowired
    private RoleRepo roleRepo;

    @RequestMapping("")
    public String list(Model model) {
        model.addAttribute("men", manService.findAll());
        logger.debug("show all men");
        return "men/list";
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.POST)
    public String save(@Valid Man man, BindingResult errors, @RequestParam List<Integer> roleid) {
        if (errors.hasErrors()) {
            logger.debug("there are some validation errors...");
            return "men/form";
        }
        if (roleid.size() == 1) {
            logger.debug("there are no any roles selected...");
            errors.rejectValue("roleList", "man.roleList","must not be empty");
            return "men/form";
        }
        roleid.removeIf(id -> id == 0);
        man.setRoleList(roleRepo.findAll().stream().filter(r -> roleid.contains(r.getId())).collect(toList()));
        manService.save(man);
        return "redirect:/men/";
    }

    @RequestMapping("/{id}/delete")
    public String delete(@PathVariable Integer id) {

        manService.delete(id);
        return "redirect:/men/";
    }

    @RequestMapping("/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Man man = null;
        if (id == null || id == 0) {
            man = new Man();
        } else {
            man = manService.findOne(id);
        }
        List<Pet> pets = petDao.findManless();
        model.addAttribute("pets", pets);
        model.addAttribute("man", man);
        return "men/form";
    }

    @ModelAttribute("roles")
    public List<Role> getRoles() {
        return roleRepo.findAll();
    }

    @RequestMapping("/{id}/pets/{p_id}/delete")
    public String petDelete(@PathVariable Integer id, @PathVariable("p_id") Integer petId) {
        Man man = manService.findOne(id);
        man.removeFromList(petId);
        manService.save(man);
        return "redirect:/men/" + id;
    }

    @RequestMapping("/{id}/pets/{p_id}/add")
    public String petAdd(@PathVariable Integer id, @PathVariable("p_id") Integer petId) {
        Man man = manService.findOne(id);
        Pet pet = petDao.findOne(petId);
        man.addPet(pet);
        manService.save(man);
        return "redirect:/men/" + id;
    }

    @RequestMapping("{id}/next")
    public String next(@PathVariable Integer id) {
        return "redirect:/men/" + manService.findNextId(id);
    }

    @RequestMapping("{id}/prev")
    public String prev(@PathVariable Integer id) {
        return "redirect:/men/" + manService.findPrevId(id);
    }
}
