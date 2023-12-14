package com.balbasio.MonolitSpotify.service;

import com.balbasio.MonolitSpotify.repository.MuzikTuruRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MuzikTuruService{

    private final MuzikTuruRepository repository;

}
