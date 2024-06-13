package one.digitalinnovation.gof.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.service.ClienteService;

import java.util.Optional;

/**
 * O controlador REST para operações CRUD relacionadas aos Clientes.
 * 
 * <p>Este controlador age como uma <b>Facade</b>, fornecendo uma interface
 * simplificada para interações com os serviços de Cliente, que são geridos
 * pelo <b>Spring</b> com o padrão de projeto <b>Strategy</b> para a lógica
 * de negócios e <b>Singleton</b> para a instância de serviços.
 */

@RestController
@RequestMapping("/clientes")
public class ClienteRestController {

    // Injeção de dependência de ClienteService usando @Autowired
    // Isso permite que o Spring injete automaticamente uma instância Singleton
    @Autowired
    private ClienteService clienteService;

    /**
     * Retorna todos os clientes.
     * 
     * <p>Este método responde a uma solicitação GET no endpoint "/clientes"
     * e utiliza a estratégia definida no ClienteService para buscar todos os clientes.</p>
     * 
     * @return ResponseEntity contendo a lista de todos os clientes.
     */
    @GetMapping
    public ResponseEntity<Iterable<Cliente>> buscarTodos() {
        // Utiliza o serviço para buscar todos os clientes
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    /**
     * Retorna um cliente específico com base no ID.
     * 
     * <p>Responde a uma solicitação GET no endpoint "/clientes/{id}" e busca
     * o cliente com o ID fornecido.</p>
     * 
     * @param id O ID do cliente a ser buscado.
     * @return ResponseEntity contendo o cliente encontrado ou um 404 se não encontrado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        // Busca o cliente pelo ID
        Optional<Cliente> cliente = Optional.ofNullable(clienteService.buscarPorId(id));
        // Responde com o cliente encontrado ou um status 404
        return cliente.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Insere um novo cliente.
     * 
     * <p>Responde a uma solicitação POST no endpoint "/clientes" para inserir
     * um novo cliente. O cliente é criado usando os dados fornecidos no corpo da solicitação.</p>
     * 
     * @param cliente O cliente a ser inserido.
     * @return ResponseEntity contendo o cliente criado e um status 201.
     */
    @PostMapping
    public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente) {
        // Insere o novo cliente
        clienteService.inserir(cliente);
        // Responde com o cliente criado e um status HTTP 201 (Created)
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    /**
     * Atualiza um cliente existente.
     * 
     * <p>Responde a uma solicitação PUT no endpoint "/clientes/{id}" para atualizar
     * um cliente existente com o ID fornecido. Utiliza os dados do cliente fornecidos
     * no corpo da solicitação.</p>
     * 
     * @param id O ID do cliente a ser atualizado.
     * @param cliente Os dados do cliente para atualizar.
     * @return ResponseEntity contendo o cliente atualizado ou um status 404 se não encontrado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        // Busca o cliente existente pelo ID
        Optional<Cliente> clienteExistente = Optional.ofNullable(clienteService.buscarPorId(id));
        // Atualiza o cliente se ele for encontrado
        if (clienteExistente.isPresent()) {
            clienteService.atualizar(id, cliente);
            return ResponseEntity.ok(cliente);
        } else {
            // Responde com um status 404 (Not Found) se o cliente não for encontrado
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Deleta um cliente existente.
     * 
     * <p>Responde a uma solicitação DELETE no endpoint "/clientes/{id}" para deletar
     * um cliente existente com o ID fornecido.</p>
     * 
     * @param id O ID do cliente a ser deletado.
     * @return ResponseEntity vazio com um status 204 se o cliente for deletado, ou 404 se não encontrado.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        // Busca o cliente existente pelo ID
        Optional<Cliente> clienteExistente = Optional.ofNullable(clienteService.buscarPorId(id));
        // Deleta o cliente se ele for encontrado
        if (clienteExistente.isPresent()) {
            clienteService.deletar(id);
            // Responde com um status HTTP 204 (No Content) se o cliente for deletado
            return ResponseEntity.noContent().build();
        } else {
            // Responde com um status 404 (Not Found) se o cliente não for encontrado
            return ResponseEntity.notFound().build();
        }
    }
}
