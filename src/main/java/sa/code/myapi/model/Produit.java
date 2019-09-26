package sa.code.myapi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="produits")
public class Produit implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false)
	private String name;
	@OneToMany(mappedBy="produit", fetch=FetchType.LAZY)
	List<Price> prices;
	@JoinColumn(name = "categorie_id", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Categorie categorieId;
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Price> getPrices() {
		return prices;
	}
	public void setPrices(List<Price> prices) {
		this.prices = prices;
	}
	public Categorie getCategorieId() {
		return categorieId;
	}

	public void setCategorieId(Categorie categorieId) {
		this.categorieId = categorieId;
	}
	
}
