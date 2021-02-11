package glfp.glfp.dto;

import glfp.glfp.domain.entity.Board;
import glfp.glfp.domain.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class BoardDto {
    private Long id;
    private Member fkId;
    private Member fkSex;
    private String postTitle;
    private LocalDateTime postCreatedTime;
    private LocalDateTime postModifiedTime;
    private int matchStatus;
    private String boardId;

    public Board toEntity(BoardDto boardDto){
        Board build = Board.builder()
                .id(boardDto.getId())
                .fkId(boardDto.getFkId())
                .fkSex(boardDto.getFkSex())
                .postTitle(boardDto.getPostTitle())
                .postCreatedTime(boardDto.getPostCreatedTime())
                .postModifiedTime(boardDto.getPostModifiedTime())
                .matchStatus(boardDto.getMatchStatus())
                .boardId(boardDto.getBoardId())
                .build();
        return build;
    }
    @Builder
    public BoardDto(Long id, Member fkId, Member fkSex, String postTitle, LocalDateTime postCreatedTime, LocalDateTime postModifiedTime, int matchStatus, String boardId) {
        this.id = id;
        this.fkId = fkId;
        this.fkSex = fkSex;
        this.postTitle = postTitle;
        this.postCreatedTime = postCreatedTime;
        this.postModifiedTime = postModifiedTime;
        this.matchStatus = matchStatus;
        this.boardId = boardId;
    }


}
