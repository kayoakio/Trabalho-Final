package bean;

import ejb.ClienteFacadeLocal;
import entity.Cliente;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

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
        cliente.setCPF(null);
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
        return "index.xhtml?faces-redirect=true";
    }

    public String editarCliente() {
        clienteEJB.editar(clienteSelecionado);
        clear();
        return "index.xhtml?faces-redirect=true";
    }

    public String excluirCliente() {
        clienteEJB.excluir(clienteSelecionado);
        clear();
        return "index.xhtml?faces-redirect=true";
    }
    
    public List<Cliente> procurarTodos(){
        return clienteEJB.procurarTodos();
    }

}
