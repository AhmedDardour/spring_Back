package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.IMemberService;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Membre;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
public class MemberRestController {
//@cross origine nesta3mlha qq soit lpartie backend bech n7ot feha lfront
	// @repositoryrestresource me ghir me nasna3 controlleur
	@Autowired
	IMemberService memberService;

	@RequestMapping(value = "/membres", method = RequestMethod.GET)
	public List<Membre> findMembres() {
		return memberService.findAll();
	}
	
	@GetMapping(value = "/membres/{id}") // direct na3tih l id
	public Membre findOneMemberById(@PathVariable Long id) {
		return memberService.findMember(id);
	}
	@DeleteMapping(value = "/membres/{id}") // direct na3tih l id
	public void deleteMemberById(@PathVariable Long id) {
		memberService.deleteMember(id);
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
	
	@PutMapping(value = "/membre/{idMembre}/publication/{idPub}")
	public void affecterMembrePub(@PathVariable(value = "idPub") Long idPub, @PathVariable(value ="idMembre") Long idMembre) {
		
		memberService.affecterauteurTopublication( idMembre, idPub);
	}
	
	@PostMapping(value = "/membres/enseignant")
	public Membre addMembre(@RequestBody EnseignantChercheur m) {
		return memberService.addMember(m);
	}

	@PostMapping(value = "/membres/etudiant")
	public Membre addMembre(@RequestBody Etudiant e) {
		return memberService.addMember(e);
	}

	@PutMapping(value = "/membres/etudiant/{id}")
	public Membre updatemembre(@PathVariable Long id, @RequestBody Etudiant p) {

		p.setId(id);
		return memberService.updateMember(p);

	}

	@PutMapping(value = "/membres/enseignant/{id}")
	public Membre updateMembre(@PathVariable Long id, @RequestBody EnseignantChercheur p) {

		p.setId(id);
		return memberService.updateMember(p);

	}



}