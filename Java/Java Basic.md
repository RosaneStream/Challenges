# Desafios de Programação em Java Basico

## 1. Operações Bancárias Simples com `switch`

### Descrição
Simulação de operações bancárias básicas como depósitos, saques e consulta de saldo em uma conta bancária virtual.

### Entrada
- O programa exibe um menu com as opções:
  1. Depositar
  2. Sacar
  3. Consultar Saldo
  4. Encerrar
- O usuário escolhe uma opção digitando o número correspondente.

### Saída
- Utilizando `switch`, o programa executa a operação escolhida.
- **Depositar**: Solicita o valor e atualiza o saldo.
- **Sacar**: Verifica se há saldo suficiente.
- **Consultar Saldo**: Exibe o saldo atual.
- **Encerrar**: Termina a execução do programa.

### Exemplos
| Entrada | Saída |
| ------- | ----- |
| 1<br>50<br>2<br>100<br>0 | Saldo atual: 50.0<br>Saldo insuficiente.<br>Programa encerrado. |
| 3<br>1<br>550<br>0 | Saldo atual: 0.0<br>Saldo atual: 550.0<br>Programa encerrado. |
| 1<br>1000<br>2<br>500<br>0 | Saldo atual: 1000.0<br>Saldo atual: 500.0<br>Programa encerrado. |

### Código
```java
import java.util.Scanner;

public class SimulacaoBancaria {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double saldo = 0;
        boolean continuar = true;

        while (continuar) {
            // Solicitar opção ao usuário
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // Ler o valor a ser depositado e atualizar/imprimir o saldo.
                    System.out.println();
                    double deposito = scanner.nextDouble();
                    saldo += deposito;
                    System.out.printf("Saldo atual: %.1f%n", saldo);
                    break;
                case 2:
                    // Ler o valor a ser sacado e verificar/imprimir se há saldo suficiente.
                    System.out.println();
                    double saque = scanner.nextDouble();
                    if (saque <= saldo) {
                        saldo -= saque;
                        System.out.printf("Saldo atual: %.1f%n", saldo);
                    } else {
                        System.out.println("Saldo insuficiente.");
                    }
                    break;
                case 3:
                    // Exibir o saldo atual da conta.
                    System.out.printf("Saldo atual: %.1f%n", saldo);
                    break;
                case 0:
                    // Encerrar o programa.
                    System.out.println("Programa encerrado.");
                    continuar = false;  // Atualiza a variável de controle para encerrar o loop
                    break;
                default:
                    // Opção inválida.
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
}

```

## 2. Verificação de Número de Conta Bancária

### Descrição
Verificação da validade de um número de conta bancária, que deve ter exatamente 8 dígitos.

### Entrada
- O programa solicita o número da conta bancária.

### Saída
- Utiliza `try-catch` para validar o número da conta.
- Informa se o número é válido ou inválido.

### Exemplos
| Entrada  | Saída |
| -------- | ----- |
| 01020304 | Numero de conta valido. |
| 1234568  | Erro: Numero de conta invalido. Digite exatamente 8 digitos. |
| 3231     | Erro: Numero de conta invalido. Digite exatamente 8 digitos. |

### Código
```java
import java.util.Scanner;

public class VerificadorNumeroConta {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            
            String numeroConta = scanner.nextLine();

            // Chama o método que verifica se o número da conta é válido
            verificarNumeroConta(numeroConta);

            // Caso nenhuma exceção seja lançada, imprime a mensagem de sucesso
            System.out.println("Numero de conta valido.");
        } catch (IllegalArgumentException e) {
            // Informa que o número de conta é inválido e exibe a mensagem de erro
            System.out.println("Erro: " + e.getMessage());
        } finally {
            // Fecha o scanner para evitar vazamentos de recursos
            scanner.close();
        }
    }

    // Método que verifica se o número da conta possui exatamente 8 dígitos
    private static void verificarNumeroConta(String numeroConta) {
        if (numeroConta.length() != 8) {
            // Lança uma IllegalArgumentException com a mensagem apropriada
            throw new IllegalArgumentException("Numero de conta invalido. Digite exatamente 8 digitos.");
        }
    }
}
```

## 3. Verificador de Idade para Conta Bancária

### Descrição
Verificação se um cliente é elegível para criar uma conta bancária baseado na idade, que deve ser pelo menos 18 anos.

### Entrada
- O programa solicita ao usuário que digite sua idade.

### Saída
- Utilizando `if-else`, o programa verifica se a idade é igual ou superior a 18 anos.
- **Elegível**: Informa que o cliente pode criar uma conta bancária.
- **Não Elegível**: Informa que o cliente não pode criar uma conta bancária.

### Exemplos
| Entrada | Saída |
| ------- | ----- |
| 17      | Voce nao esta elegivel para criar uma conta bancaria. |
| 26      | Voce esta elegivel para criar uma conta bancaria. |
| 18      | Voce esta elegivel para criar uma conta bancaria. |

### Código
```java

import java.util.Scanner;


public class VerificadorElegibilidadeConta {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        int idade = scanner.nextInt();

        // Verificar se a idade do cliente
        if (idade >= 18) {
            // Se >= 18, imprimir "Voce esta elegivel para criar uma conta bancaria."
            System.out.println("Voce esta elegivel para criar uma conta bancaria.");
        } else {
            // Caso contrário, imprimir "Voce nao esta elegivel para criar uma conta bancaria."
            System.out.println("Voce nao esta elegivel para criar uma conta bancaria.");
        }

        // Fechar o scanner para evitar vazamentos de recursos
        scanner.close();
    }
}
```

## 4. Verificação de Cheque Especial

### Descrição
Desenvolvimento de um programa em Java para verificar se uma conta bancária ultrapassou o limite do cheque especial após a realização de um saque.

### Entrada
- Saldo atual da conta bancária.
- Valor do saque desejado pelo cliente.

### Saída
- O programa verifica se o saque ultrapassa o saldo disponível.
- Se o saque não ultrapassar o saldo, informa que a transação foi realizada com sucesso.
- Se o saque ultrapassar o saldo, mas não o limite do cheque especial (500 unidades monetárias), informa que a transação foi realizada com sucesso utilizando o cheque especial.
- Se o saque ultrapassar o limite do cheque especial, informa que a transação não pode ser realizada.

### Exemplos
| Entrada | Saída |
| ------- | ----- |
| 1000<br>100 | Transação realizada com sucesso. |
| 2500<br>2750 | Transação realizada com sucesso utilizando o cheque especial. |
| 300<br>1500 | Transação não realizada. Limite do cheque especial excedido. |

### Código
```java
import java.util.Scanner;

public class VerificacaoChequeEspecial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double saldo = scanner.nextDouble();
        double saque = scanner.nextDouble();

        // Define um limite para o cheque especial
        double limiteChequeEspecial = 500;
        // Calcula o total disponivel
        double totalDisponivel = limiteChequeEspecial + saldo;

        // Verifica se o saque ultrapassa o saldo disponível
        if (saque <= saldo) {
            // TODO: Imprimir "Transação realizada com sucesso."
            System.out.printf("Transacao realizada com sucesso.");
            
        } else {
            // TODO: Verificar se o saque ultrapassa o limite do cheque especial
            // Em caso positivo, imprimir "Transacao realizada com sucesso utilizando o cheque especial."
            if (saque <= totalDisponivel) {
                 System.out.println("Transacao realizada com sucesso utilizando o cheque especial.");
            } else {
            // Caso contrário, imprimir "Transacao nao realizada. Limite do cheque especial excedido."
                 System.out.println("Transacao nao realizada. Limite do cheque especial excedido.");
            }
        }

        // Fechar o scanner para evitar vazamentos de recursos
        scanner.close();
    }
}
```

## 5. Controle de Saques

### Descrição
Programa em Java para auxiliar um cliente a realizar saques de uma conta bancária, respeitando um limite diário predefinido.

### Entrada
- Limite diário de saque.
- Valor do primeiro saque.

### Saída
- O programa itera sobre os saques e verifica se o valor ultrapassa o limite diário.
- Se o valor do saque ultrapassar o limite, informa que o limite foi atingido e encerra o loop.
- Se o valor do saque não ultrapassar o limite, informa que o saque foi realizado com sucesso e atualiza o limite restante.

### Exemplos
| Entrada | Saída |
| ------- | ----- |
| 1500<br>430<br>0 | Saque realizado. Limite restante: 1070.0<br>Transações encerradas. |
| 500<br>1500 | Limite diário de saque atingido. Transações encerradas. |
| 80<br>40<br>0 | Saque realizado. Limite restante: 40.0<br>Transações encerradas. |

### Código
```java
import java.util.Scanner;

public class ControleSimplesDeSaques {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double limiteDiario = scanner.nextDouble();

        // Loop for para iterar sobre os saques
        for (int i = 1; ; i++) {

            double valorSaque = scanner.nextDouble();

            if (valorSaque == 0) {
                System.out.println("Transacoes encerradas.");
                break; // Encerra o loop
            } else if (valorSaque > limiteDiario) {
                System.out.println("Limite diario de saque atingido. Transacoes encerradas.");
                break; // Encerra o loop
            } else {
                // TODO: Atualizar o limite diário e imprimir a saída no formato dos exemplos.
                limiteDiario -= valorSaque; 
                System.out.printf("Saque realizado. Limite restante: %.1f%n", limiteDiario);         
            }
        }
        // Fechar o scanner para evitar vazamentos de recursos
        scanner.close();
    }
}
```
