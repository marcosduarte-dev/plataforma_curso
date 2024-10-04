package com.facens.marcos.wesley.VendasDeCursos.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.facens.marcos.wesley.VendasDeCursos.model.AlunoModel;
import com.facens.marcos.wesley.VendasDeCursos.model.CursosModel;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AlunoTest {
	
	private List<CursosModel> cursos = new ArrayList<>();
	private List<CursosModel> cursosBasico = new ArrayList<>();

	@BeforeEach
    public void criarCursos() {

        for (int i = 1; i <= 15; i++) {
            boolean isBasico = i <= 12; // Define os 12 primeiros como cursos básicos
            CursosModel curso = new CursosModel(i, "Curso " + i, 20 + i, isBasico, 100.0f + (i * 10));
            this.cursos.add(curso);
            if(curso.isBasico()) {
            	cursosBasico.add(curso);
            }
        }
        
    }
	
	// TESTE PARA PASSAR
	@Test
	public void terEfutuadoPagamentoeLogadoTerAcessoAosCursos( ) throws Exception {
		LocalDate dataRenovacao = LocalDate.now().minusDays(1);
		
		List<Integer> cursosAdicionais = new ArrayList<>();
		
		AlunoModel aluno = new AlunoModel(1, "Wesley", "123", dataRenovacao, 100, false,cursosAdicionais);
		aluno.logar();
		aluno.pagar();
		aluno.cursos = this.cursos;
		
		assertEquals(cursosBasico, aluno.getMeusCursosByAluno());
	}
	
	// TESTE PARA FALHAR
	@Test
	public void naoTerEfutuadoPagamentoeLogadoNaoTerAcessoAosCursos( ) throws Exception {
		LocalDate dataRenovacao = LocalDate.now().minusDays(1);
		
		List<Integer> cursosAdicionais = new ArrayList<>();
		
		AlunoModel aluno = new AlunoModel(1, "Wesley", "123", dataRenovacao, 100, false,cursosAdicionais);
		aluno.cursos = this.cursos;
		aluno.logar();
		
		assertThrows(Exception.class, ()-> {aluno.getMeusCursosByAluno();});
	}

	// TESTE PARA PASSAR
	@Test
	public void aumentarMensaslidadeAoAdquirirNovosCursos() {
		LocalDate dataRenovacao = LocalDate.now().plusDays(10);
		List<Integer> cursosAdicionais = new ArrayList<>();
		float mensalidadeInicial = 100;
		
		AlunoModel aluno = new AlunoModel(1, "Wesley", "123", dataRenovacao, mensalidadeInicial, false,cursosAdicionais);
		
		aluno.logar();
		aluno.cursos = this.cursos;
		aluno.comprarCurso(14);
		
		assertThat(mensalidadeInicial < aluno.getMensalidade());
	}
}
