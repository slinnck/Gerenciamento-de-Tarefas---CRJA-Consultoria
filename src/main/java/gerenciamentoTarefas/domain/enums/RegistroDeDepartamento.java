package gerenciamentoTarefas.domain.enums;

public enum RegistroDeDepartamento {
	
	FINANCEIRO(1, "Financeiro"),
	COMERCIAL(2, "Comercial"),
	DESENVOLVIMENTO(3, "Desenvolvimento");
	
	private int cod;
	private String descricao;
	
	private RegistroDeDepartamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static RegistroDeDepartamento toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(RegistroDeDepartamento rdd : RegistroDeDepartamento.values()) {
			if(cod.equals(rdd.getCod())) {
				return rdd;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
