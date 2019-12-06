package ejb;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public abstract class AbstractFacadeLocal<T> {
    
    private final Class<T> entityClass;
    
    public AbstractFacadeLocal (Class<T> entityClass){
        this.entityClass = entityClass;
    }
    
    protected abstract EntityManager getEntityManager();
    
    public void criar (T entity) {
        getEntityManager().persist(entity);
    }
    
    public void editar (T entity) {
        getEntityManager().merge(entity);
    }
    
    public void excluir (T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }
    
    public T procurar(Object numero) {
        return getEntityManager().find(entityClass, numero);
    }

    public List<T> procurarTodos() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public Integer contador() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
}
