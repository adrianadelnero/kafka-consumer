package com.delnero.kafkaconsumer.entity;

import com.delnero.kafkaconsumer.model.Crust;
import com.delnero.kafkaconsumer.model.Toppings;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PizzaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    Crust crust;
    String[] toppings;
    String item;
    Double amount;
}
