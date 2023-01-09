package com.delnero.kafkaconsumer.service;

import com.delnero.kafkaconsumer.dao.PizzaRepository;
import com.delnero.kafkaconsumer.entity.PizzaEntity;
import com.delnero.kafkaconsumer.model.Pizza;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PizzaService {

    private final PizzaRepository repository;
    private final ModelMapper modelMapper;

    @Autowired
    public PizzaService(final PizzaRepository repository, final ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public void save(Pizza pizza){
        PizzaEntity entity = modelMapper.map(pizza, PizzaEntity.class);

        log.info("pizza persisted {}", repository.save(entity));
    }


}
