package glfp.glfp.controller;

import glfp.glfp.dto.BoardDto;
import glfp.glfp.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) { this.boardService = boardService; }

    @GetMapping("/{board_id}") //전체조회
    public ResponseEntity<List> getBoardList(@PathVariable("board_id") String bId){
        List<BoardDto> boardDtoList = boardService.getBoardList(bId);
        return new ResponseEntity<>(boardDtoList, HttpStatus.OK);
    }
    @GetMapping("/{id}") //조회
    public ResponseEntity<BoardDto> getBoard(@PathVariable("id") Long mId){
        BoardDto boardDTO = boardService.getBoard(mId);
        return new ResponseEntity<>(boardDTO, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Long> register(@RequestBody BoardDto boardDto){
        boardService.join(boardDto);
        return new ResponseEntity<>(boardDto.getId(), HttpStatus.OK);
    }

    @PutMapping("") //수정
    public ResponseEntity<Long> revise(@RequestBody BoardDto boardDto){
        boardService.revise(boardDto);
        return new ResponseEntity<>(boardDto.getId(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}") //삭제
    public ResponseEntity<Long> delete(@PathVariable("id") Long mId){
        boardService.delete(mId);
        return new ResponseEntity<>(mId, HttpStatus.OK);
    }
}
