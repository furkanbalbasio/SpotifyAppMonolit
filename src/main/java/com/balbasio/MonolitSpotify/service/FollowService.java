package com.balbasio.MonolitSpotify.service;

import com.balbasio.MonolitSpotify.repository.FollowRepository;
import com.balbasio.MonolitSpotify.repository.entity.Follow;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowService {
    private final FollowRepository repository;

    public void save(Follow entity){
        repository.save(entity);
    }
}
