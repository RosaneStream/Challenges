package one.digitalinnovation.gof.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import one.digitalinnovation.gof.model.Endereco;

// Interface que define o cliente Feign para o serviço ViaCEP.
@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

    // Método para consultar endereço pelo CEP usando GET Request.
    // O parâmetro 'cep' é dinâmico e inserido na URL do request.
    @GetMapping("/{cep}/json")
    Endereco consultarCep(@PathVariable("cep") String cep);
}
