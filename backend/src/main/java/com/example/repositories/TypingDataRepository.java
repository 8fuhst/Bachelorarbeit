package com.example.repositories;

import com.example.model.TypingData;
import com.google.gson.JsonObject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypingDataRepository extends MongoRepository<JsonObject, String> {

}
