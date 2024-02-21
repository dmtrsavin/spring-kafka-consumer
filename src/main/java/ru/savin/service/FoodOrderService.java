package ru.savin.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.savin.dto.FoodOrderDto;
import ru.savin.entity.FoodOrder;
import ru.savin.mapper.FoodOrderMapper;
import ru.savin.repository.FoodOrderRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class FoodOrderService {
    private final FoodOrderMapper foodOrderMapper;
    private final FoodOrderRepository foodOrderRepository;

    public void persistFoodOrder(FoodOrderDto foodOrderDto) {
        FoodOrder foodOrder = foodOrderMapper.mapToEntity(foodOrderDto);
        FoodOrder persistFoodOrder = foodOrderRepository.save(foodOrder);

        log.info("food order persisted {}", persistFoodOrder);
    }
}
