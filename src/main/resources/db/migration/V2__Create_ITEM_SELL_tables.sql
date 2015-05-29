
CREATE TABLE ITEM_SELL
(
ITEM_SELL_ID BIGINT NOT NULL GENERATED BY DEFAULT AS IDENTITY
CONSTRAINT ITEM_SELL_PK PRIMARY KEY,
ITEM_SELL_ITEM_IN_ID BIGINT,
SELL_SIEZ NUMERIC(8,0),
SELL_PRICE DECIMAL(20,2),
SELL_DATETIME TIMESTAMP,
SELL_ADDRESS LONG VARCHAR,
SELL_TELPHONE NUMERIC(25,0)
);

ALTER TABLE ITEM_SELL ADD CONSTRAINT FOREIGNKEY_ITEM_IN_ID_FK
Foreign Key (ITEM_SELL_ITEM_IN_ID) REFERENCES ITEM_IN (ITEM_IN_ID);
