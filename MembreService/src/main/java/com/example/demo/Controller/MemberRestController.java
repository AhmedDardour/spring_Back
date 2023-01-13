package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.IMemberService;
import com.example.demo.entities.Membre;

@RestController
public class MemberRestController {
//@cross origine nesta3mlha qq soit lpartie backend bech n7ot feha lfront
	// @repositoryrestresource me ghir me nasna3 controlleur
	@Autowired
	IMemberService memberService;

	@RequestMapping(value = "/membres", method = RequestMethod.GET)
	public List<Membre> findMembres() {
		return memberService.findAll();
	}

	@GetMapping(value = "/membre/{id}") // direct na3tih l id
	public Membre findOneMemberById(@PathVariable Long id) {
		return memberService.findMember(id);
	}

	@GetMapping(value = "/membre/search/cin")
	public Membre findOneMemberByCin(@RequestParam String cin) {
		return memberService.findByCin(cin);
	}

	@GetMapping(value = "/membre/search/email")
	public Membre findOneMemberByEmail(@RequestParam String email) {
		return memberService.findByEmail(email);
	}

	@GetMapping("/fullmember/{id}")
	public Membre findAFullMember(@PathVariable(name = "id") Long id) {
		Membre mbr = memberService.findMember(id);
		mbr.setPubs(memberService.findPublicationparauteur(id));
		return mbr;
	}

}