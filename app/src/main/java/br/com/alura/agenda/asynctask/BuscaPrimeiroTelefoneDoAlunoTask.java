package br.com.alura.agenda.asynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import br.com.alura.agenda.database.dao.TelefoneDAO;
import br.com.alura.agenda.model.Telefone;

public class BuscaPrimeiroTelefoneDoAlunoTask extends AsyncTask<Void, Void, Telefone> {

    private final TelefoneDAO dao;
    private final TextView campoTelefone;
    private int alunoId;

    public BuscaPrimeiroTelefoneDoAlunoTask(TelefoneDAO dao, TextView campoTelefone, int alunoId) {
        this.dao = dao;
        this.campoTelefone = campoTelefone;
        this.alunoId = alunoId;
    }

    @Override
    protected Telefone doInBackground(Void... voids) {
        Telefone primeiroTelefoneDoAluno = dao.buscaPrimeiroTelefoneDoAluno(alunoId);
        return primeiroTelefoneDoAluno;
    }

    @Override
    protected void onPostExecute(Telefone primeiroTelefone) {
        super.onPostExecute(primeiroTelefone);
        campoTelefone.setText(primeiroTelefone.getNumero());
    }
}
