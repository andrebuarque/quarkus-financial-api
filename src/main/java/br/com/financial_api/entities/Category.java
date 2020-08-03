package br.com.financial_api.entities;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;

@MongoEntity(collection = "categories")
public class Category extends ReactivePanacheMongoEntity {
    public String name;
    public CategoryType type;
}
