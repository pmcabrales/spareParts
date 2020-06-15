package com.kairosds.repository;

import com.kairosds.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface PricesRepository extends JpaRepository<Price, Long> {
    Price findFirstByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
            long productId, long brandId, LocalDateTime startDate, LocalDateTime endDate);
}
