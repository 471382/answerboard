package com.kim.dao;

import java.util.List;

import com.kim.dto.AnswerBoardDto;
import com.kim.vo.PageMaker;

public interface AnswerBoardDao {
	public void createBoard(AnswerBoardDto dto) throws Exception;			//새 글 작성
	public AnswerBoardDto read(int bno) throws Exception;					//글 상세보기
	public void update(AnswerBoardDto dto) throws Exception;				//글 수정
	public void delete(int bno) throws Exception;							//글 삭제
	public List<AnswerBoardDto> listSearch(PageMaker pm) throws Exception;	//전체글조회
	public int listSearchCount(PageMaker pm) throws Exception;				//글 수
	public void updateViewCnt(int bno);										//조회수 증가
	public void createAnswerBoard(AnswerBoardDto dto) throws Exception;		//답글 작성
	public void beforeCreate(int bno) throws Exception;						//답글작성 사전작업 (트랜잭션)
}
