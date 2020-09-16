package br.com.alura.agenda.asynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import br.com.alura.agenda.database.dao.TelefoneDAO;
import br.com.alura.agenda.model.Telefone;

public class BuscaPrimeiroTelefoneDoAlunoTask extends AsyncTask<Void, Void, Telefone> {

    private final TelefoneDAO dao;
    private int alunoId;
    private final PrimeiroTelefoneEncontradoListener listener;

    public BuscaPrimeiroTelefoneDoAlunoTask(TelefoneDAO dao, int alunoId,
                                            PrimeiroTelefoneEncontradoListener listener) {
        this.dao = dao;
        this.alunoId = alunoId;
        this.listener = listener;
    }

    @Override
    protected Telefone doInBackground(Void... voids) {
        Telefone primeiroTelefoneDoAluno = dao.buscaPrimeiroTelefoneDoAluno(alunoId);
        return primeiroTelefoneDoAluno;
    }

    @Override
    protected void onPostExecute(Telefone primeiroTelefone) {
        super.onPostExecute(primeiroTelefone);
        listener.quandoEncontrado(primeiroTelefone);
    }

    public interface PrimeiroTelefoneEncontradoListener {
        void quandoEncontrado(Telefone telefoneEncontrado);
    }

}
