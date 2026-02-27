package com.masood.springjpahibernate.m_4.entities.generators;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.generator.EventType;
import org.hibernate.id.IdentifierGenerator;

import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.Base64;
import java.util.UUID;

public class UUIDGenerator implements IdentifierGenerator {
    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) {
        return sign(UUID.randomUUID().toString());
    }

    private String sign(String primaryKey) {
        try {

            KeyPairGenerator kg = KeyPairGenerator.getInstance("RSA");
            kg.initialize(2048);
            KeyPair kp = kg.generateKeyPair();
            PrivateKey pk = kp.getPrivate();

            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(pk);
            signature.update(primaryKey.getBytes());
            byte [] result = signature.sign();

            return primaryKey + "." + Base64.getEncoder().encodeToString(result);
        }
        catch(Exception ee) {
            return primaryKey;
        }


    }

}
