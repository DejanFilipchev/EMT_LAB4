package org.example.usercart.repository;

import org.example.usercart.domain.models.Order;
import org.example.usercart.domain.models.OrderId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, OrderId> {
}
