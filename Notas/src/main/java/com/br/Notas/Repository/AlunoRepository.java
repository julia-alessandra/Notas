package com.br.Notas.Repository;

import com.br.Notas.Entidades.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}

