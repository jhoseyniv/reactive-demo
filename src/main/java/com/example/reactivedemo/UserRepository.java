package com.example.reactivedemo;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User,Long> {
    @Query("select * from users where age >= $1")
    Flux<User> findByAge(int age);
    Mono<User> findById(Integer userId);

}
