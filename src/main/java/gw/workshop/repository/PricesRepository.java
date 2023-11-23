package gw.workshop.repository;

import gw.workshop.model.Price;
import gw.workshop.model.SparePart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface SparePartPricesRepository extends JpaRepository<Price, Long> {
    Price findFirstByProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
            long productId, LocalDateTime startDate, LocalDateTime endDate);

    List<SparePart> findAllByBrandCodeAndModelCodeAndModelYearAndSparePartType(
            String brandCode, String modelCode, String modelYear, String SparePartType);
}
