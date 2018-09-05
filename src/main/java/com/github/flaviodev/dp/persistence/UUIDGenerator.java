package com.github.flaviodev.dp.persistence;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class UUIDGenerator implements IdentifierGenerator {

	public static final String PACKAGE_PATH = "com.github.flaviodev.dp.persistence.UUIDGenerator";
	public static final String NAME = "UUIDGenerator";

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
