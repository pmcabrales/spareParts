package gw.workshop.repository;

import gw.workshop.model.SparePart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SparePartsRepository extends JpaRepository<SparePart, Long> {

    List<SparePart> findAllByBrandCodeAndModelCodeAndModelYearAndSparePartType(
            String brandCode, String modelCode, String modelYear, String SparePartType);
}
