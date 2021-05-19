package myproject.demo.service.facade;

import myproject.demo.bean.Fonctionnaire;
import myproject.demo.bean.ListeGarde;

import java.util.List;

public interface ListeGardeServiceInterface {



    int deleteByRef(String reference);

    int deleteByRef(List<ListeGarde> listeGardes);
    ListeGarde update(ListeGarde listeGarde);



}
