# Magic Kudos
Dividir em Duas macro partes:
 - API (servidor)
 - WebApp (Cliente)

Vamos atacar primeiro o projeto do servidor.
Vamos fazer um servidor java usando Spring MVC e Spring Boot.
O que deve conter nosso projeto no final?
Devemos servir uma API Restful HTTP num determinado endereço. Ex.:
http://<domain>/magikudos/getKudos

Features básicas da Prova de Conceito (ou seja, um http endpoint pra cada):
 - Criar Usuário
 - Criar Kudo
 - Listar Kudos
 - Arquivar Kudos
O que eu queria que ce comecasse a fazer nesse primeiro momento
É, identificado as features básicas, montar os Modelos pra que representemos essas abstraçoes
Exemplo: Criar Usuário
O que seria um usuário?

Usuário teem que ter
- nome
- id
- email

etc etc


usar um banco de documentos mesmo pra armazenar esses dados
Tipo um mongo

