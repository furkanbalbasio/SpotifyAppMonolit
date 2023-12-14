package com.balbasio.MonolitSpotify.service;

import com.balbasio.MonolitSpotify.dto.request.AddMusicForArtistRequestDto;
import com.balbasio.MonolitSpotify.dto.request.SaveMuzikRequestDto;
import com.balbasio.MonolitSpotify.dto.response.FindAllMuzikResponseDto;
import com.balbasio.MonolitSpotify.exception.ErrorType;
import com.balbasio.MonolitSpotify.exception.MonolitSpotifyException;
import com.balbasio.MonolitSpotify.mapper.MuzikMapper;
import com.balbasio.MonolitSpotify.repository.MuzikRepository;
import com.balbasio.MonolitSpotify.repository.MuzikSanatciRepository;
import com.balbasio.MonolitSpotify.repository.entity.Muzik;
import com.balbasio.MonolitSpotify.repository.entity.MuzikSanatci;
import com.balbasio.MonolitSpotify.utility.enums.State;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MuzikService {
    private final MuzikRepository repository;
    private final UserProfileService userProfileService;
    private final MuzikSanatciRepository muzikSanatciRepository;

    public void save(SaveMuzikRequestDto dto){
//        Muzik muzik = Muzik.builder()
//                .muzikUrl(dto.getMuzikUrl())
//                .aciklama(dto.getAciklama())
//                .tur(dto.getTur())
//                .name(dto.getName())
//                .sure(dto.getSure())
//                .kapakResmi(dto.getKapakResmi())
//                .build();
//        Muzik muzik = new Muzik();
//        muzik.setMuzikUrl(dto.getMuzikUrl());
//        muzik.setName(dto.getName());

       Muzik muzik = MuzikMapper.INSTANCE.muzikFromDto(dto);
       muzik.setState(State.PENDING);
       repository.save(muzik);
       // repository.save(MuzikMapper.INSTANCE.muzikFromDto(dto));
    }

    public FindAllMuzikResponseDto findAll() {
        return FindAllMuzikResponseDto.builder()
                .statusCode(100)
                .message("Müzik listesi getirildi.")
                .data(repository.findAll())
                .build();
    }


    public void addMusicForArtist(AddMusicForArtistRequestDto dto) {
       if(!userProfileService.existsById(dto.getArtistId()) || !userProfileService.isArtist(dto.getArtistId()))
           throw new MonolitSpotifyException(ErrorType.ARTIST_ERROR);
       else if (!repository.existsById(dto.getMusicId()))
           throw new MonolitSpotifyException(ErrorType.MUSIC_NOT_FOUND);
       muzikSanatciRepository.save(MuzikSanatci.builder()
                       .muzikId(dto.getMusicId())
                       .sanatciId(dto.getArtistId())
               .build());
    }


    public List<Muzik> findAllMuzikFromArtistId(Long id) {
        List<MuzikSanatci> muzikSanatciList = muzikSanatciRepository.findAllBySanatciId(id);
        List<Long> muzikIds = muzikSanatciList.stream().map(MuzikSanatci::getMuzikId).toList();
        return repository.findAllById(muzikIds);
    }
}
