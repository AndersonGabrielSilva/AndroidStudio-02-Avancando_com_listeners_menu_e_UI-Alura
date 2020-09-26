package com.meuprimeiroprojeto.agenda.dao;

import com.meuprimeiroprojeto.agenda.model.Aluno;
import java.util.*;

public class AlunoDAO {

    private final static List<Aluno> alunos = new ArrayList<>();

    public void Salva(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<Aluno> getTodosAlunos() {return new ArrayList<>(alunos);}

}
