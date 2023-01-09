package com.delnero.kafkaconsumer.dao;

import com.delnero.kafkaconsumer.entity.PizzaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends JpaRepository<PizzaEntity, Long> {
}
