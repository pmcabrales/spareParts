package com.kairosds.repository;

import com.kairosds.model.Prices;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface PricesRepository extends JpaRepository<Prices, Long> {
    Prices findFirstByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
            long productId, long brandId, LocalDateTime startDate, LocalDateTime endDate);
}
