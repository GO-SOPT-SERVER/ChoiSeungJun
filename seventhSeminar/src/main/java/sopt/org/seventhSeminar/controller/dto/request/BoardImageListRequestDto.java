package sopt.org.seventhSeminar.controller.dto.request;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BoardImageListRequestDto {
    private List<MultipartFile> boardImages;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotNull
    private Boolean isPublic;

    public void setBoardImages(List<MultipartFile> boardImages) {
        this.boardImages = boardImages;
    }
}
