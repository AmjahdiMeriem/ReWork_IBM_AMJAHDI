package ma.ibm.service;

public interface IvalidationService {

	public boolean valider(Long idDemande);
	
	public boolean refuser(Long idDemande);
}
