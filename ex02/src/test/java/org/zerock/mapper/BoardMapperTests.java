package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Autowired //의존성주입-필드
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
//		List<BoardVO> list = mapper.getList();
//		log.info(mapper.getList()); 3가지중 원하는 방법 대로
		
		/*
		  for(BoardVO vo : mapper.getList()) 
		  { log.info(vo); }
		 */
		
		mapper.getList().forEach(vo -> log.info(vo));
	}
	
	@Test
	public void testGetListWithPaging() {
		Criteria cri = new Criteria();
		mapper.getListWithPaging(cri).forEach(vo -> log.info(vo));
	}
	@Test
	public void testCount() {
		log.info("글개수는:"+mapper.count());
	}
	
	@Test
	public void testCount1() {
		BoardVO vo = new BoardVO();
		vo.setWriter("user00");
		log.info("유저 글 개수:"+mapper.count1(vo));
	}
	
	
	  @Test
	  public void testQuiz1() {
		  log.info("보자:"+mapper.quiz1());
	  }
	 
	  @Test
	  public void testQuiz2() {
//		  log.info("제목과 작성자:"+mapper.quiz2());
		  for(BoardVO vo:mapper.quiz2()) {
			  log.info(vo.getTitle()+"  "+vo.getWriter());
		  }
	  }
	  
	  @Test
	  public void testInsert() {
		  BoardVO vo = new BoardVO();
		  vo.setTitle("난제목");
		  vo.setContent("난내용");
		  vo.setWriter("테스터1");
		  mapper.insert(vo);
	  }
	  
	  @Test
	  public void testInsertSelectKey() {
		  BoardVO vo = new BoardVO();
		  vo.setTitle("난제목");
		  vo.setContent("난내용");
		  vo.setWriter("테스터1");
		  mapper.insertSelectKey(vo);
		  log.info("등록된 글번호는"+vo.getBno());
	  }

	@Test
	public void testRead() {
		log.info("상세보기:"+mapper.read(3L));
	}
	
	@Test
	public void testDelete() {
		log.info("삭제된 글의 개수는:"+mapper.delete(3L));
	}
	@Test
	  public void testUpdate() {
		  BoardVO vo = new BoardVO();
		  vo.setBno(4L);
		  vo.setTitle("aaaa");
		  vo.setContent("bbbbb");
		  vo.setWriter("ccccc");
		  log.info("수정된 글의 개수는:"+mapper.update(vo)); 
	}
}
