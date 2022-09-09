package com.m2i.crm.controller;


import com.m2i.crm.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.crm.model.Order;
import com.m2i.crm.service.IOrderService;
import io.swagger.annotations.ApiOperation;

import javassist.NotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/orders")
public class OrderController {
    
    private final IOrderService  orderService;
    
    @Autowired
    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    // listAll [GET] -> orders/
    //@RequestMapping(method =RequestMethod.GET)
     @GetMapping
       @ApiOperation(value = "zineb list of all orders", nickname = "Get all orders")
    public ResponseEntity<Object> getOrders() {
        return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
    }

    // create [POST] -> orders/
    @RequestMapping(method=RequestMethod.POST)
     @ApiOperation(value = " zineb Creates a new order", nickname = "Create an order")
    public ResponseEntity<Object> createOrder(@RequestBody Order order) {
        this.orderService.create(order);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    // update [PUT] -> orders/{id}
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    @ApiOperation(value = "zineb Updates the order with given id", nickname = "Update order")
    public ResponseEntity<Object> updateOrder(@PathVariable("id") Long id, @RequestBody Order order) {
        try {
            this.orderService.update(order, id);
        } catch (NotFoundException e) {
            return new ResponseEntity<>("Order with id " + id + " not found.", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(orderService.findById(id), HttpStatus.OK);
    }

    // getById [GET] -> orders/{id}
    @RequestMapping(value ="/{id}",  method=RequestMethod.GET)
     @ApiOperation(value = " zinebReturns the order with given id", nickname = "Get an order")
    public ResponseEntity<Object> getOrderById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(orderService.findById(id), HttpStatus.OK);
    }
    
    // delete [DELETE] -> orders/{id}
     @RequestMapping(value ="/{id}", method =RequestMethod.DELETE)
       @ApiOperation(value = "zineb Deletes the order with given id", nickname = "Delete order")
     public ResponseEntity<Object>deleteOrder(@PathVariable("id") Long id){
         orderService.delete(id);
         return new ResponseEntity<>( HttpStatus.OK);
     }
}
