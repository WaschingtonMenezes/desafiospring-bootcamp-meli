![banner lema do mercado livre](https://media-exp1.licdn.com/dms/image/C4D16AQGfS0oAmsz1CA/profile-displaybackgroundimage-shrink_200_800/0/1614167337659?e=1627516800&v=beta&t=37I3eOgnRWT8N-inY2eorkHOg5z99C0ZyeRa8L8oDkk)

# SocialMELI, by: Grupo 2.

O Mercado Livre continua a crescer e para o próximo ano pretende começar a implementar uma série de ferramentas que permitam a compradores e vendedores
uma experiência totalmente inovadora, onde o vínculo que os une é muito mais forte. A data de lançamento está próxima, por isso é necessário apresentar uma versão Beta do que será conhecido como "SocialMeli", onde os compradores poderão acompanhar
seus vendedores favoritos e saber todas as novidades que eles mesmos postam. Desta forma, elaboramos uma prévia do Back-end da aplicação/Rede Social(API REST) e algumas de funcionalidades.

## Informações Backend
- Tecnologoias utilizadas: 
1. Java, IntelliJ e Spring Boot;
2. Design Patterns: MVC
3. Documentação e Consumo da API ([link](https://app.swaggerhub.com/apis-docs/Jonathan-eng-jur/cats-api/1.0.0))

- Procedimentos para rodar local:
1. Clone o repositório desta aplicação pelo terminal do seus sistema operacional, ou realizar o Download no formato zip. e descompactar;
2. Utilizando a IDE de sua preferência (mas que tenha suporte para aplicações SpringBoot);
3. Importar o arquivo "DesafioSpringBoot" deste repositório, como arquivo do tipo MAVEN.

## Informações Banco de Dados
- Tecnologoias utilizadas: H2 Console.
- Informações inseridas no Application Properties.
- Criação das tabelas e armazemaneto das informação consumidas da API (no H2 Console).
- Criação de um arquivo data.sql(com dados inseridos para popular o banco).

- Procedimentos para acesso local:
1. Iniciar(run) sua aplicação localmente;
2. Acessar no seu navegador o link "http://localhost:8080/h2-console", click em Test Connection, e depois Connect;
3. Agora já pode explorar o ambiente do Banco de Dados.

### Funcionalidades - Requisitos técnicos funcionais

- US 0001: Ser capaz de realizar a ação de “Follow” (seguir) a um determinado vendedor;
- US 0002: Obter o resultado do número de usuários que seguem um determinado vendedor;
- US 0003: Obter uma lista de todos os usuários que seguem um determinado vendedor (quem me segue?);
- US 0004:  Obter uma lista de todos os vendedores que um determinado usuário segue (quem estou seguindo?);
- US 0005: Cadastrar uma nova publicação;
- US 0006: Obter uma lista das publicações feitas pelos vendedores que um usuário segue nas últimas duas semanas (para isso, ter em conta ordenação por data, a maioria das publicações recentes primeiro);
- US 0007: Ser capaz de realizar a ação de “Deixar de seguir” (parar de seguir) um determinado vendedor;
- US 0008: Ordem alfabética crescente e decrescente;
- US 0009: Classificar por data crescente e decrescente;
- US 0010:  Realizar a publicação de um novo produto promocional;
- US 0011: Obtenha o quantidade de produtos promocionais de um vendedor específico;
- US 0012: Obter uma lista de todos os produtos promocionais de um vendedor específico.

### Implementações futuras
- Cupons de desconto na Rede Social, pelo nível de iteratividade gamificada -> proporcionais ao número de compras/iterações;
- Cashback de 1%, 5 e 10% em compras selecionadas, nos quais serão creditados na conta Mercado Pago;
- Recebimento de notificações, quando os vendedores que o cliente segue publicacar um produto na promoção.
- 


### Squad

- Igor Cruz Avelino
- [![Linkedin Badge](https://img.shields.io/badge/-LinkedIn-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/igor-cruz-avelino/)](https://www.linkedin.com/in/igor-cruz-avelino/)
- [![Github Badge](https://img.shields.io/badge/-Github-000?style=flat-square&logo=Github&logoColor=white&link=https://github.com/icrxz)](https://github.com/icrxz)

- Jonathan de Paula
- [![Linkedin Badge](https://img.shields.io/badge/-LinkedIn-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/jonathan-dev-fullstack/)](https://www.linkedin.com/in/jonathan-dev-fullstack/)
- [![Github Badge](https://img.shields.io/badge/-Github-000?style=flat-square&logo=Github&logoColor=white&link=https://github.com/JCavalcanti-Meli)](https://github.com/JCavalcanti-Meli)

- Marina Pinheiro Fachin
- [![Linkedin Badge](https://img.shields.io/badge/-LinkedIn-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://br.linkedin.com/in/marina-pinheiro-fachin)](https://https://br.linkedin.com/in/marina-pinheiro-fachin)
- [![Github Badge](https://img.shields.io/badge/-Github-000?style=flat-square&logo=Github&logoColor=white&link=https://github.com/mafachin)](https://github.com/mafachin)

- Waschington L. Menezes Filho
- [![Linkedin Badge](https://img.shields.io/badge/-LinkedIn-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://br.linkedin.com/in/was-menezes?trk=people-guest_people_search-card)](https://https://br.linkedin.com/in/was-menezes?trk=people-guest_people_search-card)
- [![Github Badge](https://img.shields.io/badge/-Github-000?style=flat-square&logo=Github&logoColor=white&link=https://github.com/WaschingtonMenezes)](https://github.com/WaschingtonMenezes)
