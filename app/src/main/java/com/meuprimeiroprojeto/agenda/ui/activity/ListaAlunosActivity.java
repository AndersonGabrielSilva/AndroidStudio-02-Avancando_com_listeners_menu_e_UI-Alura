package com.meuprimeiroprojeto.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.meuprimeiroprojeto.agenda.R;
import com.meuprimeiroprojeto.agenda.dao.AlunoDAO;

public class ListaAlunosActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Lista de Alunos";
    AlunoDAO dao = new AlunoDAO();


    //Metodo executado sempre no quando a Activity está sendo criada
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        setTitle(TITULO_APPBAR);

        ConfiguraFabNovoAluno();
    }

    private void ConfiguraFabNovoAluno() {
        FloatingActionButton fabNovo = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);
        fabNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AbrirFormularioAlunoActivity();
            }
        });
    }

    private void AbrirFormularioAlunoActivity() {
        startActivity(new Intent(this,
                FormularioAlunoActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        CarregaListaDeAlunos();
    }

    private void CarregaListaDeAlunos() {
        ListView listaAlunos =  findViewById(R.id.activity_lista_de_alunos_list_view);
        listaAlunos.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dao.getTodosAlunos()));
    }
}
