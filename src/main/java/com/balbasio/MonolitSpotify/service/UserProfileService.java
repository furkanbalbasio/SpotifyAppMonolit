package com.balbasio.MonolitSpotify.service;

import com.balbasio.MonolitSpotify.dto.request.SaveUserProfileRequestDto;
import com.balbasio.MonolitSpotify.dto.response.FindAllUserProfileResponseDto;
import com.balbasio.MonolitSpotify.exception.ErrorType;
import com.balbasio.MonolitSpotify.exception.MonolitSpotifyException;
import com.balbasio.MonolitSpotify.repository.UserProfileRepository;
import com.balbasio.MonolitSpotify.repository.entity.UserProfile;
import com.balbasio.MonolitSpotify.utility.enums.State;
import com.balbasio.MonolitSpotify.utility.enums.UserType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserProfileService {




    private final UserProfileRepository repository;

    public void save(UserProfile userProfile){

        repository.save(userProfile);
    }

    public void save(SaveUserProfileRequestDto dto){
        if(!dto.getPassword().equals(dto.getRePassword()))
            throw new MonolitSpotifyException(ErrorType.SIFRE_UYUSMUYOR);
        if(repository.existsByUserName(dto.getUserName()))
            throw new MonolitSpotifyException(ErrorType.KAYITLI_KULLANICI_ADI);
        UserProfile userProfile = UserProfile.builder()
                .userName(dto.getUserName())
                .userType(dto.getUserType())
                .createAt(System.currentTimeMillis())
                .updateAt(System.currentTimeMillis())
                .resimUrl(dto.getResimUrl())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .state(State.ACTIVE)
                .build();
        repository.save(userProfile);
    }

    public List<UserProfile> findAll(){
        return repository.findAll();
    }


    public FindAllUserProfileResponseDto findAllUserProfile() {
        return FindAllUserProfileResponseDto.builder()
                .statusCode(100)
                .message("Listeler başarı şekilde çekildi")
                .data(repository.findAllFromUserProfileView())
                .build();
    }

    public boolean existsById(Long artistId) {
        return repository.existsById(artistId);
    }

    public boolean isArtist(Long artistId){
        return repository.existsByIdAndUserType(artistId, UserType.ARTIST);
    }
}
