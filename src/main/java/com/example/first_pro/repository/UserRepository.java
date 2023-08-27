package com.example.first_pro.repository;

import com.example.first_pro.entity.UserEntity;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

//  @Cacheable( cacheNames = "NEW_MAX_DISTANCE_TO_SCAN",
//          unless = "#result == null", cacheManager = CacheConfig.CACHE_LOCAL)
  List<UserEntity> findByIdIn(List<Integer> ids);

//  cacheManager = CacheConfig.CACHE_LOCAL
}
