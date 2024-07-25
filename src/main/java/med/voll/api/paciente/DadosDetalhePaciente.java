package med.voll.api.paciente;

import med.voll.api.endereco.Endereco;

public record DadosDetalhePaciente(Long id, String nome, String telefone, String cpf, Endereco endereco) {

    public DadosDetalhePaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getTelefone(), paciente.getCpf(), paciente.getEndereco());
    }
}
