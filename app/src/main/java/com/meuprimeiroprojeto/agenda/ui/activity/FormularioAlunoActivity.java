package com.meuprimeiroprojeto.agenda.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.meuprimeiroprojeto.agenda.R;
import com.meuprimeiroprojeto.agenda.dao.AlunoDAO;
import com.meuprimeiroprojeto.agenda.model.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Novo aluno";
    private EditText campoTelefone;
    private EditText campoEmail;
    private EditText campoNome;
    final AlunoDAO alunoDAO = new AlunoDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);

        setTitle(TITULO_APPBAR);

        IinicializacaoDosCampos();

        ConfiguraBotaoSalvar();

    }

    private void ConfiguraBotaoSalvar() {
        Button botaoSalvar = findViewById(R.id.Activity_formulario_botao_salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Aluno aluno = CriaAluno();
                Salva(aluno);
            }
        });
    }

    private void IinicializacaoDosCampos() {
        campoTelefone = findViewById(R.id.Activity_formulario_aluno_telefone);
        campoEmail = findViewById(R.id.Activity_formulario_aluno_email);
        campoNome = findViewById(R.id.Activity_formulario_aluno_nome);
    }

    private void Salva(Aluno alunoCriado) {
        alunoDAO.Salva(alunoCriado);
        finish();
    }

    private Aluno CriaAluno() {
        String nome = campoNome.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String email = campoEmail.getText().toString();
        return new Aluno(nome, telefone, email);
    }
}