package com.microservice.ratingservice.entity;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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
@Document(collection = "rating")
public class Rating {

  @Id
  @Builder.Default
  private String id = UUID.randomUUID().toString();

  @Field(name = "user_id")
  private String userId;

  @Field(name = "hotel_id")
  private String hotelId;

  @Field(name = "ratings")
  private Integer ratings;

  @Field(name = "feedback")
  private String feedback;
}
