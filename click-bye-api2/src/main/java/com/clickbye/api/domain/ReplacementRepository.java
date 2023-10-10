package com.clickbye.api.domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplacementRepository extends MongoRepository<Replacement, Replacement.Id> {

    List<Replacement> findAllByTitleIn(List<String> titles);
}
