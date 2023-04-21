package sopt.org.secondSeminarAdvancedAssignment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import sopt.org.secondSeminarAdvancedAssignment.domain.User;

import java.util.Optional;

public abstract class ResponseEntityGenerator {

    protected ResponseEntity<?> generateSaveResponseEntity(boolean saveResult) {
        return (saveResult) ?
                new ResponseEntity<>("정보가 성공적으로 등록 되었습니다.", HttpStatus.OK):
                new ResponseEntity<>("등록에 실패하였습니다.", HttpStatus.NO_CONTENT);
    }

    protected abstract ResponseEntity<?> generateFindResponseEntity(Optional<?> domain, Long id);

    protected ResponseEntity<?> generateUpdateResponseEntity(boolean updateResult, Long id) {
        return (updateResult) ?
                new ResponseEntity<>(id + "번 데이터에 대한 정보가 성공적으로 업데이트 되었습니다.", HttpStatus.OK):
                new ResponseEntity<>(id + "번 데이터에 대한 정보가 존재하지 않습니다.", HttpStatus.NO_CONTENT);
    }

    protected ResponseEntity<?> generateDeleteResponseEntity(boolean deleteResult, Long id) {
        return (deleteResult) ?
                new ResponseEntity<>(id + "번 데이터에 대한 정보가 성공적으로 삭제 되었습니다.", HttpStatus.OK):
                new ResponseEntity<>(id + "번 데이터에 대한 정보가 존재하지 않습니다.", HttpStatus.NO_CONTENT);
    }
}
