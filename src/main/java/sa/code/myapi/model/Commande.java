package sa.code.myapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="commandes")
public class Commande implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dte;
	@Column(nullable=false)
	private String nomCli;
	private String telCli;
	private String adrsCli;
	private String description;
	@OneToMany(mappedBy="commande")
	@JsonManagedReference
	List<Item> items;
	@ManyToOne
	@JoinColumn(name="status_id")
	private Status status;
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDte() {
		return dte;
	}
	public void setDte(Date dte) {
		this.dte = dte;
	}
	public String getNomCli() {
		return nomCli;
	}
	public void setNomCli(String nomCli) {
		this.nomCli = nomCli;
	}
	public String getTelCli() {
		return telCli;
	}
	public void setTelCli(String telCli) {
		this.telCli = telCli;
	}
	public String getAdrsCli() {
		return adrsCli;
	}
	public void setAdrsCli(String adrsCli) {
		this.adrsCli = adrsCli;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
}
