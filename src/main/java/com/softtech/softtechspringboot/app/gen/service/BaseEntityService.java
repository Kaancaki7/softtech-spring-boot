package com.softtech.softtechspringboot.app.gen.service;

import com.softtech.softtechspringboot.app.acc.entity.AccAccount;
import com.softtech.softtechspringboot.app.cus.enums.CustomerErrorMessage;
import com.softtech.softtechspringboot.app.gen.enums.GenErrorMessage;
import com.softtech.softtechspringboot.app.gen.exceptions.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BaseEntityService<E,D extends JpaRepository> {

    private final D dao;

    public List<E> findAll(){
        return dao.findAll();
    }

    public Optional<E> findById(Long id){
        return dao.findById(id);
    }

    public E save(E entity){
        return (E) dao.save(entity);
    }

    public void delete(E entity){
        dao.delete(entity);
    }

    public E getByIdWithControl(Long id){

        Optional<E> entityOptional = findById(id);
        E entity;
        if(entityOptional.isPresent()){
            entity = entityOptional.get();
        } else {
            throw new ItemNotFoundException(GenErrorMessage.ITEM_NOT_FOUND);
        }
        return entity;
    }

    public boolean existById(Long id) {
        return dao.existsById(id);
    }

    public D getDao() {
        return dao;
    }
}
