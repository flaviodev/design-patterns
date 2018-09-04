package com.github.flaviodev.dp.model.base;

import java.io.Serializable;

public abstract class Entidade<I extends Serializable> {
	
	public abstract I getId();
	
	protected void persiste() {
		
	}
	
	protected void exclui() {
		
	}
	
	protected Entidade<I> altera(Entidade<I> entidade) {
		return null;
	}
 }
