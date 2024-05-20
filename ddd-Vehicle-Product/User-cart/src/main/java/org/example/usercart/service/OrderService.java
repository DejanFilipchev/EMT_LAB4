package org.example.usercart.service;

import org.example.usercart.domain.models.Order;
import org.example.usercart.domain.models.OrderId;
import org.example.usercart.domain.models.Shopping_cartId;
import org.example.usercart.service.forms.OrderForm;
import org.example.usercart.service.forms.OrderItemForm;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> findAll();

    Optional<Order> findById(OrderId id);

    void addItem(OrderId orderId, OrderItemForm orderItemForm);

    void deleteItem(OrderId id, Shopping_cartId shoppingCartId);

}
