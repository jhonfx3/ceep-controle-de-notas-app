package br.com.alura.ceep;

import static br.com.alura.ceep.R.layout.activity_lista_notas;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.alura.ceep.dao.NotaDAO;
import br.com.alura.ceep.model.Nota;
import br.com.alura.ceep.ui.recyclerview.adapter.ListaNotasAdapter;

public class ListaNotasActivity extends AppCompatActivity {

    private NotaDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_lista_notas);
        dao = new NotaDAO();

        List<Nota> todasAsNotas = notasDeExemplo();

        configuraRecyclerView(todasAsNotas);
    }

    private List<Nota> notasDeExemplo() {
        dao.insere(new Nota("Titulo 1", "Descricao 1"));
        dao.insere(new Nota("Titulo 2", "Descricao 2"));
        List<Nota> todasAsNotas = dao.todos();
        return todasAsNotas;
    }

    private void configuraRecyclerView(List<Nota> todasAsNotas) {
        RecyclerView listaNotas = findViewById(R.id.lista_notas_recyclerview);
        listaNotas.setAdapter(new ListaNotasAdapter(todasAsNotas, this));
    }

}