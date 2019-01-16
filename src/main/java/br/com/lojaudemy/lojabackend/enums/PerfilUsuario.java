package br.com.lojaudemy.lojabackend.enums;

public enum PerfilUsuario {

	ADMIN(1, "ROLE_ADMIN"),
	CLIENTE(2, "ROLE_CLIENTE");

	private Integer cod;
	private String nome;

	private PerfilUsuario(int codigo, String nome) {
		this.cod = codigo;
		this.nome = nome;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getNome() {
		return nome;
	}
	
	public static PerfilUsuario toEnum(Integer cod) {
		if(cod == null) {
			return null;
		} 
		
		for(PerfilUsuario x : PerfilUsuario.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("id inválido: " + cod);
	}
	
}
