package com.facens.marcos.wesley.VendasDeCursos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facens.marcos.wesley.VendasDeCursos.model.AlunoModel;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	private List<AlunoModel> alunos = new ArrayList<>();

	@GetMapping("/pagar/{id}")
	public AlunoModel pagar(@PathVariable int id) {
		AlunoModel aluno = alunos.get(id);
				
		return aluno.pagar();
	}
	
	@GetMapping("/logar/{id}")
	public AlunoModel logar(@PathVariable int id) {
		AlunoModel aluno = alunos.get(id);
		
		return aluno.logar();
	}
}
