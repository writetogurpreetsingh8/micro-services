-- product catelogue's

insert into PRODUCT_CATELOGUE (PRODUCT_CATELOGUE_ID, NAME ,IS_ACTIVE,item_type,CREATED_ON,UDATED_ON) values (1,'Furniture',true,'Product-Catalogue',now(),now());
insert into PRODUCT_CATELOGUE (PRODUCT_CATELOGUE_ID, NAME ,IS_ACTIVE,item_type,CREATED_ON,UDATED_ON) values (2,'Home Decor',true,'Product-Catalogue',now(),now());
insert into PRODUCT_CATELOGUE (PRODUCT_CATELOGUE_ID, NAME ,IS_ACTIVE,item_type,CREATED_ON,UDATED_ON) values (3,'Fashion',true,'Product-Catalogue',now(),now());

-- product furniture
insert into PRODUCT (PRODUCT_ID , NAME ,IS_ACTIVE ,item_type,CREATED_ON ,UPDATED_ON ,PRODUCT_CATEGORY ,PRICE ,IS_ADDED_INTO_CART ,IS_IN_THE_STOCK ,QUANTITY,PRODUCT_CATELOGUE_ID_FK ) values (1,'Sofas',true,'Product',now(),now(),'Exotic',30000,false,true,50,1);

insert into PRODUCT (PRODUCT_ID , NAME ,IS_ACTIVE ,item_type,CREATED_ON ,UPDATED_ON ,PRODUCT_CATEGORY ,PRICE ,IS_ADDED_INTO_CART ,IS_IN_THE_STOCK ,QUANTITY,PRODUCT_CATELOGUE_ID_FK ) values (2,'Sofas',true,'Product',now(),now(),'Exotic',100000,false,true,5,1);


insert into PRODUCT (PRODUCT_ID , NAME ,IS_ACTIVE ,item_type,CREATED_ON ,UPDATED_ON ,PRODUCT_CATEGORY ,PRICE ,IS_ADDED_INTO_CART ,IS_IN_THE_STOCK ,QUANTITY,PRODUCT_CATELOGUE_ID_FK ) values (3,'Tables',true,'Product',now(),now(),'Regular',4000,false,true,100,1);


insert into PRODUCT (PRODUCT_ID , NAME ,IS_ACTIVE ,item_type,CREATED_ON ,UPDATED_ON ,PRODUCT_CATEGORY ,PRICE ,IS_ADDED_INTO_CART ,IS_IN_THE_STOCK ,QUANTITY,PRODUCT_CATELOGUE_ID_FK ) values (4,'Mattresses',true,'Product',now(),now(),'Exotic',30000,false,true,5,1);

--  product home decor
insert into PRODUCT (PRODUCT_ID , NAME ,IS_ACTIVE ,item_type,CREATED_ON ,UPDATED_ON ,PRODUCT_CATEGORY ,PRICE ,IS_ADDED_INTO_CART ,IS_IN_THE_STOCK ,QUANTITY,PRODUCT_CATELOGUE_ID_FK ) values (5,'Table Lamp',true,'Product',now(),now(),'Exotic',5000,false,true,50,2);

insert into PRODUCT (PRODUCT_ID , NAME ,IS_ACTIVE ,item_type,CREATED_ON ,UPDATED_ON ,PRODUCT_CATEGORY ,PRICE ,IS_ADDED_INTO_CART ,IS_IN_THE_STOCK ,QUANTITY,PRODUCT_CATELOGUE_ID_FK ) values (6,'Table Lamp',true,'Product',now(),now(),'Regular',1000,false,true,500,2);

insert into PRODUCT (PRODUCT_ID , NAME ,IS_ACTIVE ,item_type,CREATED_ON ,UPDATED_ON ,PRODUCT_CATEGORY ,PRICE ,IS_ADDED_INTO_CART ,IS_IN_THE_STOCK ,QUANTITY,PRODUCT_CATELOGUE_ID_FK ) values (7,'Vase',true,'Product',now(),now(),'Exotic',7000,false,true,20,2);

insert into PRODUCT (PRODUCT_ID , NAME ,IS_ACTIVE ,item_type,CREATED_ON ,UPDATED_ON ,PRODUCT_CATEGORY ,PRICE ,IS_ADDED_INTO_CART ,IS_IN_THE_STOCK ,QUANTITY,PRODUCT_CATELOGUE_ID_FK ) values (8,'Vase',true,'Product',now(),now(),'Regular',2000,false,true,200,2);

insert into PRODUCT (PRODUCT_ID , NAME ,IS_ACTIVE ,item_type,CREATED_ON ,UPDATED_ON ,PRODUCT_CATEGORY ,PRICE ,IS_ADDED_INTO_CART ,IS_IN_THE_STOCK ,QUANTITY,PRODUCT_CATELOGUE_ID_FK ) values (9,'Sheep Skin',true,'Product',now(),now(),'Exotic',7000,false,true,200,2);

insert into PRODUCT (PRODUCT_ID , NAME ,IS_ACTIVE ,item_type,CREATED_ON ,UPDATED_ON ,PRODUCT_CATEGORY ,PRICE ,IS_ADDED_INTO_CART ,IS_IN_THE_STOCK ,QUANTITY,PRODUCT_CATELOGUE_ID_FK ) values (10,'Wooden or Glass Boxs',true,'Product',now(),now(),'Regular',3000,false,true,10,2);

-- product fashion

insert into PRODUCT (PRODUCT_ID , NAME ,IS_ACTIVE ,item_type,CREATED_ON ,UPDATED_ON ,PRODUCT_CATEGORY ,PRICE ,IS_ADDED_INTO_CART ,IS_IN_THE_STOCK ,QUANTITY,PRODUCT_CATELOGUE_ID_FK ) values (11,'Luggages',true,'Product',now(),now(),'Exotic',3000,false,true,200,3);

insert into PRODUCT (PRODUCT_ID , NAME ,IS_ACTIVE ,item_type,CREATED_ON ,UPDATED_ON ,PRODUCT_CATEGORY ,PRICE ,IS_ADDED_INTO_CART ,IS_IN_THE_STOCK ,QUANTITY,PRODUCT_CATELOGUE_ID_FK ) values (12,'Wedding Dresses',true,'Product',now(),now(),'Exotic',300000,false,true,20,3);


insert into PRODUCT (PRODUCT_ID , NAME ,IS_ACTIVE ,item_type,CREATED_ON ,UPDATED_ON ,PRODUCT_CATEGORY ,PRICE ,IS_ADDED_INTO_CART ,IS_IN_THE_STOCK ,QUANTITY,PRODUCT_CATELOGUE_ID_FK ) values (13,'Wedding Dress',true,'Product',now(),now(),'Regular',300000,false,true,200,3);


insert into PRODUCT (PRODUCT_ID , NAME ,IS_ACTIVE ,item_type,CREATED_ON ,UPDATED_ON ,PRODUCT_CATEGORY ,PRICE ,IS_ADDED_INTO_CART ,IS_IN_THE_STOCK ,QUANTITY,PRODUCT_CATELOGUE_ID_FK ) values (14,'Stockings',true,'Product',now(),now(),'Regular',300000,false,true,200,3);


insert into PRODUCT (PRODUCT_ID , NAME ,IS_ACTIVE ,item_type,CREATED_ON ,UPDATED_ON ,PRODUCT_CATEGORY ,PRICE ,IS_ADDED_INTO_CART ,IS_IN_THE_STOCK ,QUANTITY,PRODUCT_CATELOGUE_ID_FK ) values (15,'Handbags',true,'Product',now(),now(),'Exotic',30000,false,true,50,3);


insert into PRODUCT (PRODUCT_ID , NAME ,IS_ACTIVE ,item_type,CREATED_ON ,UPDATED_ON ,PRODUCT_CATEGORY ,PRICE ,IS_ADDED_INTO_CART ,IS_IN_THE_STOCK ,QUANTITY,PRODUCT_CATELOGUE_ID_FK ) values (16,'Handbags',true,'Product',now(),now(),'Regular',2000,false,true,500,3);


insert into PRODUCT (PRODUCT_ID , NAME ,IS_ACTIVE ,item_type,CREATED_ON ,UPDATED_ON ,PRODUCT_CATEGORY ,PRICE ,IS_ADDED_INTO_CART ,IS_IN_THE_STOCK ,QUANTITY,PRODUCT_CATELOGUE_ID_FK ) values (17,'Sandals',true,'Product',now(),now(),'Regular',2000,false,true,500,3);


insert into PRODUCT (PRODUCT_ID , NAME ,IS_ACTIVE ,item_type,CREATED_ON ,UPDATED_ON ,PRODUCT_CATEGORY ,PRICE ,IS_ADDED_INTO_CART ,IS_IN_THE_STOCK ,QUANTITY,PRODUCT_CATELOGUE_ID_FK ) values (18,'Swimfins',true,'Product',now(),now(),'Regular',1000,false,true,100,3);
