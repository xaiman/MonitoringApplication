package com.test.service;

import com.test.model.MeasurementsModel;
import java.util.List;

public interface MeasurementsService {

    List<MeasurementsModel> getUserHistory(String userId);

    void submitUserInformation(MeasurementsModel measurementsModel);
}
