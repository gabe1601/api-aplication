package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Table(name="medicos")
@Entity(name="Medico")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@Getter
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;
    private String telefone;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    //Construtor criado pra converter o dado do DTO
    public Medico(DadosCadastroMedico dados){
        this.nome=dados.nome();
        this.email=dados.email();
        this.crm=dados.crm();
        this.telefone=dados.telefone();
        this.especialidade=dados.especialidade();
        this.endereco=new Endereco(dados.endereco());
    }
}
