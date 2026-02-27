package com.masood.springjpahibernate.persistence;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.SharedCacheMode;
import jakarta.persistence.ValidationMode;
import jakarta.persistence.spi.ClassTransformer;
import jakarta.persistence.spi.PersistenceUnitInfo;
import jakarta.persistence.spi.PersistenceUnitTransactionType;

import javax.sql.DataSource;
import java.net.URL;
import java.util.List;
import java.util.Properties;

public class CustomPersistenceUnitInfo implements PersistenceUnitInfo {

    private final  String mPuName;

    private final String mPassword;

    public CustomPersistenceUnitInfo(String puName,String password) {
        this.mPuName = puName;
        this.mPassword = password;
    }


    @Override
    public String getPersistenceUnitName() {
        return this.mPuName;
    }

    @Override
    public String getPersistenceProviderClassName() {
        return "org.hibernate.jpa.HibernatePersistenceProvider";
    }

    @Override
    public List<String> getManagedClassNames() {
        return List.of("com.masood.springjpahibernate.m_1.entities.Product", "com.masood.springjpahibernate.m_2.entities.Employee");
    }


    @Override
    public DataSource getJtaDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:XE");
        dataSource.setUsername("C##MASOOD");
        dataSource.setPassword(this.mPassword);
        return dataSource;
    }


    @Deprecated
    @Override
    public PersistenceUnitTransactionType getTransactionType() {
        return  PersistenceUnitTransactionType.RESOURCE_LOCAL;
    }

    @Override
    public String getScopeAnnotationName() {
        return "";
    }


    @Override
    public List<String> getQualifierAnnotationNames() {
        return List.of();
    }



    @Override
    public DataSource getNonJtaDataSource() {
        return null;
    }

    @Override
    public List<String> getMappingFileNames() {
        return List.of();
    }

    @Override
    public List<URL> getJarFileUrls() {
        return List.of();
    }

    @Override
    public URL getPersistenceUnitRootUrl() {
        return null;
    }


    @Override
    public boolean excludeUnlistedClasses() {
        return false;
    }

    @Override
    public SharedCacheMode getSharedCacheMode() {
        return null;
    }

    @Override
    public ValidationMode getValidationMode() {
        return null;
    }

    @Override
    public Properties getProperties() {
        return null;
    }

    @Override
    public String getPersistenceXMLSchemaVersion() {
        return "";
    }

    @Override
    public ClassLoader getClassLoader() {
        return null;
    }

    @Override
    public void addTransformer(ClassTransformer classTransformer) {

    }

    @Override
    public ClassLoader getNewTempClassLoader() {
        return null;
    }

}
