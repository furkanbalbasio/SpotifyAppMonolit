package com.balbasio.MonolitSpotify.service;

import com.balbasio.MonolitSpotify.repository.CalmaListesiMuzikRepository;
import com.balbasio.MonolitSpotify.repository.entity.CalmaListesiMuzik;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalmaListesiMuzikService {
    private final CalmaListesiMuzikRepository repository;

    public void save(CalmaListesiMuzik entity){
        repository.save(entity);
    }

}
