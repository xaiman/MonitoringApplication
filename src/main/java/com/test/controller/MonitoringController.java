package com.test.controller;

import com.test.exception.RequestWithoutUserException;
import com.test.model.MeasurementsModel;
import com.test.service.MeasurementsService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/measurements")
public class MonitoringController {

    @NonNull
    private final MeasurementsService measurementsService;

    @GetMapping("/history/{userName}")
    public List<MeasurementsModel> getUserHistrory(@PathVariable(name = "userName") String userName) {
        log.info("getUserHistrory method");
        if (StringUtils.hasText(userName)) {
            return measurementsService.getUserHistory(userName);
        }
        throw new RequestWithoutUserException();
    }

    @PostMapping("/submit")
    public void submitInformation(@Valid @RequestBody MeasurementsModel measurementsModel) {
        log.info("submitInformation method");
        measurementsService.submitUserInformation(measurementsModel);
    }
}
