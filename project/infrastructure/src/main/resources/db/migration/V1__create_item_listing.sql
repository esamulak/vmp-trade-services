CREATE SCHEMA IF NOT EXISTS trade;

CREATE TABLE trade.item_listing (
    id UUID PRIMARY KEY,
    created TIMESTAMP WITH TIME ZONE NOT NULL
);

CREATE TABLE trade.item_listing_item (
     item_listing_id UUID NOT NULL,
     item TEXT NOT NULL,

     CONSTRAINT fk_item_listing_item_listing
         FOREIGN KEY (item_listing_id)
             REFERENCES trade.item_listing (id)
);