package com.example.springbootStart.controller;

import com.example.springbootStart.domain.Member;
import com.example.springbootStart.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    /*

        1.  @Autowired
            private final MemberService memberService;
            필드 주입
     */

    /*

        2.  @Autowired
            public void setMemberService(MemberService memberService) {
            this.memberService = memberService;
            }
            setter 주입
     */

    @Autowired  // 3.생성자 주입 ## 대체로 생성자 주입방식을 사용한다. 의존 관계가 실행중에 동적으로 변하는 경우는 거의 없기 때문이다.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }


}
