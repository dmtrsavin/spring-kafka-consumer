package ru.savin.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.savin.dto.FoodOrderDto;
import ru.savin.mapper.FoodOrderMapper;
import ru.savin.service.FoodOrderService;

@Slf4j
@Component
@RequiredArgsConstructor
public class Consumer {
    private static final String orderTopic = "${topic.name}";

    private final FoodOrderMapper foodOrderMapper;
    private final FoodOrderService foodOrderService;

    @KafkaListener(topics = orderTopic)
    public void consumeMessage(String message) {
        log.info("message consumed {}", message);

        FoodOrderDto dto = foodOrderMapper.mapToDto(message);
        foodOrderService.persistFoodOrder(dto);
    }
}
