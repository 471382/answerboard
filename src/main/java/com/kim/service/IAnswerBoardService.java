package com.kim.service;

import java.util.List;

import com.kim.dto.AnswerBoardDto;
import com.kim.vo.PageMaker;

public interface IAnswerBoardService {
	public void createBoard(AnswerBoardDto dto) throws Exception;
	public AnswerBoardDto read(int bno) throws Exception;
	public void update(AnswerBoardDto dto) throws Exception;
	public void delete(int bno) throws Exception;
	public void createAnswerBoard(AnswerBoardDto dto) throws Exception;
	public List<AnswerBoardDto> listSearch(PageMaker pm) throws Exception;
	public int listSearchCount(PageMaker pm) throws Exception;
}
