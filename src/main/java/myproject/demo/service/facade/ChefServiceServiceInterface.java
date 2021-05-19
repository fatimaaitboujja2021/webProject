package myproject.demo.service.facade;

import myproject.demo.bean.chefservice;

import java.util.List;

public interface ChefServiceServiceInterface {


    int deleteByRef(String reference);

    int deleteByRef(List<chefservice> chefservices);
    chefservice update(chefservice chefService);
}
