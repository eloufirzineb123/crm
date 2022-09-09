package com.m2i.crm.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.m2i.crm.model.Order;


import java.io.IOException;


public class OrderSerializer extends StdSerializer<Order> {

    public OrderSerializer() {
        this(null);
    }

    public OrderSerializer(Class<Order> client) {
        super(client);
    }

    @Override
    public void serialize(Order order, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", order.getId());
        jsonGenerator.writeStringField("type", order.getType());
        jsonGenerator.writeStringField("label", order.getLabel());
        jsonGenerator.writeObjectFieldStart("customer");
        {
            jsonGenerator.writeNumberField("id", order.getCustomer().getId());
            jsonGenerator.writeStringField("firstName", order.getCustomer().getFirstName());
            jsonGenerator.writeStringField("lastName", order.getCustomer().getLastName());
            jsonGenerator.writeStringField("company", order.getCustomer().getCountry());
        }
        jsonGenerator.writeEndObject();
        jsonGenerator.writeNumberField("numberOfDays", order.getNumberOfDays());
        jsonGenerator.writeNumberField("unitPrice", order.getUnitPrice());
        jsonGenerator.writeNumberField("totalExcludeTaxe", order.getTotalExcludeTaxe());
        jsonGenerator.writeNumberField("totalWithTax", order.getTotalWithTaxe());
        jsonGenerator.writeStringField("status", order.getStatus());
        jsonGenerator.writeEndObject();
    }
}



    
   