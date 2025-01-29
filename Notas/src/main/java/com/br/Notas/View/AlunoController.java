package com.br.Notas.View;

import com.br.Notas.Entidades.Aluno;
import com.br.Notas.Entidades.Nota;
import com.br.Notas.Repository.AlunoRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/Notas")
    public String listarAlunos(Model model) {
        List<Aluno> alunos = alunoRepository.findAll();
        model.addAttribute("alunos", alunos);
    
        String[] disciplinas = {"Matéria 1", "Matéria 2", "Matéria 3", "Matéria 4", "Matéria 5"};
        Map<String, Double> mediaGeral = new HashMap<>();
    
        for (String disciplina : disciplinas) {
            double media = alunos.stream()
                    .flatMap(aluno -> aluno.getNotas().stream())
                    .filter(nota -> nota.getDisciplina().equalsIgnoreCase(disciplina))
                    .mapToDouble(Nota::getNota)
                    .average()
                    .orElse(0.0);
            mediaGeral.put(disciplina, media);
        }
    
        model.addAttribute("mediaGeral", mediaGeral);
    
        double mediaTurma = alunos.stream()
                .mapToDouble(Aluno::getMediaNotas)
                .average()
                .orElse(0.0);
        model.addAttribute("mediaTurma", mediaTurma);
    
        List<Aluno> acimaMedia = alunos.stream()
                .filter(aluno -> aluno.getMediaNotas() > mediaTurma)
                .collect(Collectors.toList());
    
        List<Aluno> abaixoFrequencia = alunos.stream()
                .filter(aluno -> aluno.getFrequencia() < 75)
                .collect(Collectors.toList());
    
        model.addAttribute("acimaMedia", acimaMedia);
        model.addAttribute("abaixoFrequencia", abaixoFrequencia);
    
        return "alunos";
    }

    @PostMapping("/salvarAluno")
    public String salvarAluno(@RequestParam String nome, @RequestParam List<Double> notas, @RequestParam Double frequencia) {
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setFrequencia(frequencia);

        String[] disciplinas = {"Matéria 1", "Matéria 2", "Matéria 3", "Matéria 4", "Matéria 5"};
        for (int i = 0; i < disciplinas.length; i++) {
            Nota nota = new Nota();
            nota.setDisciplina(disciplinas[i]);
            nota.setNota(notas.get(i));
            nota.setAluno(aluno);
            aluno.getNotas().add(nota);
        }

        alunoRepository.save(aluno);
        return "redirect:/Notas";
    }

    // Método para deletar aluno
    @GetMapping("/deletarAluno/{id}")
    public String deletarAluno(@PathVariable Long id) {
        alunoRepository.deleteById(id);
        return "redirect:/Notas";
    }
}
