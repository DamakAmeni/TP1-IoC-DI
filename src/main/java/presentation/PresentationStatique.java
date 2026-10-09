package presentation;
import dao.DaoIMP;
import dao.IDao;
import metier.IMetier;
import metier.MetierIMP;
public class PresentationStatique {
    public static void main(String[] args) {
        IDao dao = new DaoIMP();
        IMetier metier = new MetierIMP();

        ((MetierIMP) metier).setDao(dao); // injection de dépendance

        System.out.println(metier.calcul());
    }
}


