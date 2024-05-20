package org.example.usercart.service.impl;

import lombok.AllArgsConstructor;
import org.example.usercart.domain.models.Order;
import org.example.usercart.domain.models.OrderId;
import org.example.usercart.domain.models.Shopping_cartId;
import org.example.usercart.repository.OrderRepository;
import org.example.usercart.service.OrderService;
import org.example.usercart.service.forms.OrderForm;
import org.example.usercart.service.forms.OrderItemForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;


    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(OrderId id) {
        return orderRepository.findById(id);
    }

    @Override
    public void addItem(OrderId orderId, OrderItemForm orderItemForm) {
        Order order = orderRepository.findById(orderId).orElseThrow(RuntimeException::new);
        order.addItem(orderItemForm.getVehicle(),orderItemForm.getQuantity());
        orderRepository.saveAndFlush(order);
    }

    @Override
    public void deleteItem(OrderId id, Shopping_cartId shoppingCartId) {
        Order order = orderRepository.findById(id).orElseThrow(RuntimeException::new);
        order.removeItem(shoppingCartId);
        orderRepository.saveAndFlush(order);
    }
}
