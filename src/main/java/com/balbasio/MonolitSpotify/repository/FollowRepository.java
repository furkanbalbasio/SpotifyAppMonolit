package com.balbasio.MonolitSpotify.repository;

import com.balbasio.MonolitSpotify.repository.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow,Long> {
}
