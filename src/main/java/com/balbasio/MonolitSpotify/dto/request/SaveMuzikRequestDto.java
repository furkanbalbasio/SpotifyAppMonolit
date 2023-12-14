package com.balbasio.MonolitSpotify.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaveMuzikRequestDto {
    @NotNull
    @NotBlank
    String muzikUrl;
    @NotNull
    @NotBlank
    String name;
    String kapakResmi;
    @NotNull
    @NotBlank
    String tur;
    int sure;
    String aciklama;
}
