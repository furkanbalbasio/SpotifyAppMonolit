package com.balbasio.MonolitSpotify.service;

import com.balbasio.MonolitSpotify.repository.CalmaListesiRepository;
import com.balbasio.MonolitSpotify.repository.entity.CalmaListesi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalmaListesiService {
    private final CalmaListesiRepository repository;
    public void save(CalmaListesi entity){
        repository.save(entity);
    }
}
