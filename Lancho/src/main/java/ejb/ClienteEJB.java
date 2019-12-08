package ejb;

import entity.Cliente;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ClienteEJB
        extends AbstractFacadeLocal<Cliente>
        implements ClienteFacadeLocal {

    @PersistenceContext(unitName = "lanchonetePU")
    private EntityManager entityManager;

    public ClienteEJB() {
        super(Cliente.class);
    }

    public ClienteEJB(Class<Cliente> entityClass) {
        super(entityClass);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public void criar(Cliente cliente) {
        cliente.setData(new Date());
        getEntityManager().persist(cliente);
    }
}
