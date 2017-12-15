package ua.com.hav.boot.bootjsp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.com.hav.boot.bootjsp.model.Kind;
import ua.com.hav.boot.bootjsp.model.Pet;
import ua.com.hav.boot.bootjsp.repositories.KindRepo;
import ua.com.hav.boot.bootjsp.repositories.PetRepo;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

/**
 * Created by sunny on 11.12.17
 */
@Controller
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetRepo petDao;
    @Autowired
    private KindRepo kindDao;

    @RequestMapping({"/"})
    public String index(Model model, HttpSession session) {
        List<Pet> pets = petDao.findAll();
        System.out.println("pets = " + pets);
        model.addAttribute("pets", pets);
        if (session.getAttribute("kinds") == null) {
            session.setAttribute("kinds", getKinds());
        }
        return "pets/list";
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.POST)
    public String save(@Valid Pet pet, BindingResult errors) {
        if (errors.hasErrors()) {
            return "pets/form";
        }
        petDao.save(pet);
        return "redirect:/pets/";
    }

    @RequestMapping("/{id}/delete")
    public String delete(@PathVariable Integer id) {
        petDao.delete(id);
        return "redirect:/pets/";
    }

    @RequestMapping("/{id}")
    public String edit(@PathVariable Integer id, Model model, @RequestParam(required = false) boolean kindsUpdate, HttpSession session) {
        Pet pet = (id == 0) ? new Pet() : petDao.findOne(id);
        model.addAttribute("pet", pet);
        if (kindsUpdate || session.getAttribute("kinds") == null) {
            session.setAttribute("kinds", getKinds());
        }
        return "pets/form";
    }

    private Map<Integer, String> getKinds() {
        return kindDao.findAll()
                .stream()
                .collect(toMap(Kind::getId, Kind::getValue));
    }


}
