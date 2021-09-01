package services;

import modelo.Autor;
import persistencia.AutorDao;
import singleton.MensajeSingleton;

import java.util.List;

public class AutorService {
    AutorDao autorDao = new AutorDao(MensajeSingleton.getInstance().getEmf().createEntityManager());

    public Autor findById(Long id){
        return autorDao.find(id);
    }

    public List<Autor> findAll(){
        return autorDao.findAllAutores();
    }
}
