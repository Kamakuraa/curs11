package ro.fasttrackit.curs11.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.fasttrackit.curs11.model.TrainFilter;
import ro.fasttrackit.curs11.model.entity.TrainEntity;
import ro.fasttrackit.curs11.service.TrainService;

import java.util.List;

@RestController
@RequestMapping("trains")
@RequiredArgsConstructor
public class TrainsController {
  private final TrainService service;
  @GetMapping
  List<TrainEntity> getAll(TrainFilter trainFilter){
    return service.getAll(trainFilter);
  }
}
