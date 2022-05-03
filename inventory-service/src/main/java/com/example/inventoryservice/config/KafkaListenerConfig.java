package com.example.inventoryservice.config;

import com.example.inventoryservice.entities.Order;
import com.example.inventoryservice.services.OrderManageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

@EnableKafka
@Slf4j
@Configuration(proxyBeanMethods = false)
@RequiredArgsConstructor
public class KafkaListenerConfig {

  private final OrderManageService orderManageService;

  @KafkaListener(id = "orders", topics = "orders", groupId = "stock")
  public void onEvent(Order order) {
    log.info("Received: {}", order);
    if ("NEW".equals(order.getStatus())) {
      orderManageService.reserve(order);
    } else {
      orderManageService.confirm(order);
    }
  }
}