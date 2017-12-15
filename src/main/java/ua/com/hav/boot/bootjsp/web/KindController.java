package ua.com.hav.boot.bootjsp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.com.hav.boot.bootjsp.model.Kind;
import ua.com.hav.boot.bootjsp.repositories.KindRepo;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by sunny on 12.12.17
 */
@Controller
@RequestMapping("/kinds")
public class KindController {

    @Autowired
    private KindRepo kindDao;
    private String backUrl;

    private void setBackUrl(String url, boolean update) {
        if (null != url && !"".equals(url)) {
            backUrl = url + (update ? "?kindsUpdate=" + update : "");
        }
    }

    @RequestMapping("/")
    public String list(Model model, @RequestParam(required = false) String backUrl, @RequestParam(required = false) boolean kindsUpdate) {
        List kinds = kindDao.findAll();
        model.addAttribute("kinds", kinds);
        setBackUrl(backUrl, kindsUpdate);
        model.addAttribute("backUrl", this.backUrl);
        return "kinds/list";
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.POST)
    public String save(@Valid Kind kind, BindingResult errors) {
        if (errors.hasErrors()) {
            return "kinds/form";
        }
        kindDao.save(kind);
        return "redirect:/kinds/";
    }

    @RequestMapping("/{id}/delete")
    public String delete(@PathVariable Integer id) {
        kindDao.delete(id);
        return "redirect:/kinds/";
    }

    @RequestMapping("/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Kind kind = (id == 0) ? new Kind() : kindDao.findOne(id);
        model.addAttribute("kind", kind);
        return "kinds/form";
    }

}
