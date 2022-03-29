package ma.ibm.modele;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TypeDemande {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idTypeDemande;
		private String libTypeDemande;
		private boolean stateDemande;
		
		@OneToMany(mappedBy = "typeDemande", orphanRemoval = true, cascade = CascadeType.ALL)
		private List<Demande> demandeTypeDemande;
		
		public Long getIdTypeDemande() {
			return idTypeDemande;
		}
		public void setIdTypeDemande(Long idTypeDemande) {
			this.idTypeDemande = idTypeDemande;
		}
		public String getLibTypeDemande() {
			return libTypeDemande;
		}
		public void setLibTypeDemande(String libTypeDemande) {
			this.libTypeDemande = libTypeDemande;
		}
		public boolean isStateDemande() {
			return stateDemande;
		}
		public void setStateDemande(boolean stateDemande) {
			this.stateDemande = stateDemande;
	}	
}
