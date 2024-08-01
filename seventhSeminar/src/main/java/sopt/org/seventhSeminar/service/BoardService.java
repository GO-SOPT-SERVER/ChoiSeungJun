package sopt.org.seventhSeminar.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.seventhSeminar.controller.dto.request.BoardImageListRequestDto;
import sopt.org.seventhSeminar.controller.exception.Error;
import sopt.org.seventhSeminar.controller.exception.model.NotFoundException;
import sopt.org.seventhSeminar.domain.Board;
import sopt.org.seventhSeminar.domain.Image;
import sopt.org.seventhSeminar.domain.User;
import sopt.org.seventhSeminar.infrastructure.BoardRepository;
import sopt.org.seventhSeminar.infrastructure.ImageRepository;
import sopt.org.seventhSeminar.infrastructure.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    private final ImageRepository imageRepository;


    @Transactional
    public void create(Long userId, List<String> boardImageUrlList, BoardImageListRequestDto request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_USER_EXCEPTION, Error.NOT_FOUND_USER_EXCEPTION.getMessage()));

        // 게시글 생성
        Board newBoard = Board.newInstance(
                user,
                request.getTitle(),
                request.getContent(),
                request.getIsPublic()
        );

        boardRepository.save(newBoard);

        // 이미지 생성
        for (String boardImageUrl : boardImageUrlList) {
            imageRepository.save(Image.newInstance(newBoard, boardImageUrl));
        }
    }
}