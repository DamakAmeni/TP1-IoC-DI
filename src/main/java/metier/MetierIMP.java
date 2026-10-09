package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetierIMP implements IMetier {

    @Autowired
    private IDao dao;

    @Override
    public double calcul() {
        return dao.getValue() * 7;
    }

    // conservé pour que les activités 1-1 à 1-3 fonctionnent encore
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}