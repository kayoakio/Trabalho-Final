package bean;

import ejb.ClienteFacadeLocal;
import entity.Cliente;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class ClienteBean implements Serializable {

    @EJB
    private ClienteFacadeLocal clienteEJB;
    
    private Cliente cliente;
    private Cliente clienteSelecionado;

    @PostConstruct
    public void init() {
        cliente = new Cliente();
    }

    //Gets
    public Cliente getCliente() {
        return cliente;
    }

    public Cliente getClienteSelecionado() {
        return clienteSelecionado;
    }

    //Sets 
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setClienteSelecionado(Cliente clienteSelecionado) {
        this.clienteSelecionado = clienteSelecionado;
    }

    //Métodos
    public void clear(){
        cliente.setCpf(null);
        cliente.setNome(null);
        cliente.setEndereco(null);
        cliente.setNascimento(null);
        cliente.setTelefone(null);
        cliente.setCreditos(null);
        cliente.setCurso(null);
    }
    
    public String criarCliente() {
        clienteEJB.criar(cliente);
        clear();
        return "/gerente/index?faces-redirect=true";
    }

    public void editarCliente() {
        clienteEJB.editar(clienteSelecionado);
        clear();
    }

    public void excluirCliente() {
        clienteEJB.excluir(clienteSelecionado);
        clear();
    }
    
    public List<Cliente> procurarTodosClientes(){
        return clienteEJB.procurarTodos();
    }

}
