package com.example.sl.controller;


import com.example.sl.DTO.BoardDTO;
import com.example.sl.entity.BoardEntity;
import com.example.sl.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/save")
    public String saveForm(){ return "save" ;}



    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO) {

        boardService.save(boardDTO);
        return "index";

    }

    @GetMapping("/")
    public String findAll(Model model) {

        //DB에서 전체 게시글 데이터를 가져와서 list.html에 보여준다.
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList",boardDTOList);

        return "liST";

    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model,@PageableDefault(page=1) Pageable pageable){

        /*
             해당 게시글의 조회수를 하나 올리고
             게시글 데이터를 가져와서 detail.html 에 출력을 한다.
         */

        boardService.updateHits(id);
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board" , boardDTO);
        model.addAttribute("page",pageable.getPageNumber());
        return "detail";


    }
    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Long id , Model model) {

        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("boardUpdate",boardDTO);
        return "update";

    }
    @PostMapping("/update")
    public String update(@ModelAttribute BoardDTO boardDTO , Model model) {

        BoardDTO board = boardService.update(boardDTO);
        model.addAttribute("board",board);

        return "detail";


    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {

        boardService.delete(id);
        return "redirect:/board/";


    }
    // board/paging?page=1
    @GetMapping("/paging")
    public String paging(@PageableDefault(page = 1) Pageable pageable , Model model
                            ,String searchKeyword){


        Page<BoardDTO> boardList = null;

        if (searchKeyword == null || searchKeyword.isEmpty()) {

            boardList = boardService.paging(pageable);
            System.out.println("good");


        } else {


//            여기가 문제임 검색창에 입력한 값이
            Page<BoardEntity> boardEntityList = boardService.boardSearchList(searchKeyword, pageable);
            boardList = boardEntityList.map(BoardDTO::new);
            System.out.println("bad");


        }


    //    pageable.getPageNumber();


        int blockLimit =10;
        int startPage = (((int)(Math.ceil((double)pageable.getPageNumber() / blockLimit))) - 1) * blockLimit + 1; // 1 4 7 10 ~~
        int endPage = ((startPage + blockLimit - 1) < boardList.getTotalPages()) ? startPage + blockLimit - 1 : boardList.getTotalPages();

        // 현재 사용자가 3페이지
        // 1 2 3 4 5
        // 몇 페이지 숫자를 나타내는 부분임 (숫자 몇개를 보여줄지 결정)
        // 총 페이지 갯수 8개


        model.addAttribute("boardList",boardList);
        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);

        return "paging";

    }


}
