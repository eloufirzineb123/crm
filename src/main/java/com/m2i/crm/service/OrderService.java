package com.m2i.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.crm.model.Order;
import com.m2i.crm.repository.OrderRepository;
import java.util.Optional;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void create(Order order) {
        this.orderRepository.save(order);
    }

    @Override
    public void delete(Long id) {
        Order oldOrder = orderRepository.findById(id).orElse(null);
        
        orderRepository.deleteById(id);
        
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }


    @Override
    public void update(Order dataToUpdate, Long id) throws NotFoundException {
        Order order = this.orderRepository.findById(id).orElse(null);
        
        if (order == null)
            throw new NotFoundException(null);
        
        order.copy(dataToUpdate);
        this.orderRepository.save(order);
    }
}
