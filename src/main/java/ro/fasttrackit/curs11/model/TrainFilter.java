package ro.fasttrackit.curs11.model;

import lombok.Builder;

import java.util.List;


@Builder
public record TrainFilter(
  String model,
  Integer minCarts,
  Integer maxCarts,
  List<String> city
) {
}
