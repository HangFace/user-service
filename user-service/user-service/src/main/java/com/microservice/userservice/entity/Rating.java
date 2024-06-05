package com.microservice.userservice.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rating {

  @Id
  @Column(name = "id", nullable = false)
  @Builder.Default
  private String id = UUID.randomUUID().toString();

  @Column(name = "userId", nullable = false)
  private String userId;

  @Column(name = "hotelId", nullable = false)
  private String hotelId;

  @Column(name = "ratings", nullable = false)
  private Integer ratings;

  @Column(name = "feedback", nullable = false)
  private String feedback;

  private Hotel hotel;
}
