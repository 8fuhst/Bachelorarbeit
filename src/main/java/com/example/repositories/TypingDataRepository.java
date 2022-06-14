package com.example.repositories;

import com.google.gson.JsonObject;
import org.json.JSONObject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypingDataRepository extends MongoRepository<JSONObject, String> {

}
