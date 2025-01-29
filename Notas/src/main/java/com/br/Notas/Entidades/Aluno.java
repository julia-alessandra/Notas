package com.br.Notas.Entidades;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Aluno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_aluno")
    private String nome;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private List<Nota> notas = new ArrayList<>();;

    @Column(name = "frequencia")
    private Double frequencia;

    public Double getNotaDisciplina(String disciplina) {
        return notas.stream()
                    .filter(n -> n.getDisciplina().equalsIgnoreCase(disciplina))
                    .map(Nota::getNota)
                    .findFirst()
                    .orElse(null);
    }

    public Double getMediaNotas() {
        return notas.stream()
                    .mapToDouble(Nota::getNota)
                    .average()
                    .orElse(0.0);
    }
}
