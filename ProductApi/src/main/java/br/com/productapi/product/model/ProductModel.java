package br.com.productapi.product.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.couchbase.core.mapping.event.AuditingEventListener;

@Entity
@Table(name="product")
@EntityListeners(AuditingEventListener.class)
public class ProductModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name="pk_sequence", sequenceName="product_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pk_sequence")
	private Long id;
	
	@NotBlank
	private String name; //descrição
	private String reference; // referencia
	private String barCode; //codigo de barras
	private boolean status; //situação Ativo/Inativo
	private String note; //observação
	private BigDecimal costPrice; //preço de custo
	private BigDecimal profitPerc;// percentual de lucro
	private BigDecimal profitValue; //valor do lucro
	private BigDecimal salePrice; // preco de venda
	
	//private int stockNow; //quantidae atual do estoque
	//private int stockMin; //quantidade minima do estoque
	//private ProviderModel provider; //fornecedor
	
	private MeasureModel measure; //unidade de medida
	private GroupModel group; //grupo
	private CategoryEnum category; // categoria Produto / Servico
	private GrifeModel grife; // grife 
	
	
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
	

}
