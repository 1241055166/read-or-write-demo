package com.henry;

import com.henry.entity.Member;
import com.henry.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class ReadOrWriteDemoApplicationTests {

	@Autowired
	private MemberService memberService;

	@Test
	public void testWrite() {
		Member member = new Member();
		member.setName("henry");
		memberService.insert(member);
	}

	@Test
	public void testRead() {
		for (int i = 0; i < 4; i++) {
			memberService.selectAll();
		}
	}

	@Test
	public void testSave() {
		Member member = new Member();
		member.setName("henry");
		memberService.save(member);
	}

	@Test
	public void testReadFromMaster() {
		memberService.getToken("1234");
	}

}
