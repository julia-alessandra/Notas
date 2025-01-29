package com.br.Notas.Service;


import com.br.Notas.Entidades.Aluno;
import com.br.Notas.Repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno salvarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }
}

