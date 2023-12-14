package com.balbasio.MonolitSpotify.dto.response;

import com.balbasio.MonolitSpotify.repository.view.VwUserProfile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FindAllUserProfileResponseDto {
    int statusCode;
    String message;
    int currentPage;
    boolean hasNext;
    List<VwUserProfile> data;

}
