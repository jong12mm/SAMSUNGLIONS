package com.example.sl.entity;


// DB의 테이블 역할을 하는 클래스


import com.example.sl.DTO.BoardDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "board_table")
public class BoardEntity extends BaseEntity{

    @Id //pk 컬럼 지정 , 필수
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private Long id;

    @Column(length = 20  , nullable = false) // 크기 20 , not null
    private String boardWriter;

    @Column //크기 255 , null 가능
    private String boardPass;

    @Column
    private String boardTitle;

    @Column(length =  500)
    private String boardContents;

    @Column
    private int boardHits;


    public static BoardEntity toSaveEntity(BoardDTO boardDTO) {

        //Dto 에 있는 객체를 entity 객체로 바꾸는 작업
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBoardWriter(boardDTO.getBoardWriter());
        boardEntity.setBoardPass(boardDTO.getBoardPass());
        boardEntity.setBoardTitle(boardDTO.getBoardTitle());
        boardEntity.setBoardContents(boardDTO.getBoardContents());
        boardEntity.setBoardHits(0);

        return boardEntity;



    }

    public static BoardEntity toUpdateEntity(BoardDTO boardDTO) {

        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setId(boardDTO.getId());
        boardEntity.setBoardWriter(boardDTO.getBoardWriter());
        boardEntity.setBoardPass(boardDTO.getBoardPass());
        boardEntity.setBoardTitle(boardDTO.getBoardTitle());
        boardEntity.setBoardContents(boardDTO.getBoardContents());
        boardEntity.setBoardHits(boardDTO.getBoardHits());

        return boardEntity;


    }
}
