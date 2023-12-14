package com.balbasio.MonolitSpotify.repository;

import com.balbasio.MonolitSpotify.repository.entity.MuzikSanatci;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MuzikSanatciRepository extends JpaRepository<MuzikSanatci,Long> {
    List<MuzikSanatci> findAllBySanatciId(Long id);
}
