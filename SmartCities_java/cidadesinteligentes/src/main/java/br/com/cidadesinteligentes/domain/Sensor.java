package br.com.cidadesinteligentes.domain;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_SENSOR")
public class Sensor {
	
	@Id
	@SequenceGenerator(name = "SENSOR", sequenceName = "SQ_TB_SENSOR", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SENSOR")
	@Column(name = "id_sensor", nullable = false)
	private Long id;
	
	@Column(name = "ds_localizacao", length = 200, nullable = false)
	private String localizacao;
	
	@Column(name = "tp_sensor", length = 100, nullable = false)
	private String tipoSensor;
	
	@Column(name = "dt_instalacao", nullable = false)
	private LocalDate dtInstalacao;
	
	@OneToMany(mappedBy = "sensor")
	private List<Trafego> trafego;

	public Sensor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sensor(Long id, String localizacao, String tipoSensor, LocalDate dtInstalacao, List<Trafego> trafego) {
		super();
		this.id = id;
		this.localizacao = localizacao;
		this.tipoSensor = tipoSensor;
		this.dtInstalacao = dtInstalacao;
		this.trafego = trafego;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String getTipoSensor() {
		return tipoSensor;
	}

	public void setTipoSensor(String tipoSensor) {
		this.tipoSensor = tipoSensor;
	}

	public LocalDate getDtInstalacao() {
		return dtInstalacao;
	}

	public void setDtInstalacao(LocalDate dtInstalacao) {
		this.dtInstalacao = dtInstalacao;
	}

	public List<Trafego> getTrafego() {
		return trafego;
	}

	public void setTrafego(List<Trafego> trafego) {
		this.trafego = trafego;
	}
	
	

}
