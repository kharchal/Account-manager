package ua.com.hav.boot.bootjsp.serv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.hav.boot.bootjsp.model.Man;
import ua.com.hav.boot.bootjsp.repositories.ManRepo;

import java.util.List;

/**
 * Created by sunny on 14.12.17
 */
@Service
public class ManService {

    @Autowired
    private ManRepo manRepo;

    public List<Man> findAll() {
        return manRepo.findAll();
    }

    public Man findOne(int id) {
        return manRepo.findOne(id);
    }

    public void delete(int id) {
        manRepo.delete(id);
    }

    public void save(Man man) {
        manRepo.save(man);
    }

    public int findPrevId(int id) {
        Integer res = manRepo.findPrevId(id);
        return res == null ? id : res;
    }

    public int findNextId(int id) {
        Integer res = manRepo.findNextId(id);
        return res == null ? id : res;
    }
}
