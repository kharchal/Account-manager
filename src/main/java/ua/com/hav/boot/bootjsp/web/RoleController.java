package ua.com.hav.boot.bootjsp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.hav.boot.bootjsp.model.Role;
import ua.com.hav.boot.bootjsp.repositories.RoleRepo;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by sunny on 14.12.17
 */
@Controller
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleRepo roleRepo;

    @RequestMapping("/")
    public String list(Model model) {
        List<Role> roles = roleRepo.findAll();
        model.addAttribute("roles", roles);
        List<Integer> unused = roleRepo.getUnused();
        model.addAttribute("unused", unused);
        return "roles/list";
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.POST)
    public String save(@Valid Role r, BindingResult errors) {
        if (errors.hasErrors()) {
            return "roles/form";
        }
        roleRepo.save(r);
        return "redirect:/roles/";
    }

    @RequestMapping("/{id}/delete")
    public String delete(@PathVariable Integer id) {
        roleRepo.delete(id);
        return "redirect:/roles/";
    }

    @RequestMapping("/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Role role = (id == 0) ? new Role() : roleRepo.findOne(id);
        model.addAttribute("rolex", role);
        return "roles/form";
    }
}
