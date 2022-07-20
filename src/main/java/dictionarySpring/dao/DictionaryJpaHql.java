package dictionarySpring.dao;

import dictionarySpring.configuration.DictionaryType;
import dictionarySpring.model.DictionaryLine;
import dictionarySpring.storage.DictionaryStorage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class DictionaryJpaHql implements DictionaryStorage {

    private final SessionFactory sessionFactory;


    public DictionaryJpaHql(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<DictionaryLine> read(DictionaryType selectedDictionary) {
        Session session = sessionFactory.getCurrentSession();

        List<DictionaryLine> dictionaryLines = session.createQuery("select d from DictionaryLine d", DictionaryLine.class)
                .getResultList();
        return dictionaryLines;
    }

    @Override
    public boolean addTo(String key, String value, DictionaryType selectedDictionary) {
        return false;
    }

    @Override
    public boolean remove(String key, DictionaryType selectedDictionary) {
        return false;
    }

    @Override
    public DictionaryLine search(String key, DictionaryType selectedDictionary) {
        return null;
    }
}
