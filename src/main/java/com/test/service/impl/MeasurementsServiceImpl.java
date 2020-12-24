package com.test.service.impl;

import com.test.model.MeasurementsModel;
import com.test.repository.MeasurementsRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class MeasurementsServiceImpl implements com.test.service.MeasurementsService {

    @NonNull
    private final MeasurementsRepository measurementsRepository;

    @Override
    public List<MeasurementsModel> getUserHistory(String userName) {
        log.info("getUserHistory service method");
        return measurementsRepository.findByUserName(userName);
    }

    @Override
    public void submitUserInformation(MeasurementsModel measurementsModel) {
        log.info("submitUserInformation service method");
        measurementsRepository.save(measurementsModel);
    }
}
