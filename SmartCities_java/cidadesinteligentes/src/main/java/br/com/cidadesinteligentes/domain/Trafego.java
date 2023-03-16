package br.com.cidadesinteligentes.domain;

import java.time.LocalTime;
import java.util.Calendar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_TRAFEGO")
public class Trafego {
	
	@Id
	@SequenceGenerator(name = "TRAFEGO", sequenceName = "SQ_TB_TRAFEGO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRAFEGO")
	@Column(name = "id_trafego", nullable = false)
	private Long idSensor;
	
	@Column(name = "hr_leitura", nullable = false)
	private LocalTime horaLeitura;
	
	@Column(name = "vl_vol_trafego", length = 100, nullable = false)
	private String volumeTrafego;
	
	@ManyToOne
    @JoinColumn(name = "id_sensor")
	private Sensor sensor;
	
	@OneToOne
    @JoinColumn(name = "id_evento")
    private Evento evento;

	public Trafego() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Trafego(Long idSensor, LocalTime horaLeitura, String volumeTrafego, Sensor sensor, Evento evento) {
		super();
		this.idSensor = idSensor;
		this.horaLeitura = horaLeitura;
		this.volumeTrafego = volumeTrafego;
		this.sensor = sensor;
		this.evento = evento;
	}

	public Long getIdSensor() {
		return idSensor;
	}

	public void setIdSensor(Long idSensor) {
		this.idSensor = idSensor;
	}

	public LocalTime getHoraLeitura() {
		return horaLeitura;
	}

	public void setHoraLeitura(LocalTime horaLeitura) {
		this.horaLeitura = horaLeitura;
	}

	public String getVolumeTrafego() {
		return volumeTrafego;
	}

	public void setVolumeTrafego(String volumeTrafego) {
		this.volumeTrafego = volumeTrafego;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

}
