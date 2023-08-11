## Projeto final do curso de Modelagem Conceitual com Diagrama de Classes da UML
Esse projeto tem como objetivo mostrar na prática como um modelo conceitual pode ser implementado sobre o paradigma orientado a objetos.
Será implementado um modelo conceitual básico utilizando o framework Spring Boot.
 - Leitura e entendimento do diagrama de classes
 - Leitura e entendimento do diagrama de objetos
 - Associações
 - Um para muitos / muitos para um
 - Um para um
 - Muitos para muitos
 - Conceito dependente
 - Classe de associação
 - Herança
 - Enumerações
 - Tipos primitivos (ItemPedidoPK)
 - Entidades fracas (ElementCollection)
 - Associações direcionadas

# Objetivo
Tomar como caso um modelo conceitual abrangente, com o qual possamos mostrar a implementação prática em uma linguagem orientada a objetos
1) Desenvolver um modelo conceitual para utilizar como base na API que será desenvolvida;
2) Criar uma instância do modelo conceitual;
3) Gerar uma base de dados relacional automaticamente a partir do modelo conceitual, bem como povoar a base com a instância dada.
4) Recuperar os dados e disponibilizá-los por meio de uma API Rest BÁSICA. Os seguintes end-points devem ser disponibilizados:
    - /categorias/{id}  - Categoria e seus produtos
    - /clientes/{id} - Cliente, seus telefones e seus endereços
    - /pedidos/{id} - Pedido, seu cliente, seu pagamento, seus itens de
pedido, seu endereço de entrega

# Resultado
### Modelo Conceitual desenvolvido:
![Captura de tela 2023-08-10 223257](https://github.com/IgorWolf99/ProjetoUML/assets/116234237/ed74a4d0-0ecb-48eb-92b7-c50baa8faf57)

### Instância do modelo conceitual:
![Captura de tela 2 2023-08-10 230243](https://github.com/IgorWolf99/ProjetoUML/assets/116234237/5f7a9258-b68b-4f3a-b62e-91c9b644292b)
