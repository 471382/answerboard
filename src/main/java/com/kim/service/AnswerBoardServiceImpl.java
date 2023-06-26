package com.kim.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kim.dao.AnswerBoardDao;
import com.kim.dto.AnswerBoardDto;
import com.kim.vo.PageMaker;;

@Service
public class AnswerBoardServiceImpl implements IAnswerBoardService{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void createBoard(AnswerBoardDto dto) throws Exception {
		AnswerBoardDao dao=sqlSession.getMapper(AnswerBoardDao.class);
		dao.createBoard(dto);
	}

	@Transactional
	@Override
	public AnswerBoardDto read(int bno) throws Exception {
		AnswerBoardDao dao=sqlSession.getMapper(AnswerBoardDao.class);
		dao.updateViewCnt(bno);
		return dao.read(bno);
	}

	@Override
	public void update(AnswerBoardDto dto) throws Exception {
		AnswerBoardDao dao=sqlSession.getMapper(AnswerBoardDao.class);
		dao.update(dto);
	}
	
	@Transactional
	@Override
	public void delete(int bno,int ref) throws Exception {
		AnswerBoardDao dao=sqlSession.getMapper(AnswerBoardDao.class);
		dao.beforeDel(ref);
		dao.delete(bno);
	}

	@Transactional
	@Override
	public void createAnswerBoard(int bno, AnswerBoardDto dto) throws Exception {
		AnswerBoardDao dao=sqlSession.getMapper(AnswerBoardDao.class);
		dao.beforeCreate(bno);
		dao.createAnswerBoard(dto);
	}

	@Override
	public List<AnswerBoardDto> listSearch(PageMaker pm) throws Exception {
		AnswerBoardDao dao=sqlSession.getMapper(AnswerBoardDao.class);
		return dao.listSearch(pm);
	}

	@Override
	public int listSearchCount(PageMaker pm) throws Exception {
		AnswerBoardDao dao=sqlSession.getMapper(AnswerBoardDao.class);
		return dao.listSearchCount(pm);
	}
	
	
	
}
