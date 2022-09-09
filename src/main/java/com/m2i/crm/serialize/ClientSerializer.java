package com.m2i.crm.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.m2i.crm.model.Customer;
import com.m2i.crm.model.Order;

import java.io.IOException;


public class ClientSerializer extends StdSerializer<Customer>{
    public ClientSerializer() {
        this(null);
    }
    
    public ClientSerializer(Class<Customer> client) {
        super(client);
    }
    @Override
    public void serialize(Customer client, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", client.getId());
        jsonGenerator.writeStringField("firstName", client.getFirstName());
        jsonGenerator.writeStringField("lastName", client.getLastName());
        jsonGenerator.writeStringField("company", client.getCompany());
        jsonGenerator.writeStringField("mail", client.getMail());
        jsonGenerator.writeStringField("phone", client.getPhone());
        jsonGenerator.writeStringField("address", client.getAddress());
        jsonGenerator.writeStringField("zipCode", client.getZipCode());
        jsonGenerator.writeStringField("city", client.getCity());
        jsonGenerator.writeStringField("country", client.getCountry());
        jsonGenerator.writeStringField("active", client.getActive());
        
        jsonGenerator.writeArrayFieldStart("orders");
        for (Order o : client.getOrders()) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("id", o.getId());
            jsonGenerator.writeStringField("type", o.getType());
            jsonGenerator.writeStringField("label", o.getLabel());
       
           jsonGenerator.writeStringField("status", o.getStatus());
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();
        
        jsonGenerator.writeEndObject();
    }
}
