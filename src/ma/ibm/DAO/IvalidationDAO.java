package ma.ibm.DAO;

public interface IvalidationDAO {

	public boolean valider(Long idDemande);
	
	public boolean refuser(Long idDemande);
	
}
