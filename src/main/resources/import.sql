insert into Startup(id, nome, local, funcionarios)
values(nextval('hibernate_sequence'),'Nubank','São Paulo,São Paulo,Brasil',100),
(nextval('hibernate_sequence'),'AgroTech','Recife,Pernambuco,Brasil',10),
(nextval('hibernate_sequence'),'LuizaLab','João Pessoa, Paraíba, Brasil',32),
(nextval('hibernate_sequence'),'Ifood','Rio de Janeiro, Rio de Janeiro, Brasil',18),
(nextval('hibernate_sequence'),'AirBnb','São Paulo,São Paulo,Brasil',47),
(nextval('hibernate_sequence'),'Totvs','Petrolina,pernambuco,Brasil',22),
(nextval('hibernate_sequence'),'Alura','São Paulo,São Paulo,Brasil',87);

insert into Pitch  
values(nextval('hibernate_sequence'),'Série B','Aumentar o ecossistema tecnológico',1),
(nextval('hibernate_sequence'),'Série A','Investimento na escalabilidade do sistema',1),
(nextval('hibernate_sequence'),'Série A','Aumentar a infraestrutura de TI',4),
(nextval('hibernate_sequence'),'Série C','Compra de uma facilitadora de pagamento B2B',3),
(nextval('hibernate_sequence'),'Série A','Investimento na criação de um sistema de irrigação automatizado',2),
(nextval('hibernate_sequence'),'Série B','Aquisição de uma startup de entregas de pequenas encomendas',4),
(nextval('hibernate_sequence'),'Série A','Investimento em uma startup de biotecnologia',6);