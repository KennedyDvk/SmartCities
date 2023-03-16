package br.com.cidadesinteligentes.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name = "TB_SERV_PUBLICO")
public class ServicoPublico {
	
	@Id
	@SequenceGenerator(name = "SERV_PUBLICO", sequenceName = "SQ_TB_SERV_PUBLICO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SERV_PUBLICO")
	@Column(name = "id_servico", nullable = false)
	private Long id;
	
	@Column(name = "ds_tipo_serv", length = 200, nullable = false)
	private String descricalTipo;
	
	@Column(name = "ds_local_serv", length = 200, nullable = false)
	private String descricaoLocalServ;
	
	@Column(name = "dt_instalacao", nullable = false)
	private LocalDate dtInstalacao;
	
	@ManyToOne
    @JoinColumn(name = "id_evento")
	private Evento evento;

	public ServicoPublico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServicoPublico(Long id, String descricalTipo, String descricaoLocalServ, LocalDate dtInstalacao,
			Evento evento) {
		super();
		this.id = id;
		this.descricalTipo = descricalTipo;
		this.descricaoLocalServ = descricaoLocalServ;
		this.dtInstalacao = dtInstalacao;
		this.evento = evento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricalTipo() {
		return descricalTipo;
	}

	public void setDescricalTipo(String descricalTipo) {
		this.descricalTipo = descricalTipo;
	}

	public String getDescricaoLocalServ() {
		return descricaoLocalServ;
	}

	public void setDescricaoLocalServ(String descricaoLocalServ) {
		this.descricaoLocalServ = descricaoLocalServ;
	}

	public LocalDate getDtInstalacao() {
		return dtInstalacao;
	}

	public void setDtInstalacao(LocalDate dtInstalacao) {
		this.dtInstalacao = dtInstalacao;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

}
