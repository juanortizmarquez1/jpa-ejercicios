package services;

import modelo.Mensaje;
import persistencia.MensajeDao;
import singleton.MensajeSingleton;

import java.util.List;

public class MensajeService {
    MensajeDao mensajeDao = new MensajeDao(MensajeSingleton.getInstance().getEmf().createEntityManager());

    public Mensaje findById(Long id){
        return mensajeDao.find(id);
    }

    public List<Mensaje> findAll(){
        return mensajeDao.findAllMessages();
    }

    //Aquí podría meter más cosas
}
