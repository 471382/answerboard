package com.kim.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kim.dto.AnswerBoardDto;
import com.kim.service.IAnswerBoardService;
import com.kim.vo.PageMaker;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private IAnswerBoardService abs;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "redirect:list";
	}
	
	//글 조회(Main Page)
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(PageMaker pm, Model model) throws Exception{
		List<AnswerBoardDto> dtos = abs.listSearch(pm);
		model.addAttribute("list",dtos);
		pm.setTotalCount(abs.listSearchCount(pm));
	}
	
	//새 글 작성
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public void create() throws Exception{
	}
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createDB(RedirectAttributes ra, AnswerBoardDto dto) throws Exception{
		abs.createBoard(dto);
		ra.addFlashAttribute("msg","success");
		return "redirect:list";
	}
	
	//글 보기
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(int bno, Model model) throws Exception{
		AnswerBoardDto dto = abs.read(bno);
		model.addAttribute("dto", dto);
	}
	
	//글 수정
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public void update(int bno, Model model,PageMaker pm) throws Exception{
		AnswerBoardDto dto = abs.read(bno);
		model.addAttribute("dto", dto);
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateDB(AnswerBoardDto dto, PageMaker pm, Model model, RedirectAttributes ra) throws Exception{
		System.out.println(dto);
		abs.update(dto);
		ra.addAttribute("page",pm.getPage());
		ra.addAttribute("perPageNum", pm.getPerPageNum());
		ra.addAttribute("searchType", pm.getSearchType());
		ra.addAttribute("keyword", pm.getKeyword());
		ra.addFlashAttribute("msg","success");
		return "redirect:list";
	}
	
	//글 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteDB(int bno, PageMaker pm, Model model, RedirectAttributes ra) throws Exception{
		AnswerBoardDto dto = abs.read(bno);
		
		abs.delete(bno,dto.getRef());
		ra.addAttribute("page",pm.getPage());
		ra.addAttribute("perPageNum", pm.getPerPageNum());
		ra.addAttribute("searchType", pm.getSearchType());
		ra.addAttribute("keyword", pm.getKeyword());
		ra.addFlashAttribute("msg","success");
		return "redirect:list";
	}
	
	//답글작성
	@RequestMapping(value = "/createasb", method = RequestMethod.GET)
	public void createAnswerBoard(int bno, Model model) throws Exception{
		model.addAttribute("bno", bno);
	}
	@RequestMapping(value = "/createasb", method = RequestMethod.POST)
	public String createAnswerBoardDB(int bno,RedirectAttributes ra, AnswerBoardDto dto) throws Exception{
		abs.createAnswerBoard(bno, dto);
		ra.addFlashAttribute("msg","success");
		return "redirect:list";
	}
}
