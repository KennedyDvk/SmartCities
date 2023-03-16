package br.com.cidadesinteligentes.domain;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name = "TB_EVENTO")
public class Evento {
	
	@Id
	@SequenceGenerator(name = "EVENTO", sequenceName = "SQ_TB_EVENTO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EVENTO")
	@Column(name = "id_evento", nullable = false)
	private Long id;
	
	@Column(name = "nm_evento", length = 200, nullable = false)
	private String nome;
	
	@Column(name = "dt_evento", nullable = false)
	private LocalDate dtEvento;
	
	@Column(name = "ds_local_evento", length = 200, nullable = false)
	private String descricaoLocalEv;
	
	@OneToOne(mappedBy = "evento")
    private Trafego trafego;
	
	@OneToMany(mappedBy = "evento")
	private List<ServicoPublico> servicosublico;

	public Evento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Evento(Long id, String nome, LocalDate dtEvento, String descricaoLocalEv, Trafego trafego,
			List<ServicoPublico> servicosublico) {
		super();
		this.id = id;
		this.nome = nome;
		this.dtEvento = dtEvento;
		this.descricaoLocalEv = descricaoLocalEv;
		this.trafego = trafego;
		this.servicosublico = servicosublico;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDtEvento() {
		return dtEvento;
	}

	public void setDtEvento(LocalDate dtEvento) {
		this.dtEvento = dtEvento;
	}

	public String getDescricaoLocalEv() {
		return descricaoLocalEv;
	}

	public void setDescricaoLocalEv(String descricaoLocalEv) {
		this.descricaoLocalEv = descricaoLocalEv;
	}

	public Trafego getTrafego() {
		return trafego;
	}

	public void setTrafego(Trafego trafego) {
		this.trafego = trafego;
	}

	public List<ServicoPublico> getServicosublico() {
		return servicosublico;
	}

	public void setServicosublico(List<ServicoPublico> servicosublico) {
		this.servicosublico = servicosublico;
	}
	
	

}
