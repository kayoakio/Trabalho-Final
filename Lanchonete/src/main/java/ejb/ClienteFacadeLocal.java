package ejb;

import entity.Cliente;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ClienteFacadeLocal {
    
   public void criar (Cliente cliente);
   public void editar (Cliente cliente);
   public void excluir (Cliente cliente);
   public Cliente procurar (Object cpf);
   public List<Cliente> procurarTodos();
   public Integer contador();
    
}
