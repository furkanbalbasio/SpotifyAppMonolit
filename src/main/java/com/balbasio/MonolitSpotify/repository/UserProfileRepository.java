package com.balbasio.MonolitSpotify.repository;

import com.balbasio.MonolitSpotify.repository.entity.UserProfile;
import com.balbasio.MonolitSpotify.repository.view.VwUserProfile;
import com.balbasio.MonolitSpotify.utility.enums.State;
import com.balbasio.MonolitSpotify.utility.enums.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile,Long> {


    @Query("select new com.muhammet.MonolitSpotify.repository.view.VwUserProfile(u.id,u.userName,u.resimUrl) from UserProfile u")
    List<VwUserProfile> findAllFromUserProfileView();





    boolean existsByUserName(String userName);


    boolean existsByIdAndUserType(Long id, UserType userType);



}
