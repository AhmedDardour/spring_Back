package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.example.demo.Service.IMemberService;
import com.example.demo.dao.MemberRepository;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Membre;
//insertion de deux membres
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
 public class MembreServiceApplication implements CommandLineRunner {
  @Autowired
  MemberRepository membreRepository; // naaml injection des dependences bech naaml lcrud(save)
  @Autowired
  IMemberService memberService;
	public static void main(String[] args) {
		SpringApplication.run(MembreServiceApplication.class, args);
		}
	public void run (String... args) throws Exception {
	    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	    Date date1	=dateFormatter.parse("2010-05-01");
	    Date date2	=dateFormatter.parse("2010-04-02");
	    Date date3	=dateFormatter.parse("2011-03-05");
	    Date date4	=dateFormatter.parse("2009-08-06");
	    Date date5	=dateFormatter.parse("2012-05-02");
	    Etudiant etd1 = new Etudiant("0987654", "ben fekih","rim","","rim@enis.rn","1111",date1,null);
		Etudiant etd2 = new Etudiant("09876544", "ben fekih","sana","","sana@enis.rn","1111",date1,null);
		Etudiant etd3 = new Etudiant("11962485", "Mejri","maryem","","maryem.mejri@enis.tn","111",date3,null);
		Etudiant etd4 = new Etudiant("0987663", "Dardour","ahmed","","ahmed.dardour@enis.tn","11",date4,null);
		EnseignantChercheur ens1 = new EnseignantChercheur("098254", "oukil", "sihem", "","sihem.oukil@enis.tn","sihem123",date5, null);
	
		
		membreRepository.save(etd1);
		membreRepository.save(etd2);
		membreRepository.save(etd3);
		membreRepository.save(etd4);
		membreRepository.save(ens1);
		// Update a Member
		Membre m= memberService.findMember(1L);
		m.setCv("cv1.pdf");
		memberService.updateMember(m);
		// Delete a Member
		memberService.deleteMember(2L); // supprimer la ligne2
		memberService.affectEtudiantToEnseignant(1L,5L) ;//affecter a un etudiant un encadrant

}

}
