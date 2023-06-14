use AutotechDB;

create table metrica (
idMetrica int primary key auto_increment,
fkComponente int,
fkHardware int,
fkUnidade int,
fkCliente int,
fkModeloComponente int,
porcentagemUso decimal(6,2),
dtHora datetime
);
