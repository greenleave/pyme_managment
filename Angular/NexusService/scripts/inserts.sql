insert into Z_Users 
values (1, 'default');

insert into Z_User_Settings 
values (1, 'default setting', 1, 1, 1);

insert into Z_Reference_Setting_Report 
values (1, 1, 1);

insert into Z_reports 
values (1, 'cantidad de descripciones por estado', 'select status_tx Status, count(1) Cantidad from vw_soporte_transacciones where fecha > sysdate  -365 group by status_tx');

insert into Z_Reference_Setting_Chart 
values (1, 1, 1);

insert into Z_charts 
values (1, 'Bar Chart');

insert into Z_Reference_Report_Chart 
values (1, 1, 1,'{"rows":[{"name":"Status"},{"name":"Cantidad"}]}','{"cols":[{"id":"","label":"Estados","pattern":"","type":"string"},{"id":"","label":"Cantidad de Transacciones","pattern":"","type":"number"}],"rows":[{"c":[{"v":"Pendiente"},{"v":"201"}]},{"c":[{"v":"Finalizada parcialmente"},{"v":"332"}]},{"c":[{"v":"Encolado"},{"v":"138"}]},{"c":[{"v":"Finalizada"},{"v":"444"}]}]}',sysdate-1, 10);

insert into Z_Reference_Setting_Report 
values (2, 2, 1);

insert into Z_reports 
values (2, 'Cantidad de boxes y visitas en espera', 'select sucursal_display Sucursal, cantidad_boxes Boxes, visitas_en_espera EnEspera from sucursales where rownum <= 10 order by cantidad_boxes desc');

insert into Z_Reference_Report_Chart 
values (2, 1, 2,'{"rows":[{"name":"Sucursal"},{"name":"Boxes"},{"name":"EnEspera"}]}','{"cols":[{"id":"","label":"Sucursales","pattern":"","type":"string"},{"id":"","label":"Cantidad de Boxes","pattern":"","type":"number"},{"id":"","label":"Cantidad de Personas en Espera","pattern":"","type":"number"}],"rows":[{"c":[{"v":"9 de Julio"},{"v":"70"},{"v":"0"}]},{"c":[{"v":"Avellaneda"},{"v":"30"},{"v":"0"}]},{"c":[{"v":"Palestina"},{"v":"25"},{"v":"0"}]},{"c":[{"v":"Cordoba"},{"v":"20"},{"v":"0"}]},{"c":[{"v":"Pilar"},{"v":"20"},{"v":"1"}]},{"c":[{"v":"Rosario"},{"v":"20"},{"v":"0"}]},{"c":[{"v":"Corrientes"},{"v":"20"},{"v":"0"}]},{"c":[{"v":"Mar del Plata"},{"v":"20"},{"v":"0"}]},{"c":[{"v":"Martinez"},{"v":"20"},{"v":"0"}]},{"c":[{"v":"Mendoza"},{"v":"16"},{"v":"0"}]}]}
',sysdate-1, 10);