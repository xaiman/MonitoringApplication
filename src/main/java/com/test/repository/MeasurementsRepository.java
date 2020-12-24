package com.test.repository;

import com.test.model.MeasurementsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MeasurementsRepository extends JpaRepository<MeasurementsModel, Long> {

    List<MeasurementsModel> findByUserName(String userName);
}
