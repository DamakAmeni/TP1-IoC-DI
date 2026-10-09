package presentation;
import dao.IDao;
import metier.IMetier;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
public class PresentationDynamique {
    public static void main(String[] args) throws Exception {
        // 1. Lire le fichier config.txt depuis le classpath
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        PresentationDynamique.class
                                .getClassLoader()
                                .getResourceAsStream("config.txt")));
        String daoClassName = br.readLine();      // dao.DaoIMP
        String metierClassName = br.readLine();   // metier.MetierIMP
        br.close();
        // 2. Charger dynamiquement les classes et créer les instances
        Class<?> cDao = Class.forName(daoClassName);
        IDao dao = (IDao) cDao.getDeclaredConstructor().newInstance();
        Class<?> cMetier = Class.forName(metierClassName);
        IMetier metier = (IMetier) cMetier.getDeclaredConstructor().newInstance();
        // 3. Injection : appel dynamique de setDao(IDao) par réflexion
        Method setDao = cMetier.getMethod("setDao", IDao.class);
        setDao.invoke(metier, dao);
        // 4. Utilisation
        System.out.println(metier.calcul());
    }
}