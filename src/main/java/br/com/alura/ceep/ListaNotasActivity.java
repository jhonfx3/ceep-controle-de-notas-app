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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_lista_notas);

        List<Nota> todasAsNotas = notasDeExemplo();

        configuraRecyclerView(todasAsNotas);
    }

    private List<Nota> notasDeExemplo() {
        NotaDAO dao = new NotaDAO();

        for (int i = 1; i < 10000; i++) {
            Nota nota = new Nota("Titulo " + i,
                    "descricao primeira nota");
            dao.insere(nota);
        }
        List<Nota> todasAsNotas = dao.todos();
        return todasAsNotas;
    }

    private void configuraRecyclerView(List<Nota> todasAsNotas) {
        RecyclerView listaNotas = findViewById(R.id.lista_notas_recyclerview);
        listaNotas.setAdapter(new ListaNotasAdapter(todasAsNotas, this));
        configuraLayoutManager(listaNotas);
    }

    private void configuraLayoutManager(RecyclerView listaNotas) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        listaNotas.setLayoutManager(layoutManager);
    }
}